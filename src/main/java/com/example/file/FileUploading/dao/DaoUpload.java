package com.example.file.FileUploading.dao;

import com.example.file.FileUploading.entity.FileData;
import com.example.file.FileUploading.repository.MoServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DaoUpload implements Dao {

private final MoServiceRepository moServiceRepository;
    @Override
    public FileData save(FileData fileData) {
        return moServiceRepository.save(fileData);
    }
}
