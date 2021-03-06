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
 * 角色权限表
 *
 * @author woodwhales on 2021-05-18 15:21:12
 *
 */
@TableName(value= "rbac_role_permission")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission implements Serializable, BaseEntity {
    
    private static final long serialVersionUID = 1L;

    /**
     * 角色权限表主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色表主键
     */
    @TableField(value = "role_id")
    private Long roleId;

    /**
     * 权限表主键
     */
    @TableField(value = "permission_id")
    private Long permissionId;

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