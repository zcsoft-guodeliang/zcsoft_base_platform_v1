/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.36 : Database - zcsoft_base_platform_v1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zcsoft_base_platform_v1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zcsoft_base_platform_v1`;

/*Table structure for table `t_sys_config` */

DROP TABLE IF EXISTS `t_sys_config`;

CREATE TABLE `t_sys_config` (
  `name` varchar(50) NOT NULL,
  `value` varchar(300) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_config` */

insert  into `t_sys_config`(`name`,`value`) values ('customName','智蝉科技基础研发平台');

/*Table structure for table `t_sys_permission` */

DROP TABLE IF EXISTS `t_sys_permission`;

CREATE TABLE `t_sys_permission` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `name` varchar(128) NOT NULL COMMENT '资源名称',
  `type` varchar(32) NOT NULL COMMENT '资源类型：menu,button,',
  `url` varchar(128) DEFAULT NULL COMMENT '访问url地址',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `percode` varchar(128) DEFAULT NULL COMMENT '权限代码字符串',
  `parentid` varchar(50) DEFAULT NULL COMMENT '父结点id',
  `sortstring` int(10) NOT NULL AUTO_INCREMENT COMMENT '排序号',
  `available` char(1) DEFAULT NULL COMMENT '是否可用,0：可用，1不可用',
  PRIMARY KEY (`id`),
  KEY `sortstring` (`sortstring`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_permission` */

insert  into `t_sys_permission`(`id`,`name`,`type`,`url`,`icon`,`percode`,`parentid`,`sortstring`,`available`) values ('11','系统管理','menu','','menu-icon fa  fa-desktop',NULL,'-1',0,'0'),('12','用户新增','permission','user/add.do',NULL,'user:add','21',2,'0'),('13','用户修改','permission','user/update.do',NULL,'user:modify','21',3,'0'),('14','用户删除','permission','',NULL,'user:del','21',4,'0'),('21','用户管理','menu','user/pageQuery.do',NULL,'','11',1,'0'),('22','菜单管理','menu','menu/pageQuery.do',NULL,'','11',6,'0'),('23','菜单新增','permission','menu/add.do',NULL,'menu:add','22',7,'0'),('24','菜单新增数据保存','permission','menu/save.do',NULL,'menu:save','22',8,'0'),('2620bca3-da5f-11e7-91a3-000c2967db6c','角色修改','permission','role/modify.do',NULL,'role:modify','693027e4-d995-11e7-8468-000c2967db6c',19,'0'),('64afbe87-da4f-11e7-91a3-000c2967db6c','业务管理','menu','','menu-icon fa fa-film','','-1',18,'0'),('693027e4-d995-11e7-8468-000c2967db6c','角色管理','menu','role/pageQuery.do',NULL,'','11',15,'0'),('948d62f5-da5f-11e7-91a3-000c2967db6c','角色删除','permission','role/del.do',NULL,'role:del','693027e4-d995-11e7-8468-000c2967db6c',20,'0'),('cb21d655-da61-11e7-91a3-000c2967db6c','菜单修改','permission','menu/modify.do',NULL,'menu:modify','22',21,'0'),('eff7120e-d9a7-11e7-8468-000c2967db6c','用户新增数据保存','permission','user/save.do',NULL,'user:save','21',17,'0'),('f83c5ed1-d995-11e7-8468-000c2967db6c','角色新增','permission','role/add.do',NULL,'role:add','693027e4-d995-11e7-8468-000c2967db6c',16,'0');

/*Table structure for table `t_sys_role` */

DROP TABLE IF EXISTS `t_sys_role`;

CREATE TABLE `t_sys_role` (
  `id` varchar(50) NOT NULL,
  `name` varchar(128) NOT NULL,
  `available` char(1) DEFAULT '0' COMMENT '是否可用,0：可用，1不可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role` */

insert  into `t_sys_role`(`id`,`name`,`available`) values ('1','超级管理员角色','0'),('2','测试角色1','1'),('8ecabfd8-da3f-11e7-91a3-000c2967db6c','测试信息','1'),('b1b78ce9-da34-11e7-91a3-000c2967db6c','普通用户','0'),('f674e41e-da3d-11e7-91a3-000c2967db6c','普通测试用户','1');

/*Table structure for table `t_sys_role_permission` */

DROP TABLE IF EXISTS `t_sys_role_permission`;

CREATE TABLE `t_sys_role_permission` (
  `id` varchar(50) NOT NULL,
  `sys_role_id` varchar(50) NOT NULL COMMENT '角色id',
  `sys_permission_id` varchar(50) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_role_permission` */

insert  into `t_sys_role_permission`(`id`,`sys_role_id`,`sys_permission_id`) values ('214f5142-94cc-468d-ab66-7f0f06307486','b1b78ce9-da34-11e7-91a3-000c2967db6c','12'),('3fe4b412-3933-4512-a406-7eafeb5655e3','1','11'),('7071383a-5e4a-4132-bfed-3a45b35967b0','b1b78ce9-da34-11e7-91a3-000c2967db6c','14'),('71ebc667-c1bf-432d-bd50-ec2961a1016c','b1b78ce9-da34-11e7-91a3-000c2967db6c','21'),('7b53b6df-c9e0-411e-aea7-9cb365d4fd60','b1b78ce9-da34-11e7-91a3-000c2967db6c','-1'),('b52fe627-34ae-47e7-a11b-2ee3abe40ac0','b1b78ce9-da34-11e7-91a3-000c2967db6c','11'),('f870d866-e9cd-4ae5-a949-0a4edfb6e581','b1b78ce9-da34-11e7-91a3-000c2967db6c','13');

/*Table structure for table `t_sys_user` */

DROP TABLE IF EXISTS `t_sys_user`;

CREATE TABLE `t_sys_user` (
  `OID` varchar(50) NOT NULL,
  `CODE` varchar(20) NOT NULL,
  `USER_PASS` varchar(32) NOT NULL,
  `SALT` varchar(50) NOT NULL,
  `USER_NAME` varchar(20) NOT NULL,
  `USER_TYPE` varchar(2) NOT NULL,
  `USER_SEX` varchar(2) DEFAULT '1',
  `USER_TEL` varchar(11) DEFAULT '',
  `USER_EMAIL` varchar(20) DEFAULT '',
  `ORDER_NUM` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(80) DEFAULT '',
  `headImg` varchar(350) DEFAULT '',
  `DEL_FLAG` varchar(1) NOT NULL DEFAULT '1',
  `CREATE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `UPDATE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `EXT1` varchar(50) DEFAULT '',
  `EXT2` varchar(50) DEFAULT '',
  `EXT3` varchar(50) DEFAULT '',
  PRIMARY KEY (`OID`),
  KEY `ORDER_NUM` (`ORDER_NUM`),
  KEY `ORDER_NUM_2` (`ORDER_NUM`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user` */

insert  into `t_sys_user`(`OID`,`CODE`,`USER_PASS`,`SALT`,`USER_NAME`,`USER_TYPE`,`USER_SEX`,`USER_TEL`,`USER_EMAIL`,`ORDER_NUM`,`openid`,`headImg`,`DEL_FLAG`,`CREATE_DATE`,`UPDATE_DATE`,`EXT1`,`EXT2`,`EXT3`) values ('1','superadmin','8b1964eec86391692185950fa0ce604e','ZCSOFT','超级管理员','1','1','18075689192','23557869@qq.com',68,NULL,'E:\\jixiaoguanli\\headImg\\1\\20171206\\05623dae-a7e9-40c7-8d29-a31c15ae5ac1.png','1','2017-11-20 14:11:51','2017-11-20 14:11:51','','',''),('235c8440-da28-11e7-91a3-000c2967db6c','ceshi','4acb24f8ac3f9dc676dfca4abffe2639','ZCSOFT','测试用户','2','2','','',72,NULL,'E:\\jixiaoguanli\\headImg\\1\\20171206\\35c5e4a6-083f-4e87-8dc0-09b7b1f99003.png','1','2017-12-06 09:52:38','2017-12-06 09:52:38','','',''),('8d1f3a8e-da4e-11e7-91a3-000c2967db6c','guodl','31f72805f7cbaafef6eeaa3011651523','33793c02-b506-40f6-ac5a-c49bb743e478','郭德亮','2','1','','',75,NULL,'E:\\jixiaoguanli\\headImg\\1\\20171206\\73b099a4-1f1b-4649-a5ae-6a739fc99c0a.png','1','2017-12-06 14:27:36','2017-12-06 14:27:36','','',''),('92b7ae81-da4d-11e7-91a3-000c2967db6c','guodl','930f7b16a07220e9d91e33b49f7ea963','ZCSOFT','郭德亮','2','1','','',73,NULL,'E:\\jixiaoguanli\\headImg\\1\\20171206\\b4c88797-e5d6-47e2-b174-e765a0e9ddfd.png','2','2017-12-06 14:20:36','2017-12-06 14:20:36','','',''),('b014e375-d9b2-11e7-8468-000c2967db6c','cesh','c01536e552e7b97dd2941f0cc511b095','ZCSOFT','测试1','2','1','11','11',71,NULL,'E:\\jixiaoguanli\\headImg\\1\\20171205\\ef28bfb0-ade8-4cfa-8c28-50c18baddfdc.png','2','2017-12-05 19:51:53','2017-12-05 19:51:53','','',''),('b8fb74e0-da4d-11e7-91a3-000c2967db6c','xxxx','9586d6e19aa785724923becc09c6581e','ZCSOFT','嘻嘻嘻','2','1','','',74,NULL,'','2','2017-12-06 14:21:40','2017-12-06 14:21:40','','','');

/*Table structure for table `t_sys_user_role` */

DROP TABLE IF EXISTS `t_sys_user_role`;

CREATE TABLE `t_sys_user_role` (
  `id` varchar(36) NOT NULL,
  `sys_user_id` varchar(50) NOT NULL,
  `sys_role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_sys_user_role` */

insert  into `t_sys_user_role`(`id`,`sys_user_id`,`sys_role_id`) values ('44d34e70-b4f6-4fff-8ca6-40a4716ab118','235c8440-da28-11e7-91a3-000c2967db6c','b1b78ce9-da34-11e7-91a3-000c2967db6c'),('56070edf-5bd3-4b45-9232-ba16d5106805','8d1f3a8e-da4e-11e7-91a3-000c2967db6c','-1'),('6de5344d-bd1e-4601-a1af-408d98773486','235c8440-da28-11e7-91a3-000c2967db6c','-1'),('76285205-1145-4bc3-b67b-1cecce396e55','8d1f3a8e-da4e-11e7-91a3-000c2967db6c','b1b78ce9-da34-11e7-91a3-000c2967db6c'),('7981ee5b-c9dd-4ece-95c0-354763e04a89','8d1f3a8e-da4e-11e7-91a3-000c2967db6c','-1'),('833f0a86-9ba8-4b8b-8523-bfff13cdc5b5','1','1'),('d367a005-e419-4212-b735-eaf89168ebb2','1','2'),('e1a0eace-2d8c-4d9c-ad57-788e72fccd84','1','-1'),('fd036f66-2918-44c5-8f58-eaa638fe9cb2','8d1f3a8e-da4e-11e7-91a3-000c2967db6c','b1b78ce9-da34-11e7-91a3-000c2967db6c');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
