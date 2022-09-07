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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task extends Auditable {

    @Column(unique = true, nullable = false)
    private String title;

    private String description;

    private LocalDateTime begins;

    private LocalDateTime deadline;// as deadline;

    @OneToMany
    private Collection<Uploads> uploads;

    @OneToMany
    private Collection<TaskComment> comments;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_details_id", referencedColumnName = "userId")
    )
    private Collection<UserDetails> members;

    @Column(unique = true, nullable = false,name = "task_order")
    private Integer order;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "board_label_id", referencedColumnName = "id")
    )
    private Collection<BoardLabel> labels;

    @Enumerated(EnumType.STRING)
    private TaskLevel level;

    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @Builder(builderMethodName = "childBuilder")
    public Task(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String description, LocalDateTime from, LocalDateTime to, Collection<Uploads> uploads, Collection<TaskComment> comments, Collection<UserDetails> members, Integer order, Collection<BoardLabel> labels, TaskLevel level, TaskPriority priority) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.description = description;
        this.begins = from;
        this.deadline = to;
        this.uploads = uploads;
        this.comments = comments;
        this.members = members;
        this.order = order;
        this.labels = labels;
        this.level = level;
        this.priority = priority;
    }

    public enum TaskLevel {
        EASY, MEDIUM, HARD;
    }

    public enum TaskPriority {
        LOW, MEDIUM, HIGH;
    }


}
