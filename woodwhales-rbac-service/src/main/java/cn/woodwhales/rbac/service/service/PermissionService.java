package cn.woodwhales.rbac.service.service;

import cn.woodwhales.rbac.common.model.param.PermissionCreateParam;
import cn.woodwhales.rbac.common.model.param.PermissionQueryParam;
import cn.woodwhales.rbac.common.model.param.PermissionUpdateParam;
import cn.woodwhales.rbac.common.model.vo.PermissionVO;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;

/**
 * 权限接口
 *
 * @author woodwhales
 */
public interface PermissionService {

    /**
     * 条件分页查询权限信息
     * @param param
     * @return
     */
    PageRespVO<PermissionVO> page(PermissionQueryParam param);

    /**
     * 创建权限信息
     * @param param
     * @return
     */
    OpResult<Void> create(PermissionCreateParam param);

    /**
     * 更新权限信息
     * @param param
     * @return
     */
    OpResult<Void> update(PermissionUpdateParam param);
}
