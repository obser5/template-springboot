package com.han.service.impl;

import com.han.enums.ServerExceptionEnum;
import com.han.exception.ServerException;
import com.han.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author hmj
 * @since 2021/9/28
 */
@Service
public class FileServiceImpl implements FileService {
    @Override
    public void upload(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new ServerException(ServerExceptionEnum.FILE_EMPTY);
        }
        String fileName = file.getOriginalFilename();
        // 指定存放位置
        String filePath = "C:\\Users\\96176\\Desktop\\";
        File dest = new File(filePath + fileName);
        file.transferTo(dest);
    }
}
