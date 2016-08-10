package com.accolite.chat.controller;

import com.accolite.chat.dao.*;
import com.accolite.chat.dao.impl.*;
import com.accolite.chat.model.*;
import com.accolite.chat.model.Message;
import com.accolite.chat.model.Role;
import manager.ChatManager;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Mitul Kapoor on 7/31/2016.
 */
@Controller
public class ChatController {


    @RequestMapping(value = "/getstarted")
    public ModelAndView getStarted(HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("authenticate");
        return modelAndView;
    }

    @RequestMapping(value = "/registered_user")
    public ModelAndView registeredUser(
                                              @ModelAttribute("user")UserRegistration registration,
                                              HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("registered_user");
        String firstName = registration.getFirstName();
        String middleName = registration.getMiddleName();
        String lastName = registration.getLastName();
        String nickName = registration.getNickName();
        String email = registration.getUserMail();
        String password = registration.getUserPassword();
        String phone = registration.getUserMobile();
        System.out.println(registration.toString());
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        //check whether the user is already registereed or not.
        //to be done here.

        Role role = new Role(Roles.USER);
        List<Role> userRole = new ArrayList<Role>();
        userRole.add(role);
        Credential credential = new Credential(email,password,date,date);

        User user = new User(firstName,middleName,lastName,date,date,true,nickName,email,userRole,credential);
        UserDao userDao = new UserDao();
        userDao.addNewUser(user);

        ILoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        loginCredentialsDao.addUser(credential);

        IUserRoleDao userRoleDao = new UserRoleDao();
        userRoleDao.addUserRole(userDao.getUserId(email), Roles.USER);

        OfflineUsers offlineUsers = new OfflineUsers();
        offlineUsers.notifyUsersForNewRegistration(firstName,nickName);

        return modelAndView;
    }


    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest servletRequest) throws Exception {
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @RequestMapping(value = "/validate")
    public ModelAndView validateUserCredentials(
                                                       @RequestParam("user_login")String username,
                                                       @RequestParam("user_password")String password,
                                                       HttpServletRequest servletRequest) throws Exception {

        System.out.println("username : " + username);
        System.out.println("password : " + password);

        ModelAndView modelAndView  = null;
        ILoginCredentialsDao loginCredentialsDao = new LoginCredentialsDao();
        Credential user = loginCredentialsDao.verifyCredentials(username, password);
        if (user==null) {
            return new ModelAndView("error404");
        }
        System.out.println("User Details : ");
        System.out.println("Username : " + user.getUsername());
        System.out.println("Password : " + user.getPassword());
        modelAndView = new ModelAndView("chat_room");
        IUserDao userDao = new UserDao();
        User user1 = userDao.findUserByEmail(user.getUsername());

        servletRequest.getSession().setAttribute("user",user1);
        modelAndView.addObject("user", user1);
        ChatManager.setUserOnline(user1);


        ///////
        List<Message> message = (List<Message>) (new MessageDao()).showMessagesToPersonInGroup(user1.getId(),1);
        modelAndView.addObject("messages",message);

        if(message.size() >0 ) {
            for (Message message1 : message) {
                System.out.println("user : " + message1.getUser().getNickName() + " message : " + message1.getMessage());
            }
        }

        /////

        return modelAndView;
    }

    @RequestMapping(value = "/profileView")
    public ModelAndView profileView(
                                           @RequestParam("user")String username,
                                           HttpServletRequest servletRequest) throws Exception {

        if(servletRequest.getSession().getAttribute("user")==null){
            return new ModelAndView("error403");
        }

        ModelAndView modelAndView = new ModelAndView("profile_view");
        IUserDao userDao = new UserDao();
        System.out.println("user email : " + username);
        User user = userDao.findUserByEmail(username);

        modelAndView.addObject("user",user);
        System.out.println("Profile view : ");
        System.out.println("user name : " + user.getFirstName());
        return modelAndView;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("authenticate");
        servletRequest.getSession().removeAttribute("user");
        servletRequest.getSession().invalidate();
        return modelAndView;
    }

    @RequestMapping(value = "/sendMessage",method = RequestMethod.POST)
    public ModelAndView postMessage(
                                           @RequestParam("message")String message,
                                           @RequestParam("userID")int userid,
                                           @RequestParam("userEmail")String userEmail,
                                           @RequestParam("created")Long date,
                                           @RequestParam("groupID")int groupid,
                                           HttpServletRequest servletRequest){

        System.out.println("values obtained : " + message + " : " + userid);
        IMessageDao messageDao = new MessageDao();
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(userEmail);
        Message message1 = new Message(message,new Date(date),user);

        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup chatGroup = chatGroupDao.findById(groupid);
        System.out.println(chatGroup);
        message1.setChatGroup(chatGroup);

        messageDao.save(message1);

        System.out.println("Message saved successfully");

        return poll(servletRequest,userid,groupid,message1.getCreated().getTime()-10);
        //return message;
    }

    @RequestMapping(value = "userprofile")
    public ModelAndView userprofile(HttpServletRequest servletRequest,
                                    @RequestParam("user")String email){

        ModelAndView modelAndView = new ModelAndView("userprofile");
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "profile_edit")
    public ModelAndView profileEdit(HttpServletRequest servletRequest,
                                    @RequestParam("user")String email){

        ModelAndView modelAndView = new ModelAndView("profile_edit");
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "groupView")
    public ModelAndView groupView(HttpServletRequest servletRequest,
                                  @RequestParam("groupID")int groupID,
                                  @RequestParam("userEmail")String email
                                  ){
        ModelAndView modelAndView = new ModelAndView("groupview");
        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup group = chatGroupDao.getChatGroupById(groupID);

        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);

        modelAndView.addObject("user",user);
        modelAndView.addObject("group",group);
        return modelAndView;
    }

    @RequestMapping(value = "/update_firstName",method = RequestMethod.POST )
    public ModelAndView updateFirstName( @RequestParam("user")String userEmail,
                                   @RequestParam("update")String update,
                                   HttpServletRequest servletRequest){
        IUserDao userDao = new UserDao();
        userDao.updateFirstNameByEmail(userEmail,update);

        User user = userDao.findUserByEmail(userEmail);

        ModelAndView modelAndView = new ModelAndView("userprofile");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/update_middleName",method = RequestMethod.POST )
    public ModelAndView updateMiddleName( @RequestParam("user")String userEmail,
                                         @RequestParam("update")String update,
                                         HttpServletRequest servletRequest){
        IUserDao userDao = new UserDao();
        userDao.updateMiddleNameByEmail(userEmail,update);

        User user = userDao.findUserByEmail(userEmail);

        ModelAndView modelAndView = new ModelAndView("userprofile");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/update_lastName",method = RequestMethod.POST )
    public ModelAndView updateLastName( @RequestParam("user")String userEmail,
                                         @RequestParam("update")String update,
                                         HttpServletRequest servletRequest){
        IUserDao userDao = new UserDao();
        userDao.updateLastNameByEmail(userEmail,update);

        User user = userDao.findUserByEmail(userEmail);

        ModelAndView modelAndView = new ModelAndView("userprofile");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/update_nickName",method = RequestMethod.POST )
    public ModelAndView updateNickName( @RequestParam("user")String userEmail,
                                         @RequestParam("update")String update,
                                         HttpServletRequest servletRequest){
        IUserDao userDao = new UserDao();
        userDao.updateNickNameByEmail(userEmail,update);

        User user = userDao.findUserByEmail(userEmail);

        ModelAndView modelAndView = new ModelAndView("userprofile");
        modelAndView.addObject("user",user);
        return modelAndView;
    }

    @RequestMapping(value = "/update_groupName",method = RequestMethod.POST )
    public ModelAndView updateGroupName( @RequestParam("user")String userEmail,
                                         @RequestParam("groupID")int groupID,
                                        @RequestParam("update")String update,
                                        HttpServletRequest servletRequest){
        ModelAndView modelAndView = new ModelAndView("groupview");
        IChatGroupDao chatGroupDao = new ChatGroupDao();
        chatGroupDao.updateGroupNameByID(groupID,update);
        ChatGroup group = chatGroupDao.getChatGroupById(groupID);

        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(userEmail);

        modelAndView.addObject("user",user);
        modelAndView.addObject("group",group);
        return modelAndView;
    }

    @RequestMapping(value = "group_edit")
    public ModelAndView profileEdit(HttpServletRequest servletRequest,
                                    @RequestParam("groupID")int groupID,
                                    @RequestParam("userEmail")String email
    ){
        ModelAndView modelAndView = new ModelAndView("group_edit");
        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup group = chatGroupDao.getChatGroupById(groupID);
        ChatGroup pGroup = chatGroupDao.getChatGroupById(1);//public group

        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);

        List<Integer> gUID=new ArrayList<Integer>();
        List<User> gUsers = group.getUsers();

        for(User u:gUsers){
            gUID.add(u.getId());
        }

        List<User> nonGUsers = new ArrayList<User>();

        for (User u: pGroup.getUsers()){
            if(!(gUID.indexOf(u.getId())>-1)){
                nonGUsers.add(u);
            }
        }

//        for(User u:gUsers){
//            System.out.println(u.getNickName());
//        }
//
//        for(User u:nonGUsers){
//            System.out.println(u.getNickName());
//        }

        modelAndView.addObject("user",user);
        modelAndView.addObject("group",group);
        modelAndView.addObject("gUsers",gUsers);
        modelAndView.addObject("nonGUsers",nonGUsers);
        return modelAndView;
    }

    @RequestMapping(value = "group_create")
    public ModelAndView groupCreatePage(HttpServletRequest servletRequest,
                                    @RequestParam("user")String email){

        ModelAndView modelAndView = new ModelAndView("group_create");
        IUserDao userDao = new UserDao();
        User user = userDao.findUserByEmail(email);

        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup pGroup = chatGroupDao.getChatGroupById(1);
        List<User> allUsers=pGroup.getUsers();

        modelAndView.addObject("user",user);
        modelAndView.addObject("pGroup",allUsers);
        return modelAndView;
    }

    @RequestMapping(value = "groupCreate")
    public ModelAndView groupCreate(HttpServletRequest servletRequest,
                                    @RequestParam("user")String email,
                                    @RequestParam("groupName")String groupName,
                                    @RequestParam("userList[]")int[] userList){

        IChatGroupDao chatGroupDao = new ChatGroupDao();
        ChatGroup group = new ChatGroup(groupName,new Date());

        IUserDao userDao = new UserDao();

        for(int i=0;i<userList.length;i++){
            System.out.println(userList[i]);
            group.addUser(userDao.findUserByUserId(userList[i]));
        }

        chatGroupDao.add(group);

        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        mav.addObject("groupID", group.getId());
        return mav;
    }

    @RequestMapping(value = "getGroup")
    public ModelAndView getGroup(HttpServletRequest servletRequest,
                                        @RequestParam("user")int userID,
                                        @RequestParam("groupID")int groupID){
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        MessageDao messageDao = new MessageDao();
        List<Message> messages=(List<Message>)messageDao.showMessagesToPersonInGroup(userID, groupID);

        List<GMessage> gms=new ArrayList<GMessage>();
        for(Message msg:messages){
            gms.add(new GMessage(msg.getMessage(),msg.getCreated().getTime(),msg.getUser().getEmail(),msg.getUser().getNickName()));
        }
        mav.addObject("messages",gms);

        ChatGroupDao chatGroupDao = new ChatGroupDao();
//        UserDao userDao = new UserDao();
//        User usr=userDao.findUserByUserId(userID);
//        List<ListGroups> allNewGroups=new ArrayList<ListGroups>();
//        List<ChatGroup> chatGroupList=usr.getChatGroups();
//        for(ChatGroup cg:chatGroupList)
//        {
//            ListGroups obj=new ListGroups(cg.getId(),cg.getName());
//            allNewGroups.add(obj);
//        }
//        mav.addObject("groups", allNewGroups);

        ChatGroup cg=chatGroupDao.findById(groupID);
        List<User> gUsers=cg.getUsers();
        List<OnlineUsers> allNewUsers=new ArrayList<OnlineUsers>();
        Set<User> users=ChatManager.getActiveUsers();
        List<Integer> gUID=new ArrayList<Integer>();

        for(User u:gUsers){
            gUID.add(u.getId());
        }

        List<User> nonActiveGUsers = new ArrayList<User>();
        List<User> activeGUsers = new ArrayList<User>();
        List<Integer> aGUID=new ArrayList<Integer>();
        for (User u: users){
            if(gUID.indexOf(u.getId())>-1&&u.getId()!=userID){
                activeGUsers.add(u);
                aGUID.add(u.getId());
            }
        }

        for (User u: gUsers){
            if(u.getId()!=userID&&!(aGUID.indexOf(u.getId())>-1)){
                nonActiveGUsers.add(u);
            }
        }

        for (User u:activeGUsers) {
            OnlineUsers obj=new OnlineUsers(u.getEmail(),u.getNickName(),true);
            allNewUsers.add(obj);
        }
        for (User u:nonActiveGUsers) {
            OnlineUsers obj=new OnlineUsers(u.getEmail(),u.getNickName(),false);
            allNewUsers.add(obj);
        }
        mav.addObject("activeUsers",allNewUsers);

        return mav;
    }

    @RequestMapping(value = "poll")
    public ModelAndView poll(HttpServletRequest servletRequest,
                                 @RequestParam("user")int userID,
                                 @RequestParam("groupID")int groupID,
                                @RequestParam("lastUpdated")long lastUpdate){
        if(lastUpdate==-1)
            return getGroup(servletRequest,userID,groupID);
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        MessageDao messageDao = new MessageDao();
        List<Message> messages=(List<Message>)messageDao.pollMessagesToPersonInGroup(userID, groupID,new Date(lastUpdate));

        List<GMessage> gms=new ArrayList<GMessage>();
        for(Message msg:messages){
            gms.add(new GMessage(msg.getMessage(),msg.getCreated().getTime(),msg.getUser().getEmail(),msg.getUser().getNickName()));
        }
        mav.addObject("messages",gms);

        ChatGroupDao chatGroupDao = new ChatGroupDao();
//        UserDao userDao = new UserDao();
//        User usr=userDao.findUserByUserId(userID);
//        List<ListGroups> allNewGroups=new ArrayList<ListGroups>();
//        List<ChatGroup> chatGroupList=usr.getChatGroups();
//        for(ChatGroup cg:chatGroupList)
//        {
//            ListGroups obj=new ListGroups(cg.getId(),cg.getName());
//            allNewGroups.add(obj);
//        }
//        mav.addObject("groups", allNewGroups);

        ChatGroup cg=chatGroupDao.findById(groupID);
        List<User> gUsers=cg.getUsers();
        List<OnlineUsers> allNewUsers=new ArrayList<OnlineUsers>();
        Set<User> users=ChatManager.getActiveUsers();
        List<Integer> gUID=new ArrayList<Integer>();

        for(User u:gUsers){
            gUID.add(u.getId());
        }

        List<User> nonActiveGUsers = new ArrayList<User>();
        List<User> activeGUsers = new ArrayList<User>();
        List<Integer> aGUID=new ArrayList<Integer>();
        for (User u: users){
            if(gUID.indexOf(u.getId())>-1&&u.getId()!=userID){
                activeGUsers.add(u);
                aGUID.add(u.getId());
            }
        }

        for (User u: gUsers){
            if(u.getId()!=userID&&!(aGUID.indexOf(u.getId())>-1)){
                nonActiveGUsers.add(u);
            }
        }

        for (User u:activeGUsers) {
            OnlineUsers obj=new OnlineUsers(u.getEmail(),u.getNickName(),true);
            allNewUsers.add(obj);
        }
        for (User u:nonActiveGUsers) {
            OnlineUsers obj=new OnlineUsers(u.getEmail(),u.getNickName(),false);
            allNewUsers.add(obj);
        }
        mav.addObject("activeUsers",allNewUsers);
        return mav;
    }

//        @RequestMapping(value = "/poll")
//        public ModelAndView poll(HttpServletRequest servletRequest,
//                                        @RequestParam("user")String email,
//                                        @RequestParam("groupID")int groupID,
//                                        @RequestParam("lastUpdated")long lastUpdated){
//
//            final ObjectMapper mapper=new ObjectMapper();
//
//            ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//            MessageDao messageDao = new MessageDao();
//            ChatGroupDao chatGroupDao = new ChatGroupDao();
//            UserDao userDao = new UserDao();
//                User user = userDao.findUserByEmail(email);
//                List<ChatGroup> allNewGroups;
//                List<Message> allNewMessages=new ArrayList<Message>();
//                List<User> allNewUsers;
//                System.out.println(lastUpdated);
//                if (lastUpdated == -1) {
//                    System.out.println("show");
//                    try{
//                        allNewMessages = messageDao.showMessagesToPersonInGroup(user.getId(), groupID);
//                    }catch (NullPointerException e){
//                        e.printStackTrace();
//                    }
//                } else {
//                    System.out.println("poll");
//                    try {
//                        System.out.println(user.getId()+" "+ groupID);
//                        allNewMessages = messageDao.pollMessagesToPersonInGroup(user.getId(), groupID, new Date(lastUpdated));
//                    }catch (NullPointerException e){
//                        e.printStackTrace();
//                    }
//                }
//                //        mav.addObject("groups",allNewGroups);
//                //        mav.addObject("users",allNewUsers);
//                //        try {
//                mav.addObject("messages", allNewMessages);
//                //            mav.addObject("mmessages",mapper.writeValueAsString(allNewMessages));
//                //        } catch (IOException e) {
//                //            e.printStackTrace();
//                //        }
//            return mav;
//        }

//    @RequestMapping(value = "/pollGroup")
//    public ModelAndView pollGroup(HttpServletRequest servletRequest,
//                             @RequestParam("user")String email){
//
//        final ObjectMapper mapper=new ObjectMapper();
//
//        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//        try {
//
//            ChatGroupDao chatGroupDao = new ChatGroupDao();
//            UserDao userDao = new UserDao();
//            //User user = userDao.findUserByEmail(email);
//            List<ChatGroup> allNewGroups;
//            List<User> allNewUsers;
//            allNewGroups=new ArrayList<ChatGroup>();
//            User user=userDao.allGroupsForUser(email);
//
//            try{
//                allNewGroups=user.getChatGroups();
//
//            }catch (NullPointerException e){
//                e.printStackTrace();
//            }
//
//            //        mav.addObject("groups",allNewGroups);
//            //        mav.addObject("users",allNewUsers);
//            //        try {
//            mav.addObject("groups", allNewGroups);
//            //            mav.addObject("mmessages",mapper.writeValueAsString(allNewMessages));
//            //        } catch (IOException e) {
//            //            e.printStackTrace();
//            //        }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return mav;
//    }
//
//    @RequestMapping(value = "/pollActiveUsers")
//    public ModelAndView pollActiveUsers(HttpServletRequest servletRequest){
//
//        final ObjectMapper mapper=new ObjectMapper();
//
//        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
//        Set<User> allNewUsers;
//        allNewUsers=new HashSet<User>();
//        try {
//
//            try{
//                allNewUsers = ChatManager.getActiveUsers();
//            }catch (NullPointerException e){
//                e.printStackTrace();
//            }
//
//
//
//            //        mav.addObject("groups",allNewGroups);
//            //        mav.addObject("users",allNewUsers);
//            //        try {
//            mav.addObject("activeUsers",allNewUsers);
//            //            mav.addObject("mmessages",mapper.writeValueAsString(allNewMessages));
//            //        } catch (IOException e) {
//            //            e.printStackTrace();
//            //        }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return mav;
//    }
}