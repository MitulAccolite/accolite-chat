package com.accolite.chat.Main;

import com.accolite.chat.*;
import com.accolite.chat.controller.ChatController;
import com.accolite.chat.forms.RegistrationForm;
import com.accolite.chat.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by Sachin Gupta on 8/9/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:dispatcher-servlet.xml"})
@WebAppConfiguration
@TestExecutionListeners(inheritListeners = false, listeners
        = {DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class})
public class JunitTesting {

    @Autowired
    private WebApplicationContext wac;


    private MockMvc mockMvc;
    GroupUsers gr;
    ChatGroup ch;
    UserRegistration registerUser;
    Notification n;
    RegistrationForm r;
    User u;
    Credential c;
    Role role;
    Date d;
    Roles roles;
    List<Role> role1;
    List<User> userList;
    List<Message> messagelist;
    List<Message> messagelist1;
    Message m;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);

        messagelist=new ArrayList<Message>();
        messagelist1=new ArrayList<Message>();
        m=new Message();
        gr=new GroupUsers();
        d=new Date();
        r=new RegistrationForm();

        gr.setGroupID(2);
        gr.setJoined(d);
        gr.setUserID(30);

        m.setId(3);
        m.setCreated(d);
        m.setMessage("hello world");

        registerUser=new UserRegistration("sachin1995@gmail.com","123","Sachin","","Gupta","Sac","9999999999");

        roles=new Roles();

        n=new Notification("sachin.1995in@gmail.com","Notify");

        role=new Role();

        userList=new ArrayList<User>();

        role1=new ArrayList<Role>();


        r.setEmail("sachin@gmail.com");
        r.setFirstName("sachin");
        r.setLastName("gupta");
        r.setMiddleName("");
        r.setNickName("Sac");
        r.setNumber("1");

        role1.add(role);

        c=new Credential("Sachin","Hi",d,d);

        u=new User("Momin","","Yadav",d,d,true,"Hey","momin@gmail.com",role1,c);
        userList.add(u);

        role.setId(1);
        role.setRole("User");
        role.setUsers(userList);



        ch=new ChatGroup("Friends",d);
        ch.setId(1);
        ch.setUsers(userList);
        messagelist.add(m);
        ch.setMessages(messagelist);


        m.setChatGroup(ch);
        m.setUser(u);
        messagelist1.add(m);
    }


    @Test
    public void getStarted() throws Exception {

        System.out.print(mockMvc.perform(get("/getstarted")));

        System.out.print("sachin");
        //mockMvc.perform(get("/getstarted")).andExpect(content().string(""));
        MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/getstarted"))
                .andExpect(status().isOk())
                .andExpect(view().name("authenticate"));
        //.andExpect(content().string(""));
        System.out.print("sachin");

    }
/*
    @Test
    public void registerUser() throws Exception {

        //System.out.print(mockMvc.perform(get("/registered_user")));

        //System.out.print(registerUser.toString());
        //System.out.print("sachin");
        //mockMvc.perform(get("/getstarted")).andExpect(content().string(""));
        MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/registered_user")
                .flashAttr("user",registerUser))
                .andExpect(status().isOk())
                .andExpect(view().name("registered_user"));
        //.andExpect(content().string(""));
        System.out.print("registered_user");

    }*/
/*
    @Test
    public void register1() throws Exception {

        //System.out.print(mockMvc.perform(get("/getstarted")));

        System.out.print("sachin");
        //mockMvc.perform(get("/getstarted")).andExpect(content().string(""));
        MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register"));
        //.andExpect(content().string(""));
        System.out.print("sachin");

    }*/

    @Test
    public void validateUser()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/validate")
                    .param("user_login","sachin").param("user_password","123"))
                    .andExpect(status().isOk()).andExpect(view().name("error404"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void validateUser1()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/validate")
                    .param("user_login","sachin1").param("user_password","1234"))
                    .andExpect(status().isOk()).andExpect(view().name("error404"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProfileView()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/profileView")
                    .param("user","sachin1"))
                    .andExpect(status().isOk()).andExpect(view().name("error403"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getProfileView1()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/profileView")
                    .param("user","sachin1"))
                    .andExpect(status().isOk()).andExpect(view().name("error403"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Logout()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/logout"))
                    .andExpect(status().isOk()).andExpect(view().name("authenticate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void userProfile()
    {

        try {
            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(get("/userprofile")
                    .param("user","Sachin"))
                    .andExpect(status().isOk()).andExpect(view().name("userprofile"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Test
    public void testGetProfileView()
    {

        try {
            int a=1;
            int b=2;

            MockMvcBuilders.standaloneSetup(new ChatController()).build().perform(post("/profileView")
                    .param("message","Hi").param("userId",""+a).param("userEmail","sachin1995in@gmail.com")
                    .param("created","")
                    .param("groupId",""+b)
            ).andExpect(status().isOk()).andExpect(view().name("userprofile"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void getEmail()
    {
        String email=r.getEmail();
        Assert.assertEquals("sachin@gmail.com",email);
    }
    @Test
    public void getFirst()
    {
        String f=r.getFirstName();
        Assert.assertEquals("sachin",f);
    }

    @Test
    public void getLast()
    {
        String l=r.getLastName();
        Assert.assertEquals("gupta",l);
    }

    @Test
    public void getMiddle()
    {
        String m=r.getMiddleName();
        Assert.assertEquals("",m);
    }
    @Test
    public void getNick()
    {
        String n=r.getNickName();
        Assert.assertEquals("Sac",n);
    }

    @Test
    public void getNum()
    {
        String n1=r.getNumber();
        Assert.assertEquals("1",n1);
    }

    @Test
    public void getUserFirstName()
    {
        String f=u.getFirstName();
        Assert.assertEquals(f,"Momin");
    }
    @Test
    public void getUserMiddleName()
    {
        String f=u.getMiddleName();
        Assert.assertEquals(f,"");
    }

    @Test
    public void getUserLastName()
    {
        String f=u.getLastName();
        Assert.assertEquals(f,"Yadav");
    }
    @Test
    public void getUserCreated()
    {
        Date f=u.getCreated();
        Assert.assertEquals(f,d);
    }
    @Test
    public void getUserUpdated()
    {
        Date f=u.getUpdated();
        Assert.assertEquals(f,d);
    }

    @Test
    public void getUserEmailId()
    {
        String f=u.getEmail();
        Assert.assertEquals(f,"momin@gmail.com");
    }

    @Test
    public void getUserCredentials()
    {
        Credential f=u.getCredential();
        Assert.assertEquals(f,c);
    }


    @Test
    public void getUserRoles()
    {
        List<Role> f=u.getRoles();
        Assert.assertEquals(f,role1);
    }

    @Test
    public void getRoleId()
    {
        Integer a=role.getId();
        Integer b=1;
        Assert.assertEquals(a,b);
    }

    @Test
    public void getRole()
    {
        String f=role.getRole();
        Assert.assertEquals(f,"User");
    }

    @Test
    public void getListUsers()
    {
        List<User> f=role.getUsers();
        Assert.assertEquals(f,userList);
    }

    @Test
    public void getEmailNotification()
    {
        String f=n.getEmail();
        Assert.assertEquals(f,"sachin.1995in@gmail.com");
    }

    @Test
    public void getDetails()
    {
        String f=n.getDetails();
        Assert.assertEquals(f,"Notify");
    }

    @Test
    public void getFirst1()
    {
        String f=registerUser.getFirstName();
        Assert.assertEquals("Sachin",f);
    }

    @Test
    public void getLast1()
    {
        String l=registerUser.getLastName();
        Assert.assertEquals("Gupta",l);
    }

    @Test
    public void getMiddle1()
    {
        String m=registerUser.getMiddleName();
        Assert.assertEquals("",m);
    }
    @Test
    public void getNick1()
    {
        String n=registerUser.getNickName();
        Assert.assertEquals("Sac",n);
    }

    @Test
    public void getEmail1()
    {
        String email=registerUser.getUserMail();
        Assert.assertEquals("sachin1995@gmail.com",email);
    }

    @Test
    public void getPassword1()
    {
        String f=registerUser.getUserPassword();
        Assert.assertEquals("123",f);
    }

    @Test
    public void getNumber()
    {
        String f=registerUser.getUserMobile();
        Assert.assertEquals("9999999999",f);
    }

    @Test
    public void getChatGroupId()
    {
        Integer f=ch.getId();
        Integer a=1;
        Assert.assertEquals(f,a);
    }

    @Test
    public void getChatGroupUsers()
    {
        List<User> f=ch.getUsers();
        Assert.assertEquals(userList,f);
    }

    @Test
    public void getChatGroupMessages()
    {
        List<Message> f=ch.getMessages();
        Assert.assertEquals(messagelist1,f);
    }

    @Test
    public void getMessageId()
    {
        Integer f=m.getId();
        Integer a=3;
        Assert.assertEquals(a,f);
    }

    @Test
    public void getMessageDate()
    {
        Date f=m.getCreated();
        Assert.assertEquals(d,f);
    }

    @Test
    public void getMessDetails()
    {
        String f=m.getMessage();
        Assert.assertEquals("hello world",f);
    }

    @Test
    public void MessChatGroup()
    {
        ChatGroup f=m.getChatGroup();
        Assert.assertEquals(ch,f);
    }

    @Test
    public void getMessUser()
    {
        User f=m.getUser();
        Assert.assertEquals(u,f);
    }

    @Test
    public void getGroupId()
    {
        Integer f=gr.getGroupID();
        Integer a=2;
        Assert.assertEquals(a,f);
    }


    @Test
    public void getUserID()
    {
        Integer f=gr.getUserID();
        Integer a=30;
        Assert.assertEquals(a,f);
    }

    @Test
    public void getGroupJoinDate()
    {
        Date f=gr.getJoined();
        //Integer a=2;
        Assert.assertEquals(d,f);
    }









}
