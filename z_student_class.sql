/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:08:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_student_class
-- ----------------------------
DROP TABLE IF EXISTS `z_student_class`;
CREATE TABLE `z_student_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_student_class
-- ----------------------------
INSERT INTO `z_student_class` VALUES ('1', '1', '1');
INSERT INTO `z_student_class` VALUES ('2', '1', '2');
INSERT INTO `z_student_class` VALUES ('3', '2', '3');
INSERT INTO `z_student_class` VALUES ('4', '2', '3');
INSERT INTO `z_student_class` VALUES ('5', '3', '4');
INSERT INTO `z_student_class` VALUES ('6', '4', '5');
INSERT INTO `z_student_class` VALUES ('7', '4', '6');
