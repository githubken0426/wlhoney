package cn.honey.home.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;
    @Column(name = "modify_time", insertable = false, updatable = false)
    private Date modifyTime;

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
}
