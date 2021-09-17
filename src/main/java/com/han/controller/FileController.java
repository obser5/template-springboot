package com.han.controller;

import com.han.enums.BusinessExceptionEnum;
import com.han.exception.BusinessException;
import com.han.util.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件controller
 *
 * @author hmj
 * @since 2021/9/17
 */

@RestController
public class FileController {
    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 单文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Object upload(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new BusinessException(BusinessExceptionEnum.FILE_UPLOAD_FAILED);
            }
            String fileName = file.getOriginalFilename();
            // 指定存放位置
            String filePath = "C:\\Users\\96176\\Desktop\\";
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            return ResponseWrapper.markSuccess("file upload success");
        } catch (BusinessException e) {
            logger.error("业务异常：", e);
            return ResponseWrapper.markBusinessException(BusinessExceptionEnum.FILE_UPLOAD_FAILED);
        } catch (Exception e) {
            logger.error("服务异常：", e);
            return ResponseWrapper.markServerException(e.getMessage());
//            return ResponseWrapper.markServerException();
        }
    }
}
