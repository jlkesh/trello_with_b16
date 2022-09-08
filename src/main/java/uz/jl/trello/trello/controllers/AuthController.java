package uz.jl.trello.trello.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.jl.trello.trello.dtos.auth.request.AccessTokenRequest;
import uz.jl.trello.trello.dtos.auth.request.RefreshTokenRequest;
import uz.jl.trello.trello.dtos.auth.response.TokenResponse;
import uz.jl.trello.trello.services.auth.AuthService;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:11 (Thursday)
 * trello/IntelliJ IDEA
 */

@RestController
public class AuthController extends ApiController<AuthService> {

    public AuthController(AuthService service) {
        super(service);
    }

    @PostMapping(value = API + V1 + "/auth/access/token")
    public ResponseEntity<TokenResponse> register(@RequestBody AccessTokenRequest request) {
        return new ResponseEntity<>(service.generateToken(request), HttpStatus.CREATED);
    }

    @PostMapping(value = API + V1 + "/auth/refresh/token")
    public ResponseEntity<TokenResponse> register(@RequestBody RefreshTokenRequest request) {
        return new ResponseEntity<>(service.refreshToken(request), HttpStatus.CREATED);
    }
}
