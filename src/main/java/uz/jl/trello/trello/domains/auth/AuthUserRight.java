package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:40 (Wednesday)
 * trello/IntelliJ IDEA
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "user_id_workspace_id_auth_role_id_unique_key",
                columnNames = {"user_id", "workspaceId", "role_id"}
        )
})
public class AuthUserRight extends Auditable {

    @ManyToOne
    private AuthUser user;
    private Long workspaceId;

    @OneToOne
    private AuthRole role;

    @Builder(builderMethodName = "childBuilder")
    public AuthUserRight(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, AuthUser user, Long workspaceId, AuthRole role) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.user = user;
        this.workspaceId = workspaceId;
        this.role = role;
    }
}
