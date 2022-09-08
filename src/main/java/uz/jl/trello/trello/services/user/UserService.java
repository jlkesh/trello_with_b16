package uz.jl.trello.trello.services.user;

import lombok.NonNull;
import uz.jl.trello.trello.criteria.AuthUserCriteria;
import uz.jl.trello.trello.dtos.user.AuthUserCreateDTO;
import uz.jl.trello.trello.dtos.user.AuthUserDTO;
import uz.jl.trello.trello.dtos.user.AuthUserUpdateDTO;
import uz.jl.trello.trello.services.GenericCrudService;

import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:28 (Thursday)
 * trello/IntelliJ IDEA
 */
public class UserService implements GenericCrudService<
        Long,
        AuthUserDTO,
        AuthUserCreateDTO,
        AuthUserUpdateDTO,
        AuthUserCriteria>{
    @Override
    public List<AuthUserDTO> getAll(@NonNull AuthUserCriteria criteria) {
        return null;
    }

    @Override
    public AuthUserDTO get(@NonNull Long id) {
        return null;
    }

    @Override
    public Long create(@NonNull AuthUserCreateDTO dto) {

        return null;
    }

    @Override
    public void delete(@NonNull Long id) {

    }

    @Override
    public void update(@NonNull AuthUserUpdateDTO dto) {

    }
}
