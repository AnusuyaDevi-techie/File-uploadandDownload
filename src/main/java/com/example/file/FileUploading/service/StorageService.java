package com.example.file.FileUploading.service;

import com.example.file.FileUploading.dao.DaoUpload;
import com.example.file.FileUploading.entity.FileData;
import com.example.file.FileUploading.repository.MoServiceRepository;
import com.example.file.FileUploading.utiil.ImageUtils;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StorageService {

   // private final StorageRepository storageRepository;
    private final MoServiceRepository moServiceRepository;
    private final DaoUpload DaoUpload;

    public String uploadFile(MultipartFile file) throws IOException {
        FileData fileData = DaoUpload.save(FileData.builder()
            .name(file.getOriginalFilename())
            .type(file.getContentType())
            .data(ImageUtils.compressFile(file.getBytes(), file.getContentType()))
            .build());

        if (fileData != null) {
            return "File uploaded successfully: " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadFile(String fileName) {
        Optional<FileData> dbFileData = moServiceRepository.findByName(fileName);
        if (dbFileData.isPresent()) {
            return ImageUtils.decompressFile(dbFileData.get().getData(), dbFileData.get().getType());
        }
        return null;
    }
}
