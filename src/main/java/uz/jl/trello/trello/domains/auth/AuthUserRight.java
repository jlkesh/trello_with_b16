package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:40 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "user_id_workspace_id_auth_role_id_unique_key",
                columnNames = {"userId", "workspaceId", "roleId"}
        )
})
public class AuthUserRight extends Auditable {

    private Long userId;
    private Long workspaceId;
    private Long roleId;

}
