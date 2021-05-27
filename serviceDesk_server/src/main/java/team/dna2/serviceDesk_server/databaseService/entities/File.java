package team.dna2.serviceDesk_server.databaseService.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FILES")
@Data
@NoArgsConstructor
public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
}
