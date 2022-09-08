package uz.jl.trello.trello.dtos.user;

import uz.jl.trello.trello.domains.auth.AuthUser;
import uz.jl.trello.trello.dtos.GenericDto;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:23 (Thursday)
 * trello/IntelliJ IDEA
 */
public class AuthUserDTO extends GenericDto {
    private String username;
    private AuthUser.Status status;
}
