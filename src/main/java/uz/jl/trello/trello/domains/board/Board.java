package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.auth.UserDetails;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:49 (Wednesday)
 * trello/IntelliJ IDEA
 */


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

    @Builder(builderMethodName = "childBuilder")
    public Board(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String description, Uploads documentation, Collection<BoardColumn> boardColumns, BoardVisibility boardVisibility, Collection<UserDetails> members) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.description = description;
        this.documentation = documentation;
        this.boardColumns = boardColumns;
        this.boardVisibility = boardVisibility;
        this.members = members;
    }

    private enum BoardVisibility {
        PRIVATE, WORKSPACE;
    }
}
