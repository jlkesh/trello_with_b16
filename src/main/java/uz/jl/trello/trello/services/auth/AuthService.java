package uz.jl.trello.trello.services.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.jl.trello.trello.config.security.SecurityUserDetails;
import uz.jl.trello.trello.domains.auth.AuthUser;
import uz.jl.trello.trello.dtos.auth.request.AccessTokenRequest;
import uz.jl.trello.trello.dtos.auth.request.RefreshTokenRequest;
import uz.jl.trello.trello.dtos.auth.response.TokenResponse;
import uz.jl.trello.trello.repositories.AuthUserRepository;
import uz.jl.trello.trello.services.BaseService;
import uz.jl.trello.trello.services.jwt.AccessTokenService;
import uz.jl.trello.trello.services.jwt.RefreshTokenService;

import java.util.function.Supplier;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:23 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService, BaseService {
    private final AuthUserRepository authUserRepository;
    private final AccessTokenService accessTokenService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public SecurityUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> exception = () -> {
            throw new UsernameNotFoundException("User not found");
        };
        AuthUser authUser = authUserRepository.findByUsername(username).orElseThrow(exception);
        return new SecurityUserDetails(authUser);
    }

    public TokenResponse generateToken(AccessTokenRequest request) {
        SecurityUserDetails userDetails = loadUserByUsername(request.username());
        String accessToken = accessTokenService.generateToken(userDetails);
        String refreshToken = refreshTokenService.generateToken(userDetails);
        return new TokenResponse(accessToken, refreshToken, userDetails.getUsername());
    }

    public TokenResponse refreshToken(RefreshTokenRequest request) {
        String refreshToken = request.refreshToken();
        if (!refreshTokenService.isValid(refreshToken)) {
            // TODO: 08/09/22 change the Exception class
            throw new RuntimeException("Token is invalid");
        }
        String username = refreshTokenService.getSubject(refreshToken);
        SecurityUserDetails userDetails =z loadUserByUsername(username);
        String accessToken = accessTokenService.generateToken(userDetails);
        return new TokenResponse(accessToken, refreshToken, username);
    }
}
