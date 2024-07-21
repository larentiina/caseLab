package org.test.caselab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.caselab.dto.FileDto;
import org.test.caselab.exception.InvalidFileDataException;
import org.test.caselab.service.FileService;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/files")
    public ResponseEntity<?> createFile(@RequestBody FileDto fileDto){

        try {
            Long fileId = fileService.save(fileDto);
            return new ResponseEntity<>(fileId, HttpStatus.CREATED);

        }catch (InvalidFileDataException e){
            return  new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/files/{id}")
    public ResponseEntity<FileDto> createFile(@PathVariable Long id){
        try {
            FileDto fileDto = fileService.findFileById(id);
            return new ResponseEntity<>(fileDto,HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
