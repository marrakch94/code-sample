package com.spark3.olbank.notification.util;

import com.spark3.olbank.config.JWTUtil;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.List;

@Component
public class WsActiveUsersListener {

    private ActiveUsersManager activeUsersManager;
    private JWTUtil jwtUtil;

    public WsActiveUsersListener(ActiveUsersManager activeUsersManager, JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        this.activeUsersManager = activeUsersManager;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event) {
       SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        List<String> authHeader = headers.getNativeHeader("Authorization");
       // System.out.println(event);
        if (authHeader != null && !authHeader.isEmpty()) {
            String jwt = authHeader.get(0);
            String userName = jwtUtil.getUsernameFromToken(jwt);
            activeUsersManager.addUser(userName, headers.getUser().getName());
            System.out.println(activeUsersManager.getActiveUsers());
        }
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event) {
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        System.out.println(headers);
        activeUsersManager.removeUserByUUID(headers.getUser().getName());
    }

    public void setLoginDestination(String loginDestination) {
        // this.loginDestination = loginDestination;
    }

    public void setLogoutDestination(String logoutDestination) {
        // this.logoutDestination = logoutDestination;
    }
}