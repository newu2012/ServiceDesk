package team.dna2.serviceDesk_server.databaseService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILES")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "file_path", nullable = false, length = 256)
    private String filePath;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "filename_uploaded", nullable = false, length = 128)
    private String filenameUploaded;

    @Column(name = "filename_generated", nullable = false, length = 128)
    private String filenameGenerated;

    @Column(name = "file_extension", nullable = false, length = 32)
    private String fileExtension;

    @Transient
    @OneToOne(mappedBy = "file")
    @JsonBackReference(value = "attachmentReference")
    private Attachment attachment;

    @Transient
    @OneToOne(mappedBy = "logoFile")
    @JsonBackReference(value = "organizationReference")
    private Organization organization;

    @Transient
    @OneToOne(mappedBy = "avatarFile")
    @JsonBackReference(value = "userReference")
    private User user;
}
