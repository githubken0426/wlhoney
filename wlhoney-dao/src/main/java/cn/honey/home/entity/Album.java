package cn.honey.home.entity;

import java.util.Date;

public class Album {
    private String albumName;
    private String description;
    private Date createTime;
    private Date modifyTime;
    private int flag;
    private Photo defaultPhoto;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Photo getDefaultPhoto() {
        return defaultPhoto;
    }

    public void setDefaultPhoto(Photo defaultPhoto) {
        this.defaultPhoto = defaultPhoto;
    }
}
