package com.example.entranceexam.controller;

import com.example.entranceexam.model.FileEntity;
import com.example.entranceexam.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filestorage")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    public ResponseEntity<?> createFile(@RequestBody FileEntity fileEntity) {
        Long savedFile = fileService.saveFile(fileEntity).getId();
        return ResponseEntity.ok().body("File_created_with_id: " + savedFile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileEntity> getFile(@PathVariable Long id) {
        Optional<FileEntity> file = fileService.getFileById(id);
        return file.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFile(@PathVariable Long id, @RequestBody FileEntity fileEntity) {
        Optional<FileEntity> existingFile = fileService.getFile(id);
        if (existingFile.isPresent()) {
            fileEntity.setId(id);
            fileService.saveFile(fileEntity);
            return ResponseEntity.ok().body("File updated with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public List<FileEntity> getAllFiles() {
        return fileService.getAllFiles();
    }
}
