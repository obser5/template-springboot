package com.han.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author hmj
 * @since 2021/9/28
 */
public interface FileService {
    /**
     * 单文件上传
     *
     * @param file
     * @throws IOException
     */
    void upload(MultipartFile file) throws IOException;
}
