package uz.jl.trello.trello.domains.board;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Entity;

/**
 * @author "Elmurodov Javohir"
 * @since 07/09/22/18:12 (Wednesday)
 * trello/IntelliJ IDEA
 */

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BoardLabel extends Auditable {
    private String title;
    private String color;
}
