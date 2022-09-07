package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:59 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthUserPasswordAudit extends Auditable {

    @Column(unique = true)
    private String oldPassword;

    @Column(nullable = false, unique = true)
    private String currentPassword;

    @ManyToOne
    private AuthUser authUser;

}
