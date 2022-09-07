package uz.jl.trello.trello.domains.filestorage;

import lombok.*;
import uz.jl.trello.trello.domains.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author "Elmurodov Javohir"
 * @since 06/09/22/12:45 (Tuesday)
 * trello/IntelliJ IDEA
 */

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

    private UploadsType type = UploadsType.UPLOADED_FILE;

    @Builder(builderMethodName = "childBuilder")
    public Uploads(Long id, boolean deleted, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy, String originalName, String generatedName, String mimeType, String path, long size, UploadsType type) {
        super(id, deleted, createdAt, createdBy, updatedAt, updatedBy);
        this.originalName = originalName;
        this.generatedName = generatedName;
        this.mimeType = mimeType;
        this.path = path;
        this.size = size;
        this.type = type;
    }

    public enum UploadsType {
        UPLOADED_FILE,
        PROFILE_PICTURE,
        TZ,
        WORK_SPACE_DOC
    }

}
