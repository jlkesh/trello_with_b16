package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;
import uz.jl.trello.trello.domains.task.Task;

import javax.persistence.*;
import java.util.Collection;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/17:57 (Wednesday)
 * trello/IntelliJ IDEA
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardColumn extends Auditable {

    @Column(unique = true, nullable = false)
    private String title;

    @Column(unique = true, nullable = false)
    private Integer order;

    private String emoji;

    @OneToMany
    private Collection<Task> tasks;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private BoardColumnStatus status = BoardColumnStatus.ACTIVE;

    public enum BoardColumnStatus {
        ACTIVE, ARCHIVED;
    }
}
