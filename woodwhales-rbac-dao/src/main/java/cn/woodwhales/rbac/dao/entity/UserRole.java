package cn.woodwhales.rbac.dao.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import cn.woodwhales.rbac.common.model.entity.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色表
 *
 * @author woodwhales on 2021-05-18 15:21:12
 *
 */
@TableName(value= "rbac_user_role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable, BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 用户角色表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户表主键
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 角色表主键
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 有效状态：0-有效，1-无效，2-删除
     */
    @TableField(value = "status")
    private Byte status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private java.util.Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private java.util.Date updateTime;

}