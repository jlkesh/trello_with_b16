package uz.jl.trello.trello.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.jl.trello.trello.domains.auth.AuthUser;

import java.util.Optional;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:24 (Wednesday)
 * trello/IntelliJ IDEA
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, GenericRepository {
    Optional<AuthUser> findByUsername(String username);
}
