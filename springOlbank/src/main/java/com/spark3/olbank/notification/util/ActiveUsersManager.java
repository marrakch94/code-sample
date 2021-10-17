package com.spark3.olbank.notification.util;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ActiveUsersManager {

    private Map<String, String> activeUsers = new HashMap<>();

    public void addUser(String userName, String sessionId) {
        activeUsers.put(userName, sessionId);
    }

    public void removeUser(String userName) {
        activeUsers.remove(userName);
    }

    public void removeUserByUUID(String uuid) {
        while (activeUsers.values().remove(uuid)) ;
    }

    public boolean isUserActive(String userName) {
        return activeUsers.containsKey(userName);
    }

    public Map<String, String> getActiveUsers() {
        return activeUsers;
    }
}
