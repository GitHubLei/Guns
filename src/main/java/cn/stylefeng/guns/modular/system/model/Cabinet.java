package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.*;
import com.baomidou.mybatisplus.annotations.*;
import java.util.*;
import java.io.*;

@TableName("cabinet")
public class Cabinet extends Model<Cabinet>
{
    private static final long serialVersionUID = 1L;
    private Long id;
    @TableField("cabinet_code")
    private String cabinetCode;
    @TableField("door_code")
    private String doorCode;
    @TableField("box_code")
    private String boxCode;
    private Integer locker;
    private Integer status;
    @TableField("create_time")
    private Date createTime;
    private Date version;
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(final Long id) {
        this.id = id;
    }
    
    public String getCabinetCode() {
        return this.cabinetCode;
    }
    
    public void setCabinetCode(final String cabinetCode) {
        this.cabinetCode = cabinetCode;
    }
    
    public String getDoorCode() {
        return this.doorCode;
    }
    
    public void setDoorCode(final String doorCode) {
        this.doorCode = doorCode;
    }
    
    public String getBoxCode() {
        return this.boxCode;
    }
    
    public void setBoxCode(final String boxCode) {
        this.boxCode = boxCode;
    }
    
    public Integer getLocker() {
        return this.locker;
    }
    
    public void setLocker(final Integer locker) {
        this.locker = locker;
    }
    
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(final Integer status) {
        this.status = status;
    }
    
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getVersion() {
        return this.version;
    }
    
    public void setVersion(final Date version) {
        this.version = version;
    }
    
    protected Serializable pkVal() {
        return this.id;
    }
    
    public String toString() {
        return "Cabinet{, id=" + this.id + ", cabinetCode=" + this.cabinetCode + ", doorCode=" + this.doorCode + ", boxCode=" + this.boxCode + ", locker=" + this.locker + ", status=" + this.status + ", createTime=" + this.createTime + ", version=" + this.version + "}";
    }
}
