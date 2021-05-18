package cn.woodwhales.rbac.service.service;

import cn.woodwhales.rbac.common.model.param.UserCreateParam;
import cn.woodwhales.rbac.common.model.param.UserQueryParam;
import cn.woodwhales.rbac.common.model.param.UserUpdateParam;
import cn.woodwhales.rbac.common.model.vo.UserVO;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;

/**
 * 用户接口
 *
 * @author woodwhales
 */
public interface UserService {

    /**
     * 分页条件查询用户信息
     * @param param
     * @return
     */
    PageRespVO<UserVO> page(UserQueryParam param);

    /**
     * 创建用户
     * @param param
     * @return
     */
    OpResult<Void> create(UserCreateParam param);

    /**
     * 更新用户
     * @param param
     * @return
     */
    OpResult<Void> update(UserUpdateParam param);
}
