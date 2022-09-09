package uz.jl.trello.trello.services.user;

import uz.jl.trello.trello.criteria.AuthUserCriteria;
import uz.jl.trello.trello.dtos.user.AuthUserCreateDTO;
import uz.jl.trello.trello.dtos.user.AuthUserDTO;
import uz.jl.trello.trello.dtos.user.AuthUserUpdateDTO;
import uz.jl.trello.trello.services.GenericCrudService;

/**
 * @author "Elmurodov Javohir"
 * @since 09/09/22/18:44 (Friday)
 * trello/IntelliJ IDEA
 */
public interface UserService extends GenericCrudService<
        Long,
        AuthUserDTO,
        AuthUserCreateDTO,
        AuthUserUpdateDTO,
        AuthUserCriteria> {
}
