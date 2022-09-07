package uz.jl.trello.trello.domains.task;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:13 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskComment extends Auditable {

    private String message;

    @Enumerated(EnumType.STRING)
    private TaskCommentType taskCommentType;

    public enum TaskCommentType {
        INFO, ERROR, SOLUTION;
    }

}
