package manager;

import com.accolite.chat.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mitul Kapoor on 8/3/2016.
 */
public class ChatManager {
    //private static Set<User> activeUsers = new  (Set<User>) new ArrayList<User>();

    private static Set<User> activeUsers = new HashSet<User>();

    public static void setUserOnline(User user){
        for(User u:activeUsers){
            if(u.getEmail().equals(user.getEmail()))
                return;
        }
        activeUsers.add(user);
    }

    public static void setUserOffline(User user){
        activeUsers.remove(user);
    }

    public static void setActiveUsers(Set<User> activeUsers) {
        ChatManager.activeUsers = activeUsers;
    }

    public static Set<User> getActiveUsers() {
        return activeUsers;
    }
}
