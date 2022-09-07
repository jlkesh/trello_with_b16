package uz.jl.trello.trello.domains.task;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:13 (Wednesday)
 * trello/IntelliJ IDEA
 */



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TaskComment extends Auditable {

    private String message;

    @Enumerated(EnumType.STRING)
    private TaskCommentType taskCommentType;

    @Builder(builderMethodName = "childBuilder")
    public TaskComment(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String message, TaskCommentType taskCommentType) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.message = message;
        this.taskCommentType = taskCommentType;
    }

    public enum TaskCommentType {
        INFO, ERROR, SOLUTION;
    }

}
