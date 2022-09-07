package uz.jl.trello.trello.domains.workspace;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.auth.UserDetails;
import uz.jl.trello.trello.domains.board.Board;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:46 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "title_auth_user_unique_key", columnNames = {"title", "createdBy"})
})
public class Workspace extends Auditable {

    @Column(nullable = false)
    private String title;

    private String description;

    @OneToOne
    private Uploads background;


    @OneToMany
    private Collection<Board> boards;

    @Enumerated(EnumType.STRING)
    private WorkspaceType workspaceType;

    @Enumerated(EnumType.STRING)
    private WorkspaceVisibility workspaceVisibility;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "workspace_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_details_id", referencedColumnName = "userId")
    )
    private Collection<UserDetails> members;


    @Builder(builderMethodName = "childBuilder")
    public Workspace(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String description, Uploads background, Collection<Board> boards, WorkspaceType workspaceType, WorkspaceVisibility workspaceVisibility, Collection<UserDetails> members) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.description = description;
        this.background = background;
        this.boards = boards;
        this.workspaceType = workspaceType;
        this.workspaceVisibility = workspaceVisibility;
        this.members = members;
    }

    public enum WorkspaceType {
        IT, MARKETING, SALES, EDUCATION, OTHER;
    }

    public enum WorkspaceVisibility {
        PRIVATE, PUBLIC;
    }

}
