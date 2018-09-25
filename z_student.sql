/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:08:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_student
-- ----------------------------
DROP TABLE IF EXISTS `z_student`;
CREATE TABLE `z_student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) DEFAULT NULL,
  `zhuzhi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_student
-- ----------------------------
INSERT INTO `z_student` VALUES ('1', '谢晓亮', '安徽');
INSERT INTO `z_student` VALUES ('2', '霍志雄', '山西');
INSERT INTO `z_student` VALUES ('3', '陈嘉玉', '甘肃');
INSERT INTO `z_student` VALUES ('4', '王善林', '山东');
INSERT INTO `z_student` VALUES ('5', '张国浩', '河南');
INSERT INTO `z_student` VALUES ('6', '张波', '河北');
INSERT INTO `z_student` VALUES ('7', '车乾', '湖南');
INSERT INTO `z_student` VALUES ('8', '张建军', '湖北');
