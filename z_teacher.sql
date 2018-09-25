/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:09:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_teacher
-- ----------------------------
DROP TABLE IF EXISTS `z_teacher`;
CREATE TABLE `z_teacher` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `jname` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `jdate` date DEFAULT NULL,
  PRIMARY KEY (`jid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_teacher
-- ----------------------------
INSERT INTO `z_teacher` VALUES ('1', '冯琪', '33', '2018-08-22');
INSERT INTO `z_teacher` VALUES ('2', '李海松', '34', '2018-09-11');
INSERT INTO `z_teacher` VALUES ('3', '郜怀达', '45', '2018-09-18');
INSERT INTO `z_teacher` VALUES ('4', '王超', '30', '2018-09-18');
