package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.auth.UserDetails;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:49 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board extends Auditable {

    @Column(nullable = false)
    private String title;

    private String description;

    @OneToOne
    private Uploads documentation;

    @OneToMany
    private Collection<BoardColumn> boardColumns;

    @Enumerated(EnumType.STRING)
    private BoardVisibility boardVisibility;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "board_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_details_id", referencedColumnName = "userId")
    )
    private Collection<UserDetails> members;


    private enum BoardVisibility {
        PRIVATE, WORKSPACE;
    }
}
