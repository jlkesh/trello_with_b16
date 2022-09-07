package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.task.Task;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:57 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardColumn extends Auditable {

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false,name = "boardOrder")
    private Integer order;

    private String emoji;

    @OneToMany
    private Collection<Task> tasks;

    @Enumerated(EnumType.STRING)
    private BoardColumnStatus status = BoardColumnStatus.ACTIVE;

    @Builder(builderMethodName = "childBuilder")
    public BoardColumn(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, Integer order, String emoji, Collection<Task> tasks, BoardColumnStatus status) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.order = order;
        this.emoji = emoji;
        this.tasks = tasks;
        this.status = status;
    }

    public enum BoardColumnStatus {
        ACTIVE, ARCHIVED;
    }
}
