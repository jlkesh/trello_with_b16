package uz.jl.trello.trello.config.security;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import uz.jl.trello.trello.domains.auth.AuthPermission;
import uz.jl.trello.trello.domains.auth.AuthRole;
import uz.jl.trello.trello.domains.auth.AuthUser;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:28 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Builder
public record SecurityUserDetails(
        AuthUser authUser) implements org.springframework.security.core.userdetails.UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        if (Objects.nonNull(authUser.get())) {
            for (AuthRole role : authUser.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
                for (AuthPermission permission : role.getPermissions()) {
                    authorities.add(new SimpleGrantedAuthority(permission.getAuthority()));
                }
            }
        }
        return authorities;
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