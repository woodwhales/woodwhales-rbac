package cn.woodwhales.rbac.common.model.entity;

import java.util.Date;

/**
 * @author woodwhales on 2021-05-18 15:20
 * @description
 */
public interface BaseEntity {

    /**
     * 数据库表主键
     * @return
     */
    Long getId();

    /**
     * 数据库表主键
     * @param id
     */
    void setId(Long id);

    /**
     * 有效状态：0-有效，1-无效，2-删除
     * @param status
     */
    void setStatus(Byte status);

    /**
     * 有效状态：0-有效，1-无效，2-删除
     * @return
     */
    Byte getStatus();

    /**
     * 创建时间
     * @param createTime
     */
    void setCreateTime(Date createTime);

    /**
     * 创建时间
     * @return
     */
    Date getCreateTime();

    /**
     * 更新时间
     * @param updateTime
     */
    void setUpdateTime(Date updateTime);

    /**
     * 更新时间
     * @return
     */
    Date getUpdateTime();

}
