package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:12 (Wednesday)
 * trello/IntelliJ IDEA
 */


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardLabel extends Auditable {
    private String title;
    private String color;

    @Builder(builderMethodName = "childBuilder")
    public BoardLabel(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String title, String color) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.title = title;
        this.color = color;
    }
}
