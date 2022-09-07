package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:29 (Tuesday)
 * trello/IntelliJ IDEA
 */


@Builder
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

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;

    @Column(unique = true, nullable = false)
    private String email;

    private LocalDateTime lastLoginAt;

    private Integer loginTryCount;

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

