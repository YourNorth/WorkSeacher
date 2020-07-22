package com.tenere_bufo.itis.controllers;


import com.tenere_bufo.itis.model.FileInfo;
import com.tenere_bufo.itis.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
@PropertySource("classpath:application.properties")
public class FilesController {


    @Autowired
    FileService fileService;

//    @Resource(name = "uploadsDir")
    @Value("${uploadsDir}")
    String uploadsDir;

    @GetMapping("/file")
    public String getUploadFilePage() {
        return "file_upload";
    }

    @PostMapping("/file")
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile, Model model) {
        if (!multipartFile.isEmpty()) {
            Optional<FileInfo> optionalFileInfo = fileService.fileSave(multipartFile);
            if (optionalFileInfo.isPresent()) {
                model.addAttribute("fileInfo", optionalFileInfo.get());
            }
        }
        return "file_upload";
    }

    // localhost:8080/files/123809183093qsdas09df8af.jpeg

    @GetMapping("/files/{file-name}")
    public void getFile(@PathVariable("file-name") Long id, HttpServletResponse response) {

        Optional<FileInfo> optionalFileInfo = fileService.getFile(id);
        if (optionalFileInfo.isPresent()) {
            File file = new File(uploadsDir + "/" + optionalFileInfo.get().getId());
            response.addHeader("content-type", optionalFileInfo.get().getType());
            try {
                InputStream is = new FileInputStream(file);
                org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
                response.flushBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
            }
        } else {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
    }
}