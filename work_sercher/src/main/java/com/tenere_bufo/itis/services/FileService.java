package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public interface FileService {
    Optional<FileInfo>  getFile(Long id);
    Optional<FileInfo> fileSave(MultipartFile multipartFile);
}