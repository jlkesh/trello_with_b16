package uz.jl.trello.trello.domains.auth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:56 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthPermission implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private String name;

    @Override
    public String getAuthority() {
        return code;
    }
}
