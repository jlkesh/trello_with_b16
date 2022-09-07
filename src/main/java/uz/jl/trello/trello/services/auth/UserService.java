package uz.jl.trello.trello.services.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.jl.trello.trello.config.security.SecurityUserDetails;
import uz.jl.trello.trello.domains.auth.AuthUser;
import uz.jl.trello.trello.repositories.AuthUserRepository;

import java.util.function.Supplier;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:23 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Service
public record UserService(AuthUserRepository authUserRepository) implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> exception = () -> {
            throw new UsernameNotFoundException("User not found");
        };
        AuthUser authUser = authUserRepository.findByUsername(username).orElseThrow(exception);
        return new SecurityUserDetails(authUser);
    }
}
