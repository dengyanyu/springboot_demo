/*
Navicat MySQL Data Transfer

Source Server         : 1602b
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : 1602b

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-17 16:09:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for z_zhongjian
-- ----------------------------
DROP TABLE IF EXISTS `z_zhongjian`;
CREATE TABLE `z_zhongjian` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `jid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of z_zhongjian
-- ----------------------------
INSERT INTO `z_zhongjian` VALUES ('1', '1', '1', '1');
INSERT INTO `z_zhongjian` VALUES ('9', '4', '1', null);
INSERT INTO `z_zhongjian` VALUES ('10', '5', '2', null);
