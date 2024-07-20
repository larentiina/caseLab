package org.test.caselab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.test.caselab.dto.FileDto;
import org.test.caselab.exception.InvalidFileDataException;
import org.test.caselab.model.FileEntity;
import org.test.caselab.repository.FileRepository;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;


    public Long save(FileDto fileDto){

        try {
            FileEntity createdfileEntity = FileEntity.builder()
                    .title(fileDto.getTitle())
                    .creationDate(LocalDateTime.parse(fileDto.getCreationDate(), getDateFormat()))
                    .description(fileDto.getDescription())
                    .data(decodeBase64(fileDto.getData())).build();
            FileEntity savedFileEntity = fileRepository.save(createdfileEntity);
            return savedFileEntity.getId();
        }catch (IllegalArgumentException e){
            throw new InvalidFileDataException("invalid base64 data",e);
        }
    }

    public FileDto findFileById(Long id){
        FileEntity fileEntity = fileRepository.findById(id).orElseThrow(() -> new NoSuchElementException("File not found with id: " + id));

        return FileDto.builder()
                .title(fileEntity.getTitle())
                .creationDate(fileEntity.getCreationDate().format(getDateFormat()))
                .description(fileEntity.getDescription())
                .data(encodeBase64(fileEntity.getData())).build();
    }

    public DateTimeFormatter getDateFormat(){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    }
    public byte[] decodeBase64(String data){
        return Base64.getDecoder().decode(data);
    }
    public String encodeBase64(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }


}
