package org.dldev.aiweb.rest;

import org.dldev.aiweb.service.UploadFileNotFoundException;
import org.dldev.aiweb.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/file/upload")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) {
        uploadService.store(file);
    }

    @ExceptionHandler(UploadFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(UploadFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
