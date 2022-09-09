package uz.jl.trello.trello.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.jl.trello.trello.dtos.user.AuthUserCreateDTO;
import uz.jl.trello.trello.services.user.UserService;

import javax.validation.Valid;
import java.net.URI;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/18:42 (Friday)
 * trello/IntelliJ IDEA
 */
@RestController
public class UserController extends ApiController<UserService> {

    public UserController(UserService service) {
        super(service);
    }


    @PostMapping(value = API + V1 + "/user/register")
    public ResponseEntity<Long> create(@Valid @RequestBody AuthUserCreateDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(service.create(dto));
    }

}
