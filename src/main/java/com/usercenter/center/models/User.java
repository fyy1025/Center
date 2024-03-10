package com.usercenter.center.models;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户表
 * @author fyy
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 名称
     */
    private String userName;

    /**
     * 
     */
    private Long role;

    /**
     * 用户状态
     */
    private Integer valid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer logicDelete;

    /**
     * 邀请编号
     */
    private String invitationNumber;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}