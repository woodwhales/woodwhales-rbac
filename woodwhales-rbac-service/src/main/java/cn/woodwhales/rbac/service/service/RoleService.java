package cn.woodwhales.rbac.service.service;

import cn.woodwhales.rbac.common.model.param.RoleCreateParam;
import cn.woodwhales.rbac.common.model.param.RoleQueryParam;
import cn.woodwhales.rbac.common.model.param.RoleUpdateParam;
import cn.woodwhales.rbac.common.model.vo.RoleVO;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;

/**
 * @author woodwhales
 */
public interface RoleService {

    /**
     * 分页查询角色数据
     * @param param
     * @return
     */
    PageRespVO<RoleVO> page(RoleQueryParam param);

    /**
     * 创建角色
     * @param param
     * @return
     */
    OpResult<Void> create(RoleCreateParam param);

    /**
     * 更新角色
     * @param param
     * @return
     */
    OpResult<Void> update(RoleUpdateParam param);
}