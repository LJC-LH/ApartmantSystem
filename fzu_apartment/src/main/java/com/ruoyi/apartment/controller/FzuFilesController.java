package com.ruoyi.apartment.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/apartment/imagesUpload")
public class FzuFilesController {
    /**
     * 头像上传，路径没有确定号
     * TODO：文件路径
     */
    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/stuImagesUpload")
    public AjaxResult uploadStuImages(@RequestParam("data") MultipartFile[] files) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename(); // 获取原始文件名
            String upload = FileUploadUtils.uploadImage(RuoYiConfig.getImagesPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            upload = upload.replace("\\", "/");
            list.add(upload);

        }
        return AjaxResult.success(list);
    }

    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadFirstImages")
    public AjaxResult uploadFirstImages(@RequestParam("data") MultipartFile[] files) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename(); // 获取原始文件名
            String upload = FileUploadUtils.uploadImage(RuoYiConfig.getImagesPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            upload = upload.replace("\\", "/");
            list.add(upload);
        }
        return AjaxResult.success(list);
    }

    @Log(title = "图片", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadSecondImages")
    public AjaxResult uploadSecondImages(@RequestParam("data") MultipartFile[] files) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            String originalFileName = file.getOriginalFilename(); // 获取原始文件名
            String upload = FileUploadUtils.uploadImage(RuoYiConfig.getImagesPath(), file, MimeTypeUtils.IMAGE_EXTENSION);
            upload = upload.replace("\\", "/");
            list.add(upload);
        }
        return AjaxResult.success(list);
    }
}
