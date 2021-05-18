package cn.woodwhales.rbac.service.impl;

import cn.hutool.crypto.SecureUtil;
import cn.woodwhales.rbac.common.model.param.UserCreateParam;
import cn.woodwhales.rbac.common.model.param.UserQueryParam;
import cn.woodwhales.rbac.common.model.param.UserUpdateParam;
import cn.woodwhales.rbac.common.model.vo.UserVO;
import cn.woodwhales.rbac.dao.entity.User;
import cn.woodwhales.rbac.dao.mapper.UserMapper;
import cn.woodwhales.rbac.service.converter.EntityToVOInterface;
import cn.woodwhales.rbac.service.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.woodwhales.common.model.result.OpResult;
import org.woodwhales.common.model.vo.PageRespVO;
import org.woodwhales.mybatisplus.MybatisPlusExecutor;

/**
 * @author woodwhales on 2021-05-18 21:08
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("userConverterImpl")
    private EntityToVOInterface<User, UserVO> entityToVOInterface;

    @Override
    public PageRespVO<UserVO> page(UserQueryParam param) {
        return MybatisPlusExecutor.executeQueryPage(userMapper, param, wrapper -> {
            wrapper.like(StringUtils.isNotBlank(param.getSearchInfo()), User::getUserName, param.getSearchInfo());
        }, entityToVOInterface::convertToVO);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> create(UserCreateParam param) {
        User user = new User();
        user.setUserName(param.getUserName());
        user.setUserCode(IdWorker.getIdStr());
        user.setUserPwd(SecureUtil.md5("123456"));
        userMapper.insert(user);
        return OpResult.success();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Error.class})
    public OpResult<Void> update(UserUpdateParam param) {
        User user = userMapper.selectById(param.getId());
        user.setUserName(param.getUserName());
        userMapper.updateById(user);
        return OpResult.success();
    }
}
