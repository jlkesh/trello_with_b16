package uz.jl.trello.trello.mappers;

import org.mapstruct.Mapper;
import uz.jl.trello.trello.domains.auth.AuthUser;
import uz.jl.trello.trello.dtos.user.AuthUserCreateDTO;
import uz.jl.trello.trello.dtos.user.AuthUserDTO;
import uz.jl.trello.trello.dtos.user.AuthUserUpdateDTO;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/20:02 (Thursday)
 * trello/IntelliJ IDEA
 */

@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<AuthUser, AuthUserDTO, AuthUserCreateDTO, AuthUserUpdateDTO> {

}
