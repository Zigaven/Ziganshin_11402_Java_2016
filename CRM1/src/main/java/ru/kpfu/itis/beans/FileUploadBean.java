package ru.kpfu.itis.beans;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ruslanzigansin on 13.05.16.
 */
public class FileUploadBean {
    private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}
