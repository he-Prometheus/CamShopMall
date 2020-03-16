/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:32:37
*/
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_money` decimal(19,2) DEFAULT NULL,
  `user_register_time` date DEFAULT NULL,
  `register_time` date DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '赵雷', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('2', '钱电', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('3', '孙风', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('4', '李云', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('5', '周梅', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('6', '吴兰', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('7', '郑竹', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('8', '张三', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('9', '李四', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('10', '李四', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('11', '赵六', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('12', '孙七', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('13', '大耳', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('14', '张飞', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('15', '关羽', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);
INSERT INTO `user` VALUES ('16', '诸葛亮', 'e10adc3949ba59abbe56e057f20f883e', '2954678978@qq.com', '100.00', '2019-06-01', null);




SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adm_id` int(11) NOT NULL AUTO_INCREMENT,
  `adm_name` varchar(255) DEFAULT NULL,
  `adm_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e');



/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:32:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` decimal(19,2) DEFAULT NULL,
  `goods_desc` varchar(255) DEFAULT NULL,
  `goods_modified_time` date DEFAULT NULL,
  `belong` int(11) DEFAULT NULL,
  `user_goods_id` int(11) DEFAULT NULL,
  `adm_goods_id` int(11) DEFAULT NULL,
  `order_goods_id` int(11) DEFAULT NULL,
  `goods_category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`goods_id`),
  UNIQUE KEY `UK_s7h62qumphjveifnbio2qae14` (`order_goods_id`),
  KEY `FKcolheje1vog0nla1mu3jt7i3` (`user_goods_id`),
  KEY `FKn0tw96p7ig8sntf8cqqjdkkwi` (`adm_goods_id`),
  KEY `FK4scybpqiw6kjj98mijbic17j` (`goods_category_id`),
  CONSTRAINT `FK4scybpqiw6kjj98mijbic17j` FOREIGN KEY (`goods_category_id`) REFERENCES `produce_category` (`pro_id`),
  CONSTRAINT `FKcolheje1vog0nla1mu3jt7i3` FOREIGN KEY (`user_goods_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FKd3iq4r4jduede16ykd3y2dgdr` FOREIGN KEY (`order_goods_id`) REFERENCES `order_detail` (`order_id`),
  CONSTRAINT `FKn0tw96p7ig8sntf8cqqjdkkwi` FOREIGN KEY (`adm_goods_id`) REFERENCES `admin` (`adm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '书包', '10.00', '10', '2019-06-01', '1', '1', '1', null, '1');
INSERT INTO `goods` VALUES ('2', '水杯', '10.00', '10', '2019-06-01', '1', '1', '1', '8', '2');
INSERT INTO `goods` VALUES ('3', '电吹风', '10.00', '10', '2019-06-01', '1', '1', null, null, '3');
INSERT INTO `goods` VALUES ('4', '插座', '10.00', '10', '2019-06-01', '1', '1', '1', null, '3');
INSERT INTO `goods` VALUES ('5', '数据分析', '10.00', '10', '2019-06-01', '2', '2', null, '7', '3');
INSERT INTO `goods` VALUES ('6', '函数', '10.00', '10', '2019-06-01', '2', '2', '1', null, '3');
INSERT INTO `goods` VALUES ('7', '新概念英语', '10.00', '10', '2019-06-01', '2', '2', null, null, '3');
INSERT INTO `goods` VALUES ('8', '字帖', '10.00', '10', '2019-06-01', '2', '2', null, null, '3');
INSERT INTO `goods` VALUES ('9', '芦荟胶', '10.00', '10', '2019-06-01', '2', '2', null, null, '1');
INSERT INTO `goods` VALUES ('10', '保时达电吹风', '10.00', '10', '2019-06-01', '3', '3', null, null, '1');
INSERT INTO `goods` VALUES ('11', '笔记本电脑', '10.00', '10', '2019-06-01', '3', '3', null, null, '1');
INSERT INTO `goods` VALUES ('12', '慕课革命', '10.00', '10', '2019-06-01', '3', '3', null, '9', '1');
INSERT INTO `goods` VALUES ('13', '迷彩服', '10.00', '10', '2019-06-01', '4', '4', null, null, '1');
INSERT INTO `goods` VALUES ('14', '夹头发夹板', '10.00', '10', '2019-06-01', '5', '5', null, null, '1');
INSERT INTO `goods` VALUES ('15', '程序设计', '10.00', '10', '2019-06-01', '5', '5', null, null, '2');
INSERT INTO `goods` VALUES ('16', 'C语言', '10.00', '10', '2019-06-01', '5', '5', null, null, '2');
INSERT INTO `goods` VALUES ('17', '洗衣液', '10.00', '10', '2019-06-01', '6', '6', null, null, '2');
INSERT INTO `goods` VALUES ('18', '魏申志', '10.00', '10', '2019-06-01', '6', '6', null, null, '2');
INSERT INTO `goods` VALUES ('19', '佳洁士牙膏', '10.00', '10', '2019-06-01', '6', '6', null, null, '2');
INSERT INTO `goods` VALUES ('20', '衣服', '10.00', '10', '2019-06-01', '7', '7', null, null, '2');
INSERT INTO `goods` VALUES ('21', '吉他', '10.00', '10', '2019-06-01', '7', '7', null, null, '4');
INSERT INTO `goods` VALUES ('22', '蚊帐', '10.00', '10', '2019-06-01', '7', '7', null, null, '4');
INSERT INTO `goods` VALUES ('23', '化妆品', '10.00', '10', '2019-06-01', '8', '8', null, null, '4');
INSERT INTO `goods` VALUES ('24', '折叠凳', '10.00', '10', '2019-06-01', '8', '8', null, null, '4');
INSERT INTO `goods` VALUES ('25', '旧书', '10.00', '10', '2019-06-01', '8', '8', null, null, '4');
INSERT INTO `goods` VALUES ('26', '网球拍', '10.00', '10', '2019-06-01', '9', '9', null, null, '4');
INSERT INTO `goods` VALUES ('27', '音响', '10.00', '10', '2019-06-01', '9', '9', null, null, '4');
INSERT INTO `goods` VALUES ('28', '旧手机', '10.00', '10', '2019-06-01', '10', '10', null, null, '4');
INSERT INTO `goods` VALUES ('29', '不知道', '10.00', '10', '2019-06-01', '10', '10', null, null, '5');
INSERT INTO `goods` VALUES ('30', '榨汁机', '10.00', '10', '2019-06-01', '10', '10', null, null, '5');
INSERT INTO `goods` VALUES ('31', '手机环扣', '10.00', '10', '2019-06-01', '10', '10', null, '1', '5');
INSERT INTO `goods` VALUES ('32', '太阳帽', '10.00', '10', '2019-06-01', '10', '10', null, '2', '5');
INSERT INTO `goods` VALUES ('33', '发夹', '10.00', '10', '2019-06-01', '11', '11', null, null, '5');
INSERT INTO `goods` VALUES ('34', '沐浴乳', '10.00', '10', '2019-06-01', '12', '12', null, null, '5');
INSERT INTO `goods` VALUES ('35', 'wifi增强器', '10.00', '10', '2019-06-01', '13', '13', null, null, '5');
INSERT INTO `goods` VALUES ('36', '电风扇', '10.00', '10', '2019-06-01', '13', '13', null, null, '5');
INSERT INTO `goods` VALUES ('37', '吊灯', '10.00', '10', '2019-06-01', '13', '13', null, null, '5');
INSERT INTO `goods` VALUES ('38', '计算器', '10.00', '10', '2019-06-01', '13', '13', null, null, '5');
INSERT INTO `goods` VALUES ('39', '《异类》', '10.00', '10', '2019-06-01', '14', '14', null, '3', '5');
INSERT INTO `goods` VALUES ('40', '《马化腾传奇》', '10.00', '10', '2019-06-01', '14', '14', null, null, '1');
INSERT INTO `goods` VALUES ('41', '《QQ帮主》', '10.00', '10', '2019-06-01', '14', '14', null, '6', '1');
INSERT INTO `goods` VALUES ('42', '电灯', '10.00', '10', '2019-06-01', '14', '14', null, null, '1');
INSERT INTO `goods` VALUES ('43', null, '10.00', '10', '2019-06-01', '15', '15', null, '4', '1');
INSERT INTO `goods` VALUES ('44', null, '10.00', '10', '2019-06-01', '15', '15', null, null, '1');
INSERT INTO `goods` VALUES ('45', null, '10.00', '10', '2019-06-01', '15', '15', null, null, '1');
INSERT INTO `goods` VALUES ('46', null, '10.00', '10', '2019-06-01', '16', '16', null, '5', '1');
INSERT INTO `goods` VALUES ('47', null, '10.00', '10', '2019-06-01', '16', '16', null, null, '1');



/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:32:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for img
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_url` varchar(255) DEFAULT NULL,
  `goods_img_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`img_id`),
  KEY `FKgoji7hxqn3qadnie6f4bgevfx` (`goods_img_id`),
  CONSTRAINT `FKgoji7hxqn3qadnie6f4bgevfx` FOREIGN KEY (`goods_img_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `img_ibfk_1` FOREIGN KEY (`goods_img_id`) REFERENCES `goods` (`goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('1', '1556432693000.jpg', '1');
INSERT INTO `img` VALUES ('2', '1556432704789.jpg', '1');
INSERT INTO `img` VALUES ('3', '1556432730499.jpg', '2');
INSERT INTO `img` VALUES ('4', '1556592239062.jpg', '2');
INSERT INTO `img` VALUES ('5', '1556592263250.jpg', '3');
INSERT INTO `img` VALUES ('6', '1556592277625.jpg', '4');
INSERT INTO `img` VALUES ('7', '5695e428da2fe.jpg', '5');
INSERT INTO `img` VALUES ('8', '5695e428ecc7d.jpg', '6');
INSERT INTO `img` VALUES ('9', '5695e42905c03.jpg', '7');
INSERT INTO `img` VALUES ('10', '5695e4291c659.jpg', '7');
INSERT INTO `img` VALUES ('11', '56ea1d14d9cae.jpg', '8');
INSERT INTO `img` VALUES ('12', '56eac74369424.jpg', '9');
INSERT INTO `img` VALUES ('13', '56ee3f996b11a.jpg', '10');
INSERT INTO `img` VALUES ('14', '56ee3f9a031e5.jpg', '11');
INSERT INTO `img` VALUES ('15', '574476d2530d3.jpg', '12');
INSERT INTO `img` VALUES ('16', '57514635c583f.jpg', '13');
INSERT INTO `img` VALUES ('17', '57514635f2d0a.jpg', '14');
INSERT INTO `img` VALUES ('18', '5752d76b76d65.jpg', '14');
INSERT INTO `img` VALUES ('19', '5753e19e3a847.jpg', '15');
INSERT INTO `img` VALUES ('20', '5753e19e64b7b.jpg', '15');
INSERT INTO `img` VALUES ('21', '5755a3789c6f5.jpg', '16');
INSERT INTO `img` VALUES ('22', '5757ae47ac2bb.jpg', '17');
INSERT INTO `img` VALUES ('23', '5757ae47cbe15.jpg', '18');
INSERT INTO `img` VALUES ('24', '5758ca2d9e9a8.jpg', '19');
INSERT INTO `img` VALUES ('25', '5759875608e07.jpg', '19');
INSERT INTO `img` VALUES ('26', '575c20ac751e6.jpg', '20');
INSERT INTO `img` VALUES ('27', '5760fd38a3910.jpg', '21');
INSERT INTO `img` VALUES ('28', '57611512dcc97.jpg', '22');
INSERT INTO `img` VALUES ('29', '5761300131202.jpg', '21');
INSERT INTO `img` VALUES ('30', '576130013c91d.jpg', '19');
INSERT INTO `img` VALUES ('31', '5765691417f64.jpg', '23');
INSERT INTO `img` VALUES ('32', '57656b1c503a9.jpg', '23');
INSERT INTO `img` VALUES ('33', '57656b1d3600b.jpg', '24');
INSERT INTO `img` VALUES ('34', '5766c343f16c3.jpg', '25');
INSERT INTO `img` VALUES ('35', '5767c1e8466e4.jpg', '26');
INSERT INTO `img` VALUES ('36', '5769f16f1b09e.jpg', '27');
INSERT INTO `img` VALUES ('37', '5769f16f4b700.jpg', '28');
INSERT INTO `img` VALUES ('38', '5769f179a6c07.jpg', '29');
INSERT INTO `img` VALUES ('39', '576f427683b44.jpg', '30');
INSERT INTO `img` VALUES ('40', '576fb37b97042.jpg', '31');
INSERT INTO `img` VALUES ('41', '576fb37c2da29.jpg', '32');
INSERT INTO `img` VALUES ('42', '57762813cec22.jpg', '33');
INSERT INTO `img` VALUES ('43', '5781d54de3bd4.jpg', '34');
INSERT INTO `img` VALUES ('44', '5781d54e56d57.jpg', '34');
INSERT INTO `img` VALUES ('45', '57bffecf3a317.jpg', '35');
INSERT INTO `img` VALUES ('46', '57bffee5d65b7.jpg', '35');
INSERT INTO `img` VALUES ('47', '58206dc1d827f.jpg', '35');
INSERT INTO `img` VALUES ('48', '58206dcd43620.jpg', '36');
INSERT INTO `img` VALUES ('49', '5821b6e474f95.jpg', '36');
INSERT INTO `img` VALUES ('50', '5821b6f143620.jpg', '37');
INSERT INTO `img` VALUES ('51', '5821b72161e68.jpg', '37');
INSERT INTO `img` VALUES ('52', '582271a9ae31c.jpg', '38');
INSERT INTO `img` VALUES ('53', '582271b49b1ef.jpg', '39');
INSERT INTO `img` VALUES ('54', '58f2241b4cf43.jpg', '39');
INSERT INTO `img` VALUES ('55', '58f9cf190f666.jpg', '40');
INSERT INTO `img` VALUES ('56', '58f9cf1925189.jpg', '40');
INSERT INTO `img` VALUES ('57', '5a8e309905b36.jpg', '41');
INSERT INTO `img` VALUES ('58', '5a8e309915830.jpg', '42');
INSERT INTO `img` VALUES ('59', '5afd9cda48109.jpeg', '43');
INSERT INTO `img` VALUES ('60', '5afd9cda56f12.jpeg', '44');
INSERT INTO `img` VALUES ('61', '5b2a3da6ccb5c.jpg', '45');
INSERT INTO `img` VALUES ('62', '5b60054285076.jpg', '45');
INSERT INTO `img` VALUES ('63', '5c258aeab1df3 (1).JPG', '45');
INSERT INTO `img` VALUES ('64', '5c258aeab1df3.JPG', '46');
INSERT INTO `img` VALUES ('65', '5c9da14e65db9.jpg', '46');
INSERT INTO `img` VALUES ('66', '5c9da14ec7a2c.jpg', '47');



/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:32:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_modified_time` date DEFAULT NULL,
  `order_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKi23mkwp5i5pg93kmdgrxdj0vd` (`order_user_id`),
  CONSTRAINT `FKi23mkwp5i5pg93kmdgrxdj0vd` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `order_detail_ibfk_1` FOREIGN KEY (`order_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES ('1', '2020-03-12', '1');
INSERT INTO `order_detail` VALUES ('2', '2020-03-12', '2');
INSERT INTO `order_detail` VALUES ('3', '2020-03-12', '13');
INSERT INTO `order_detail` VALUES ('4', '2020-03-12', '14');
INSERT INTO `order_detail` VALUES ('5', '2020-03-12', '16');
INSERT INTO `order_detail` VALUES ('6', '2020-03-12', '11');
INSERT INTO `order_detail` VALUES ('7', '2020-03-12', '13');
INSERT INTO `order_detail` VALUES ('8', '2020-03-12', '15');
INSERT INTO `order_detail` VALUES ('9', '2020-03-12', '16');



/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:33:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for payment_records
-- ----------------------------
DROP TABLE IF EXISTS `payment_records`;
CREATE TABLE `payment_records` (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT,
  `pay_sell_id` int(11) DEFAULT NULL,
  `pay_sell_name` varchar(255) DEFAULT NULL,
  `pay_buy_id` int(11) DEFAULT NULL,
  `pay_buy_name` varchar(255) DEFAULT NULL,
  `pay_goods_id` int(11) DEFAULT NULL,
  `pay_goods_name` varchar(255) DEFAULT NULL,
  `pay_price` decimal(19,2) DEFAULT NULL,
  `pay_records_time` date DEFAULT NULL,
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment_records
-- ----------------------------


/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:33:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for produce_category
-- ----------------------------
DROP TABLE IF EXISTS `produce_category`;
CREATE TABLE `produce_category` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of produce_category
-- ----------------------------
INSERT INTO `produce_category` VALUES ('1', '书籍文具');
INSERT INTO `produce_category` VALUES ('2', '鞋服配饰');
INSERT INTO `produce_category` VALUES ('3', '电器用品');
INSERT INTO `produce_category` VALUES ('4', '运动音乐');
INSERT INTO `produce_category` VALUES ('5', '其它');



/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : camshopmall

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-03-16 10:33:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for produce_comment
-- ----------------------------
DROP TABLE IF EXISTS `produce_comment`;
CREATE TABLE `produce_comment` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_audit_time` date DEFAULT NULL,
  `com_content` varchar(255) DEFAULT NULL,
  `com_goods_id` int(11) DEFAULT NULL,
  `com_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  KEY `FKmtlrfa0pmg5vldln5rjysiv01` (`com_goods_id`),
  KEY `FKn4y33qq9ffnws3bcyddyfaxaj` (`com_user_id`),
  CONSTRAINT `FKmtlrfa0pmg5vldln5rjysiv01` FOREIGN KEY (`com_goods_id`) REFERENCES `goods` (`goods_id`),
  CONSTRAINT `FKn4y33qq9ffnws3bcyddyfaxaj` FOREIGN KEY (`com_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of produce_comment
-- ----------------------------



