/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:09:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_class
-- ----------------------------
DROP TABLE IF EXISTS `z_class`;
CREATE TABLE `z_class` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) DEFAULT NULL,
  `bdate` date DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_class
-- ----------------------------
INSERT INTO `z_class` VALUES ('4', '1602D', '2018-09-27');
INSERT INTO `z_class` VALUES ('5', '1602B', '2018-09-12');
