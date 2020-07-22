package com.tenere_bufo.itis.repository;

import com.tenere_bufo.itis.model.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileInfo, Long> {
    Optional<FileInfo> findByUrl(String url);
}