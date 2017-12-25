package org.dldev.aiweb.rest;

import org.dldev.aiweb.service.UploadFileNotFoundException;
import org.dldev.aiweb.service.UploadKaServiceImpl;
import org.dldev.aiweb.service.UploadService;
import org.dldev.aiweb.service.UploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;

@RestController
public class UploadController {

    @Autowired
    private UploadServiceImpl uploadService;

    @Autowired
    private UploadKaServiceImpl kauploadService;

    @PostMapping("/file/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        uploadService.store(file);
    }

    @PostMapping("/file/kaupload")
    public void handleKaUpload(@RequestParam("file") MultipartFile file) {
        kauploadService.store(file);
    }
/*
    @GetMapping("/file/pic/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = uploadService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }*/

    @GetMapping("/file/kapic/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveKaFile(@PathVariable String filename) {

        Resource file = kauploadService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @ExceptionHandler(UploadFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(UploadFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
