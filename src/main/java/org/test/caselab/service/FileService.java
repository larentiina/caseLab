package org.test.caselab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.caselab.dto.FileDto;
import org.test.caselab.model.FileEntity;
import org.test.caselab.repository.FileRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
public class FileService {

    private final FileRepository fileRepository;
    @Autowired
    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public Long save(FileDto fileDto){
        byte[] decodedBytes = Base64.getDecoder().decode(fileDto.getData());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        FileEntity createdfileEntity = FileEntity.builder()
                .title(fileDto.getTitle())
                .creationDate(LocalDateTime.parse(fileDto.getCreationDate(), formatter))
                .description(fileDto.getDescription())
                .data(decodedBytes).build();
        FileEntity savedFileEntity = fileRepository.save(createdfileEntity);
        return  savedFileEntity.getId();
    }


}
