package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:59 (Tuesday)
 * trello/IntelliJ IDEA
 */


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

    @Builder(builderMethodName = "childBuilder")
    public AuthUserPasswordAudit(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String oldPassword, String currentPassword, AuthUser authUser) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.oldPassword = oldPassword;
        this.currentPassword = currentPassword;
        this.authUser = authUser;
    }
}
