package uz.jl.trello.trello.domains.task;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.auth.UserDetails;
import uz.jl.trello.trello.domains.board.BoardLabel;
import uz.jl.trello.trello.domains.filestorage.Uploads;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:05 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task extends Auditable {

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    private LocalDateTime from;

    private LocalDateTime to;// as deadline;

    @OneToMany
    private Collection<Uploads> uploads;

    @OneToMany
    private Collection<TaskComment> comments;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_details_id", referencedColumnName = "id")
    )
    private Collection<UserDetails> members;

    @Column(unique = true, nullable = false)
    private Integer order;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "board_label_id", referencedColumnName = "id")
    )
    private Collection<BoardLabel> labels;

    @Enumerated(EnumType.STRING)
    private TaskLevel level;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    public enum TaskLevel {
        EASY, MEDIUM, HARD;
    }

    public enum TaskPriority {
        LOW, MEDIUM, HIGH;
    }


}
