package com.shield.controller;

import com.shield.ftp.FtpUtils;
import com.shield.utils.CommonsReturn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.shield.controller
 * @ClassName: UpLodeImgController
 * @Author: ${唐嘉萌}
 * @CreateTime: 2020/11/3 12:19
 * @Description:
 */
@Controller
@RequestMapping("UpLodeImgController")
public class UpLodeImgController {

    @RequestMapping("photoUpLode")
    @ResponseBody
    public CommonsReturn photoUpLode(@RequestParam("file") MultipartFile userPhoto, HttpServletRequest request) throws IOException {
        //真实名称
        String oldName = userPhoto.getOriginalFilename();
        //获取时间戳
        long time = System.currentTimeMillis();
        //获取新名字
        String newName = time+oldName.substring(oldName.lastIndexOf("."));
        //获取上传的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String uploadPath=realPath+"/commons/photo";
        File file = new File(uploadPath);
        //判断文件夹是否存在 如果不存在则创建一个 保证这个文件夹始终存在
        if (!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        //拼接后缀名
        String photoUrl = uploadPath + "/" + newName;
        //上传
        userPhoto.transferTo(new File(photoUrl));
        return CommonsReturn.success(photoUrl);
    }

    @RequestMapping("photoUpLodeFTP")
    @ResponseBody
    public CommonsReturn photoUpLodeFTP(@RequestParam("file") MultipartFile userPhoto) throws IOException {
        String url = FtpUtils.uploadFile(userPhoto,"loUser/inof");
        return CommonsReturn.success(url);
    }
    }
