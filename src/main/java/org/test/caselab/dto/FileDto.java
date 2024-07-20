package org.test.caselab.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDto {

    private String title;
    private String creationDate;
    private String description;
    private String data;
}
