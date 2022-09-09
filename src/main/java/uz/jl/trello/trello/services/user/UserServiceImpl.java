package uz.jl.trello.trello.services.user;

import lombok.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.jl.trello.trello.criteria.AuthUserCriteria;
import uz.jl.trello.trello.domains.auth.AuthUser;
import uz.jl.trello.trello.dtos.user.AuthUserCreateDTO;
import uz.jl.trello.trello.dtos.user.AuthUserDTO;
import uz.jl.trello.trello.dtos.user.AuthUserUpdateDTO;
import uz.jl.trello.trello.mappers.AuthUserMapper;
import uz.jl.trello.trello.repositories.AuthUserRepository;
import uz.jl.trello.trello.services.AbstractService;
import uz.jl.trello.trello.utils.BaseUtils;

import java.util.List;

/**
 * @author "Elmurodov Javohir"
 * @since 08/09/22/19:28 (Thursday)
 * trello/IntelliJ IDEA
 */

@Service
public class UserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements UserService {

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, BaseUtils utils, PasswordEncoder passwordEncoder) {
        super(repository, mapper, utils);
        this.passwordEncoder = passwordEncoder;
    }

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
        AuthUser authUser = mapper.fromCreateDto(dto);
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUser.setCreatedBy(-1L);
        authUser.setStatus(AuthUser.Status.NOT_ACTIVE);
        repository.save(authUser);
        return authUser.getId();
    }

    @Override
    public void delete(@NonNull Long id) {

    }

    @Override
    public void update(@NonNull AuthUserUpdateDTO dto) {

    }
}
