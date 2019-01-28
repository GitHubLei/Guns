package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.activerecord.*;
import com.baomidou.mybatisplus.enums.*;
import com.baomidou.mybatisplus.annotations.*;
import java.util.*;
import java.io.*;

@TableName("cabinet_log")
public class CabinetLog extends Model<CabinetLog>
{
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("cabinet_code")
    private String cabinetCode;
    @TableField("door_code")
    private String doorCode;
    @TableField("box_code")
    private String boxCode;
    private String operate;
    @TableField("operate_time")
    private Date operateTime;
    @TableField("ext_remark")
    private String extRemark;
    
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
    
    public String getOperate() {
        return this.operate;
    }
    
    public void setOperate(final String operate) {
        this.operate = operate;
    }
    
    public Date getOperateTime() {
        return this.operateTime;
    }
    
    public void setOperateTime(final Date operateTime) {
        this.operateTime = operateTime;
    }
    
    public String getExtRemark() {
        return this.extRemark;
    }
    
    public void setExtRemark(final String extRemark) {
        this.extRemark = extRemark;
    }
    
    protected Serializable pkVal() {
        return this.id;
    }
    
    public String toString() {
        return "CabinetLog{, id=" + this.id + ", cabinetCode=" + this.cabinetCode + ", doorCode=" + this.doorCode + ", boxCode=" + this.boxCode + ", operate=" + this.operate + ", operateTime=" + this.operateTime + ", extRemark=" + this.extRemark + "}";
    }
}
