package com.han.controller;

import com.han.enums.ServerExceptionEnum;
import com.han.exception.ServerException;
import com.han.service.FileService;
import com.han.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件controller
 *
 * @author hmj
 * @since 2021/9/17
 */

@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileService m_fileService;

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) throws IOException {
        m_fileService.upload(file);
        return ResponseWrapper.markSuccess();
    }
}
