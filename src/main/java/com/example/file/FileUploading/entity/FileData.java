package com.example.file.FileUploading.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileData {

    @Id
    private String id;
    private String name;
    private String type;
    private byte[] data;
}
