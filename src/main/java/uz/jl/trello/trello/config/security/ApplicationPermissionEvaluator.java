package uz.jl.trello.trello.config.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:33 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Component
public class ApplicationPermissionEvaluator implements PermissionEvaluator {

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        authentication.getPrincipal();
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }

}
