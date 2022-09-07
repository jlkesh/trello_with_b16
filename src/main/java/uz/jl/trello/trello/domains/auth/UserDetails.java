package uz.jl.trello.trello.domains.auth;

import lombok.*;
import org.hibernate.annotations.Formula;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:40 (Tuesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserDetails {

    @Id
    @OneToOne(targetEntity = AuthUser.class)
    private Long userId;

    @OneToOne(targetEntity = Uploads.class)
    private Long userProfilePictureId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String patronymic;

    @Formula("firstName || ' ' || lastName || ' ' || patryonic")
    private String fullName;
}
