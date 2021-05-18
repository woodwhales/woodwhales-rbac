package cn.woodwhales.rbac.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author woodwhales on 2021-05-18 16:06
 * @description mybatisPlus 配置类
 */
@Configuration
@MapperScan("cn.woodwhales.rbac.dao.**.mapper")
public class MybatisPlusConfig {


}
