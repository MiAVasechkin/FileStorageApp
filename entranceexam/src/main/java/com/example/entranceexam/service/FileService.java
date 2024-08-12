package com.example.entranceexam.service;

import com.example.entranceexam.model.FileEntity;
import com.example.entranceexam.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(FileEntity file) {
        return fileRepository.save(file);
    }

    public Optional<FileEntity> getFileById(Long id) {
        return fileRepository.findById(id);
    }

    public Optional<FileEntity> getFile(Long id) {
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }
}
