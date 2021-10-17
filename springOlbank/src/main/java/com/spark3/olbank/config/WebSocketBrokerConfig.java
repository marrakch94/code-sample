package com.spark3.olbank.config;

import com.spark3.olbank.notification.util.AssignPrincipalHandshakeHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic", "/notifications");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
      //  registry.addEndpoint("/stomp").setAllowedOrigins("*");
        registry.addEndpoint("/ws")
                .setHandshakeHandler(new AssignPrincipalHandshakeHandler())
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS();
    }
}

