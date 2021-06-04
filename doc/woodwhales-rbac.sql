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
INSERT INTO `rbac_permission` (`id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES
	(1, '管理徒弟', NULL, 0, '2021-06-04 17:52:29', '2021-06-04 17:52:29'),
	(2, '打坐念经', NULL, 0, '2021-06-04 17:53:19', '2021-06-04 17:53:19'),
	(3, '西天取经', NULL, 0, '2021-06-04 18:09:20', '2021-06-04 18:09:20'),
	(4, '捉妖打怪', NULL, 0, '2021-06-04 18:14:02', '2021-06-04 18:14:02'),
	(5, '背行李', NULL, 0, '2021-06-04 18:33:57', '2021-06-04 18:33:57'),
	(6, '逼迫师傅使出紧箍咒', NULL, 0, '2021-06-04 18:38:07', '2021-06-04 18:38:07');
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
INSERT INTO `rbac_role` (`id`, `name`, `description`, `status`, `create_time`, `update_time`) VALUES
	(1, '师傅', '师傅就是领导', 0, '2021-06-04 17:51:33', '2021-06-04 17:51:33'),
	(2, '徒弟', '徒弟就是小弟', 0, '2021-06-04 17:51:39', '2021-06-04 17:51:39'),
	(3, '反对师傅', '孙悟空专属角色', 0, '2021-06-04 18:16:10', '2021-06-04 18:16:10'),
	(4, '任劳任怨', '白龙马和沙悟净专属', 0, '2021-06-04 18:33:30', '2021-06-04 18:33:30');
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
INSERT INTO `rbac_role_permission` (`id`, `role_id`, `permission_id`, `status`, `create_time`, `update_time`) VALUES
	(1, 1, 1, 2, '2021-06-04 17:57:27', '2021-06-04 17:57:27'),
	(2, 1, 2, 0, '2021-06-04 17:57:27', '2021-06-04 17:57:27'),
	(3, 1, 1, 0, '2021-06-04 18:09:38', '2021-06-04 18:09:38'),
	(4, 1, 3, 0, '2021-06-04 18:09:38', '2021-06-04 18:09:38'),
	(5, 2, 3, 0, '2021-06-04 18:10:18', '2021-06-04 18:10:18'),
	(6, 2, 4, 0, '2021-06-04 18:14:20', '2021-06-04 18:14:20'),
	(7, 4, 5, 0, '2021-06-04 18:34:38', '2021-06-04 18:34:38'),
	(8, 3, 6, 0, '2021-06-04 18:38:48', '2021-06-04 18:38:48');
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

-- 正在导出表  woodwhales_rbac.rbac_user 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `rbac_user` DISABLE KEYS */;
INSERT INTO `rbac_user` (`id`, `user_code`, `user_name`, `user_pwd`, `status`, `create_time`, `update_time`) VALUES
	(1, '1400750644775718913', '孙悟空', 'e10adc3949ba59abbe56e057f20f883e', 0, '2021-06-04 17:45:53', '2021-06-04 17:45:53'),
	(2, '1400750672709783554', '唐僧', 'e10adc3949ba59abbe56e057f20f883e', 0, '2021-06-04 17:45:59', '2021-06-04 17:45:59'),
	(3, '1400750699377168386', '猪八戒', 'e10adc3949ba59abbe56e057f20f883e', 0, '2021-06-04 17:46:06', '2021-06-04 17:46:06'),
	(4, '1400750742498807810', '沙悟净', 'e10adc3949ba59abbe56e057f20f883e', 0, '2021-06-04 17:46:16', '2021-06-04 17:46:16'),
	(5, '1400750822467407874', '白龙马', 'e10adc3949ba59abbe56e057f20f883e', 0, '2021-06-04 17:46:35', '2021-06-04 17:46:35');
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
INSERT INTO `rbac_user_role` (`id`, `user_id`, `role_id`, `status`, `create_time`, `update_time`) VALUES
	(1, 1, 2, 0, '2021-06-04 18:08:08', '2021-06-04 18:08:08'),
	(2, 3, 2, 0, '2021-06-04 18:11:58', '2021-06-04 18:11:58'),
	(3, 4, 2, 2, '2021-06-04 18:12:17', '2021-06-04 18:12:17'),
	(4, 5, 2, 2, '2021-06-04 18:12:28', '2021-06-04 18:12:28'),
	(5, 1, 3, 0, '2021-06-04 18:17:16', '2021-06-04 18:17:16'),
	(6, 2, 1, 0, '2021-06-04 18:32:16', '2021-06-04 18:32:16'),
	(7, 5, 1, 2, '2021-06-04 18:35:10', '2021-06-04 18:35:10'),
	(8, 5, 4, 0, '2021-06-04 18:35:10', '2021-06-04 18:35:10'),
	(9, 4, 1, 2, '2021-06-04 18:35:22', '2021-06-04 18:35:22'),
	(10, 4, 4, 0, '2021-06-04 18:35:22', '2021-06-04 18:35:22'),
	(11, 4, 2, 0, '2021-06-04 18:35:52', '2021-06-04 18:35:52'),
	(12, 5, 2, 0, '2021-06-04 18:36:05', '2021-06-04 18:36:05');
/*!40000 ALTER TABLE `rbac_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
