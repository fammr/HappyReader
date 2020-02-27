/*
Navicat MySQL Data Transfer

Source Server         : 47.104.76.77
Source Server Version : 50721
Source Host           : 47.104.76.77:3306
Source Database       : happy_reader

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-02-27 20:51:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book_type
-- ----------------------------
DROP TABLE IF EXISTS `t_book_type`;
CREATE TABLE `t_book_type` (
  `id` int(11) NOT NULL COMMENT '书籍类别id',
  `name` varchar(100) DEFAULT '' COMMENT '书籍类别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_book_type
-- ----------------------------
INSERT INTO `t_book_type` VALUES ('1', '穿越小说');
INSERT INTO `t_book_type` VALUES ('2', '军事小说');
INSERT INTO `t_book_type` VALUES ('3', '历史小说');
INSERT INTO `t_book_type` VALUES ('4', '网游小说');
INSERT INTO `t_book_type` VALUES ('5', '武侠小说');
INSERT INTO `t_book_type` VALUES ('6', '青春校园');
INSERT INTO `t_book_type` VALUES ('7', '当代小说');
INSERT INTO `t_book_type` VALUES ('8', '言情小说');
INSERT INTO `t_book_type` VALUES ('9', '生活科普');
INSERT INTO `t_book_type` VALUES ('10', '科幻小说');
INSERT INTO `t_book_type` VALUES ('11', '人物传记');
INSERT INTO `t_book_type` VALUES ('12', '文学名著');
INSERT INTO `t_book_type` VALUES ('13', '世界名著');
INSERT INTO `t_book_type` VALUES ('14', '玄幻仙侠');
INSERT INTO `t_book_type` VALUES ('15', '人文社科');
INSERT INTO `t_book_type` VALUES ('16', '侦探悬疑');
INSERT INTO `t_book_type` VALUES ('17', '古典名著');
INSERT INTO `t_book_type` VALUES ('18', '励志经管');
INSERT INTO `t_book_type` VALUES ('19', '散文诗集');
