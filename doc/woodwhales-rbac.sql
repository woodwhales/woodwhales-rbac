-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.27 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 woodwhales_rbac 的数据库结构
CREATE DATABASE IF NOT EXISTS `woodwhales_rbac` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `woodwhales_rbac`;

-- 导出  表 woodwhales_rbac.rbac_permission 结构
CREATE TABLE IF NOT EXISTS `rbac_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '权限表主键',
  `name` varchar(300) NOT NULL COMMENT '权限名称',
  `description` varchar(500) DEFAULT NULL COMMENT '权限备注',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '有效状态：0-有效，1-无效，2-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- 正在导出表  woodwhales_rbac.rbac_permission 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rbac_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `rbac_permission` ENABLE KEYS */;

-- 导出  表 woodwhales_rbac.rbac_role 结构
CREATE TABLE IF NOT EXISTS `rbac_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色表主键',
  `name` varchar(300) NOT NULL COMMENT '角色名称',
  `description` varchar(500) DEFAULT NULL COMMENT '角色备注',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '有效状态：0-有效，1-无效，2-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- 正在导出表  woodwhales_rbac.rbac_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rbac_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `rbac_role` ENABLE KEYS */;

-- 导出  表 woodwhales_rbac.rbac_role_permission 结构
CREATE TABLE IF NOT EXISTS `rbac_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色权限表主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色表主键',
  `permission_id` bigint(20) unsigned NOT NULL COMMENT '权限表主键',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '有效状态：0-有效，1-无效，2-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- 正在导出表  woodwhales_rbac.rbac_role_permission 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rbac_role_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `rbac_role_permission` ENABLE KEYS */;

-- 导出  表 woodwhales_rbac.rbac_user 结构
CREATE TABLE IF NOT EXISTS `rbac_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `user_code` varchar(80) NOT NULL COMMENT '用户编号',
  `user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `user_pwd` varchar(150) NOT NULL COMMENT '用户密码',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '有效状态：0-有效，1-无效，2-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_code` (`user_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  woodwhales_rbac.rbac_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rbac_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `rbac_user` ENABLE KEYS */;

-- 导出  表 woodwhales_rbac.rbac_user_role 结构
CREATE TABLE IF NOT EXISTS `rbac_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户角色表主键',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户表主键',
  `role_id` bigint(20) unsigned NOT NULL COMMENT '角色表主键',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '有效状态：0-有效，1-无效，2-删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- 正在导出表  woodwhales_rbac.rbac_user_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `rbac_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `rbac_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
