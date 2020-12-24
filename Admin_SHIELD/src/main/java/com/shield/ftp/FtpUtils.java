package com.shield.ftp;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public class FtpUtils {

    private static FTPClient ftpClient;
    private static boolean status=false;

    static {
        ftpClient= new FTPClient();
        try {
            //连接服务器
            ftpClient.connect(FtpConfig.host,FtpConfig.port);
            //登录服务器
            ftpClient.login(FtpConfig.userName,FtpConfig.password);

            //判断服务器是否访问
            int replyCode=ftpClient.getReplyCode();
            if (FTPReply.isPositiveCompletion(replyCode)){
                status=true;
            }else {
                System.out.println("ftp的客户端登陆服务器失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ftp的客户端连接服务器失败");
        }
        System.out.println("ftp的客户端结束创建");
    }

    public static String uploadFile(MultipartFile file,String mkdir) throws IOException {
        if(status){
            String homePath=FtpConfig.homePath;
            String filePath=homePath+mkdir;
            //创建没有创建的目录
            if (mkdir !=null && !ftpClient.changeWorkingDirectory(filePath)){
                String[] mkdirs=mkdir.split("/");
                String tempPath=homePath;
                for (int i = 0;i<mkdirs.length;i++){
                    if (StringUtils.isNoneBlank(mkdirs[i])){
                        tempPath+="/"+mkdirs[i];
                        if (!ftpClient.changeWorkingDirectory(tempPath)){
                            if (!ftpClient.makeDirectory(tempPath)){
                                System.out.println("创建目录"+tempPath+"失败");
                                return "error";
                            }else {
                                ftpClient.changeWorkingDirectory(tempPath);
                            }
                        }
                    }
                }
            }
            //开始上传
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String newFileName = NewFileName(file.getOriginalFilename());
            boolean b = ftpClient.storeFile(newFileName, file.getInputStream());
            if (b){
               return FtpConfig.proxyUrl+mkdir+"/"+newFileName;
            }else {
                return "error";
            }
        }else {
            return "error";
        }

        }

        public static String NewFileName(String oldFileName){
            return UUID.randomUUID().toString()+oldFileName.substring(oldFileName.lastIndexOf("."));
        }
}
