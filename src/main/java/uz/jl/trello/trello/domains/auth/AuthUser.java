package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:29 (Tuesday)
 * trello/IntelliJ IDEA
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthUser extends Auditable {

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDateTime lastLoginAt;

    private Integer loginTryCount;

    @OneToMany(mappedBy = "user")
    private Collection<AuthUserRight> userRights;

    @Builder(builderMethodName = "childBuilder")
    public AuthUser(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String username, String password, Status status, String email, LocalDateTime lastLoginAt, Integer loginTryCount, Collection<AuthUserRight> userRights) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.username = username;
        this.password = password;
        this.status = status;
        this.email = email;
        this.lastLoginAt = lastLoginAt;
        this.loginTryCount = loginTryCount;
        this.userRights = userRights;
    }

    public enum Status {
        ACTIVE,
        NOT_ACTIVE,
        ACCOUNT_EXPIRED,
        CREDENTIALS_EXPIRED;

        public boolean notEquals(Status status) {
            return !this.equals(status);
        }
    }
}

