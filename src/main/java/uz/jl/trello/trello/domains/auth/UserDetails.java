package uz.jl.trello.trello.domains.auth;

import lombok.*;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.*;

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
@Table(name = "user_detail")
public class UserDetails {

    @Id
    @Column(unique = true, nullable = false)
    private Long userId;

    @OneToOne(targetEntity = Uploads.class)
    private Uploads userProfilePicture;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String patronymic;

    private String fullName;
}
