package cn.honey.home.bean;

import java.util.Date;

public class Photo {
    private String name;
    private String description;
    private Date createTime;
    private Date modifyTime;
    private int flag;
    private int albumDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAlbumDefault() {
        return albumDefault;
    }

    public void setAlbumDefault(int albumDefault) {
        this.albumDefault = albumDefault;
    }


}
