package cn.woodwhales.rbac.common.model.param;

import lombok.Data;
import org.woodwhales.common.model.param.PageQueryParam;

/**
 * @author woodwhales on 2021-05-18 16:38
 * @description
 */
@Data
public class PermissionQueryParam extends PageQueryParam {

    /**
     * 搜索条件
     */
    private String searchInfo;

}
