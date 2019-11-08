/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.18 : Database - lexcoin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lexcoin` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `lexcoin`;

/*Table structure for table `tb_coin` */

DROP TABLE IF EXISTS `tb_coin`;

CREATE TABLE `tb_coin` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `coin_name` varchar(10) DEFAULT NULL COMMENT '币种名称',
  `coin_code` varchar(10) DEFAULT NULL COMMENT '币种代码',
  `status` int(1) DEFAULT NULL COMMENT '币种状态',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_coin` */

/*Table structure for table `tb_configuration` */

DROP TABLE IF EXISTS `tb_configuration`;

CREATE TABLE `tb_configuration` (
  `id` varchar(50) NOT NULL,
  `key` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '键值',
  `value` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'value值',
  `describe` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='配置表';

/*Data for the table `tb_configuration` */

/*Table structure for table `tb_flowing_water` */

DROP TABLE IF EXISTS `tb_flowing_water`;

CREATE TABLE `tb_flowing_water` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `from_wallet` varchar(255) NOT NULL COMMENT '从钱包',
  `to_wallet` varchar(255) NOT NULL COMMENT '到钱包',
  `from_user` varchar(50) NOT NULL COMMENT '从用户',
  `to_user` varchar(50) NOT NULL COMMENT '到用户',
  `coin_id` varchar(50) DEFAULT NULL COMMENT '币种id',
  `amount` decimal(10,8) NOT NULL COMMENT '金额',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `type` int(1) DEFAULT NULL COMMENT '类型',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='流水表';

/*Data for the table `tb_flowing_water` */

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `created_time` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version_lock` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_role` */

insert  into `tb_role`(`id`,`description`,`created_time`,`name`,`role`,`version_lock`) values (1,'管理员拥有所有接口操作权限',1572958421,'管理员','ADMIN',NULL),(2,'普通拥有查看用户列表与修改密码权限，不具备对用户增删改权限',1572958421,'普通用户','USER',NULL);

/*Table structure for table `tb_role_user` */

DROP TABLE IF EXISTS `tb_role_user`;

CREATE TABLE `tb_role_user` (
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `version_lock` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `tb_role_user` */

insert  into `tb_role_user`(`role_id`,`user_id`,`version_lock`) values (1,1,NULL);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` varchar(50) NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `version_lock` int(20) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNION_KEY` (`account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`account`,`description`,`password`,`name`,`version_lock`,`create_time`,`update_time`) values ('1','admin','系统默认管理员','123456','小小丰',NULL,NULL,NULL);

/*Table structure for table `tb_user_money` */

DROP TABLE IF EXISTS `tb_user_money`;

CREATE TABLE `tb_user_money` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_id` varchar(50) DEFAULT NULL COMMENT '用户id',
  `coin_id` varchar(50) DEFAULT NULL COMMENT '币种',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `available_amount` decimal(10,8) NOT NULL DEFAULT '0.00000000' COMMENT '可用余额',
  `frozen_amount` decimal(10,8) NOT NULL DEFAULT '0.00000000' COMMENT '冻结余额',
  `lock_amount` decimal(10,8) NOT NULL DEFAULT '0.00000000' COMMENT '锁仓余额',
  `other_amount` decimal(10,8) NOT NULL DEFAULT '0.00000000' COMMENT '其他余额',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version_lock` bigint(50) DEFAULT NULL COMMENT '乐观锁',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNION_KEY` (`address`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户平台余额表';

/*Data for the table `tb_user_money` */

/*Table structure for table `tb_wallet` */

DROP TABLE IF EXISTS `tb_wallet`;

CREATE TABLE `tb_wallet` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `coin_id` varchar(50) DEFAULT NULL COMMENT '币种id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地址',
  `is_verification` int(1) NOT NULL DEFAULT '0' COMMENT '1:验证，0：没有验证',
  `describe` varchar(255) DEFAULT NULL COMMENT '描述',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除0：没有删除，1：已删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `version_lock` bigint(50) DEFAULT '0' COMMENT '乐观锁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='钱包地址表';

/*Data for the table `tb_wallet` */

/*Table structure for table `tb_withdrawal` */

DROP TABLE IF EXISTS `tb_withdrawal`;

CREATE TABLE `tb_withdrawal` (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `coin_id` varchar(50) DEFAULT NULL COMMENT '币种',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '提现地址',
  `amount` decimal(10,8) NOT NULL COMMENT '金额',
  `reason` varchar(255) DEFAULT NULL COMMENT '失败原因',
  `status` int(1) DEFAULT '0' COMMENT '提现状态0：未提现，1：已提现，2：提现失败',
  `version_lock` bigint(50) DEFAULT NULL COMMENT '乐观锁',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='提现表';

/*Data for the table `tb_withdrawal` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
