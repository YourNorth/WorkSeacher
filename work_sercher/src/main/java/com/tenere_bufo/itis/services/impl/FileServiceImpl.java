package com.tenere_bufo.itis.services.impl;

import com.tenere_bufo.itis.model.FileInfo;
import com.tenere_bufo.itis.repository.FileRepository;
import com.tenere_bufo.itis.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import java.io.*;
import java.util.Optional;

@Service
@PropertySource("classpath:application.properties")
public class FileServiceImpl implements FileService {


//    @Resource(name = "uploadsDir")
    @Value("${uploadsDir}")
    String uploadsDir;



    @Autowired
    FileRepository fileRepository;

//    @Autowired
//    MailService mailService;

    @Override
    public Optional<FileInfo> getFile(Long id) {
        return fileRepository.findById(id);
    }

    @Override
    public Optional<FileInfo> fileSave(MultipartFile multipartFile) {
        FileInfo fileInfo = FileInfo.builder().size(multipartFile.getSize()).type(multipartFile.getContentType()).originalFileName(multipartFile.getOriginalFilename()).build();
        fileRepository.save(fileInfo);
        try {
            byte[] bytes = multipartFile.getBytes();
            File systemFile = new File(uploadsDir + "/"  + fileInfo.getId());
            System.out.println(systemFile.getCanonicalPath());
            BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(systemFile));
            System.out.println(buffStream);
            buffStream.write(bytes);
            buffStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return Optional.empty();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        //mailService.sendFileUrl(fileInfo);
        return Optional.of(fileInfo);
    }

}