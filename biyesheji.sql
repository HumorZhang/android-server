/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : biyesheji

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-07 17:39:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tab_admin
-- ----------------------------
DROP TABLE IF EXISTS `tab_admin`;
CREATE TABLE `tab_admin` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_admin
-- ----------------------------
INSERT INTO `tab_admin` VALUES ('赵俊生', '123456');

-- ----------------------------
-- Table structure for tab_gonggao
-- ----------------------------
DROP TABLE IF EXISTS `tab_gonggao`;
CREATE TABLE `tab_gonggao` (
  `gonggao` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_gonggao
-- ----------------------------
INSERT INTO `tab_gonggao` VALUES ('今天答辩！');

-- ----------------------------
-- Table structure for tab_time
-- ----------------------------
DROP TABLE IF EXISTS `tab_time`;
CREATE TABLE `tab_time` (
  `keming` varchar(255) DEFAULT NULL,
  `Time` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `name` text,
  `buff` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_time
-- ----------------------------
INSERT INTO `tab_time` VALUES ('操作系统', '1_1', null, null, '0');
INSERT INTO `tab_time` VALUES ('计算机网络', '1_2', '3', '杨菲,zs,杨浩', '0');
INSERT INTO `tab_time` VALUES ('高等数学', '1_3', null, null, '0');
INSERT INTO `tab_time` VALUES ('体育', '1_4', null, null, '0');
INSERT INTO `tab_time` VALUES ('线性代数', '2_1', null, null, '0');
INSERT INTO `tab_time` VALUES ('null', '2_2', null, null, '0');
INSERT INTO `tab_time` VALUES ('SQL', '2_3', null, null, '0');
INSERT INTO `tab_time` VALUES ('Android', '2_4', null, null, '0');
INSERT INTO `tab_time` VALUES ('高等数学', '3_1', null, null, '0');
INSERT INTO `tab_time` VALUES ('思修', '3_2', null, null, '0');
INSERT INTO `tab_time` VALUES ('计算机网络', '3_3', null, null, '0');
INSERT INTO `tab_time` VALUES ('c语言', '3_4', null, null, '0');
INSERT INTO `tab_time` VALUES ('null', '4_1', null, null, '0');
INSERT INTO `tab_time` VALUES ('操作系统', '4_2', null, null, '0');
INSERT INTO `tab_time` VALUES ('c++', '4_3', null, null, '0');
INSERT INTO `tab_time` VALUES ('线性代数 ', '4_4', null, null, '0');
INSERT INTO `tab_time` VALUES ('c语言', '5_1', null, null, '0');
INSERT INTO `tab_time` VALUES ('网站设计', '5_2', null, null, '0');
INSERT INTO `tab_time` VALUES ('专业英语', '5_3', null, null, '0');
INSERT INTO `tab_time` VALUES ('null', '5_4', null, null, '0');

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user` (
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `buff` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES ('杨菲', '123', '0', '201410201001');
INSERT INTO `tab_user` VALUES ('zs', '123', '0', '201410201002');
INSERT INTO `tab_user` VALUES ('杨浩', '456', '0', '201410201007');
INSERT INTO `tab_user` VALUES ('崔广', '123', '0', '201410201031');
INSERT INTO `tab_user` VALUES ('潘得付', '123456', '0', '201410201032');
INSERT INTO `tab_user` VALUES ('张吟霜', '123', '0', '201410201033');
INSERT INTO `tab_user` VALUES ('胡彬', '123456', '0', '201410201035');
INSERT INTO `tab_user` VALUES ('李振涛', '000000', '0', '201410201038');
INSERT INTO `tab_user` VALUES ('张吟霜', '123', '0', '201420201033');
INSERT INTO `tab_user` VALUES ('张三', '123', '0', '201420201034');
