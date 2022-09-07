package uz.jl.trello.trello.config.security;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.jl.trello.trello.domains.auth.AuthUser;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:36 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Component
public record UserSession(HttpServletRequest request) {

    public AuthUser getDBUser() {
        AuthUser user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof AuthUser) {
                user = (AuthUser) authentication.getPrincipal();
            }
        }
        return user;
    }

    public String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
