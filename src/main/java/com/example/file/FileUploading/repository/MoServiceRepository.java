package com.example.file.FileUploading.repository;

import com.example.file.FileUploading.entity.FileData;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoServiceRepository extends MongoRepository <FileData, String>{

    Optional<FileData> findByName(String name);

}
