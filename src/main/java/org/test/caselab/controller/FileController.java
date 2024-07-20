package org.test.caselab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.caselab.dto.FileDto;
import org.test.caselab.service.FileService;

@RequiredArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/files")
    public ResponseEntity<?> createFile(@RequestBody FileDto fileDto){
        Long fileId = fileService.save(fileDto);
        return fileId != null
        ? new ResponseEntity<>(fileId,HttpStatus.CREATED)
                :  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
