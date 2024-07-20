package org.test.caselab.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "files")
public class FileEntity {

    @Id
    private Long id;
    private String title;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime creationDate;
    private String description;
    @Lob
    private byte[] data;


}
