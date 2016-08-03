package manager;

import com.accolite.chat.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mitul Kapoor on 8/3/2016.
 */
public class ChatManager {
    private static List<User> activeUsers = new ArrayList<User>();

    public static void setUserOnline(User user){
        activeUsers.add(user);
    }

    public static void setUserOffline(User user){
        activeUsers.remove(user);
    }

    public static void setActiveUsers(List<User> activeUsers) {
        ChatManager.activeUsers = activeUsers;
    }

    public static List<User> getActiveUsers() {
        return activeUsers;
    }
}
