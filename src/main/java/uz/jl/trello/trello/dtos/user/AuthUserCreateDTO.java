package uz.jl.trello.trello.dtos.user;

import lombok.*;
import uz.jl.trello.trello.dtos.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:23 (Thursday)
 * trello/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUserCreateDTO implements Dto {

    @NotBlank(message = "username can not be blank")
    private String username;

    @NotBlank(message = "username can not be blank")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$",
            message = "Password must be at least 8 characters")
    private String password;

    @NotBlank(message = "email can not be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message = "Email is invalid")
    private String email;

}
