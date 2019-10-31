package cn.honey.home.web;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 公共全局配置类
 */
@Component
@ConfigurationProperties(prefix = "global")
public class GlobalProperties {
    private int pageSize;
    private String successOperation;
    private String errorOperation;
    private String fileUploadPath;// 文件上传路径
    private String fileRequestUrl;// 文件访问路径

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSuccessOperation() {
        return successOperation;
    }

    public void setSuccessOperation(String successOperation) {
        this.successOperation = successOperation;
    }

    public String getErrorOperation() {
        return errorOperation;
    }

    public void setErrorOperation(String errorOperation) {
        this.errorOperation = errorOperation;
    }

    public String getFileUploadPath() {
        return fileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public String getFileRequestUrl() {
        return fileRequestUrl;
    }

    public void setFileRequestUrl(String fileRequestUrl) {
        this.fileRequestUrl = fileRequestUrl;
    }
}
