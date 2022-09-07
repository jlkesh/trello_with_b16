package uz.jl.trello.trello.domains.filestorage;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:45 (Tuesday)
 * trello/IntelliJ IDEA
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Uploads extends Auditable {

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private String generatedName;

    @Column(nullable = false)
    private String mimeType;

    @Column(nullable = false)
    private String path;

    private long size;

    @Builder.Default
    private UploadsType type = UploadsType.UPLOADED_FILE;

    public enum UploadsType {
        UPLOADED_FILE,
        PROFILE_PICTURE,
        TZ,
        WORK_SPACE_DOC
    }

}
