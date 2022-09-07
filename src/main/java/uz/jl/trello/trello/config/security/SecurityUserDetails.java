package uz.jl.trello.trello.config.security;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.jl.trello.trello.domains.auth.AuthUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:28 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Builder
public record SecurityUserDetails(AuthUser authUser) implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authUser.getUserRights()
                .stream()
                .map(authUserRight -> authUserRight.getRole().getAuthority())
                .distinct()
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return authUser.getPassword();
    }

    @Override
    public String getUsername() {
        return authUser.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return authUser().getStatus().notEquals(AuthUser.Status.ACCOUNT_EXPIRED);
    }

    @Override
    public boolean isAccountNonLocked() {
        return authUser.getStatus().equals(AuthUser.Status.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return authUser.getStatus().notEquals(AuthUser.Status.CREDENTIALS_EXPIRED);
    }

    @Override
    public boolean isEnabled() {
        return authUser.isDeleted();
    }

    public Long getId() {
        return authUser.getId();
    }
}