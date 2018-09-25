/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:09:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_classroom
-- ----------------------------
DROP TABLE IF EXISTS `z_classroom`;
CREATE TABLE `z_classroom` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_classroom
-- ----------------------------
INSERT INTO `z_classroom` VALUES ('1', '36301', '云计算主楼3层；21209，U型楼2层');
INSERT INTO `z_classroom` VALUES ('2', '36302', '云计算主楼3层；21209，U型楼2层');
INSERT INTO `z_classroom` VALUES ('3', '36303', '云计算主楼3层；21209，U型楼2层');
INSERT INTO `z_classroom` VALUES ('4', '36304', '云计算主楼3层；21209，U型楼2层');
INSERT INTO `z_classroom` VALUES ('5', '36305', '云计算主楼3层；21209，U型楼2层');
INSERT INTO `z_classroom` VALUES ('6', '36306', '云计算主楼3层；21209，U型楼2层');
