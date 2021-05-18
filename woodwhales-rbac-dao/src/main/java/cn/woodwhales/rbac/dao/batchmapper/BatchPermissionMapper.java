package cn.woodwhales.rbac.dao.batchmapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import cn.woodwhales.rbac.dao.entity.Permission;
import cn.woodwhales.rbac.dao.mapper.PermissionMapper;

/**
 * BatchPermissionMapper
 *
 * @author woodwhales on 2021-05-18 15:21:12
 *
 */
@Service
public class BatchPermissionMapper extends ServiceImpl<PermissionMapper, Permission> {
    
}