/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : dataentry

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 13/03/2019 16:55:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_product
-- ----------------------------
DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `pid_id` bigint(20) DEFAULT NULL,
  `oid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnab7bcm4hbpogf0ilf0ndafys` (`pid_id`),
  KEY `FK2p6c2omu0wo1j71k5aynxscti` (`oid`)
) ENGINE=MyISAM AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product
-- ----------------------------
BEGIN;
INSERT INTO `order_product` VALUES (8, b'0', 1, 1, 5);
INSERT INTO `order_product` VALUES (9, b'0', 1, 10, 5);
INSERT INTO `order_product` VALUES (10, b'0', 2, 5, 6);
INSERT INTO `order_product` VALUES (11, b'0', 1, 2, 7);
INSERT INTO `order_product` VALUES (12, b'0', 1, 8, 7);
INSERT INTO `order_product` VALUES (13, b'0', 2, 9, 8);
INSERT INTO `order_product` VALUES (14, b'0', 1, 4, 9);
INSERT INTO `order_product` VALUES (15, b'0', 1, 6, 10);
INSERT INTO `order_product` VALUES (16, b'0', 1, 2, 11);
INSERT INTO `order_product` VALUES (17, b'0', 1, 1, 11);
INSERT INTO `order_product` VALUES (18, b'0', 1, 4, 12);
INSERT INTO `order_product` VALUES (19, b'0', 1, 4, 13);
INSERT INTO `order_product` VALUES (20, b'0', 2, 4, 14);
INSERT INTO `order_product` VALUES (21, b'0', 1, 6, 15);
INSERT INTO `order_product` VALUES (22, b'0', 1, 2, 16);
INSERT INTO `order_product` VALUES (23, b'0', 1, 1, 16);
INSERT INTO `order_product` VALUES (24, b'0', 1, 2, 17);
INSERT INTO `order_product` VALUES (29, b'0', 1, 4, 22);
INSERT INTO `order_product` VALUES (28, b'0', 1, 4, 21);
INSERT INTO `order_product` VALUES (27, b'0', 1, 7, 20);
INSERT INTO `order_product` VALUES (30, b'0', 1, 10, 23);
INSERT INTO `order_product` VALUES (31, b'0', 1, 4, 24);
INSERT INTO `order_product` VALUES (33, b'0', 1, 2, 26);
INSERT INTO `order_product` VALUES (32, b'0', 1, 4, 25);
INSERT INTO `order_product` VALUES (34, b'0', 1, 8, 26);
INSERT INTO `order_product` VALUES (35, b'0', 2, 2, 27);
INSERT INTO `order_product` VALUES (36, b'0', 2, 8, 28);
INSERT INTO `order_product` VALUES (37, b'0', 4, 1, 29);
INSERT INTO `order_product` VALUES (38, b'0', 1, 4, 30);
INSERT INTO `order_product` VALUES (39, b'0', 2, 4, 31);
INSERT INTO `order_product` VALUES (40, b'0', 2, 8, 32);
INSERT INTO `order_product` VALUES (41, b'0', 1, 4, 33);
INSERT INTO `order_product` VALUES (42, b'0', 1, 4, 34);
INSERT INTO `order_product` VALUES (43, b'0', 1, 5, 35);
INSERT INTO `order_product` VALUES (44, b'0', 2, 10, 36);
INSERT INTO `order_product` VALUES (45, b'0', 1, 6, 37);
INSERT INTO `order_product` VALUES (46, b'0', 1, 2, 37);
INSERT INTO `order_product` VALUES (47, b'0', 1, 11, 37);
INSERT INTO `order_product` VALUES (48, b'0', 1, 4, 38);
INSERT INTO `order_product` VALUES (49, b'0', 2, 1, 39);
INSERT INTO `order_product` VALUES (50, b'0', 1, 1, 40);
INSERT INTO `order_product` VALUES (51, b'0', 1, 11, 40);
INSERT INTO `order_product` VALUES (52, b'0', 1, 10, 40);
INSERT INTO `order_product` VALUES (53, b'0', 1, 10, 41);
INSERT INTO `order_product` VALUES (54, b'0', 1, 4, 42);
INSERT INTO `order_product` VALUES (55, b'0', 1, 2, 43);
INSERT INTO `order_product` VALUES (56, b'0', 1, 8, 43);
INSERT INTO `order_product` VALUES (57, b'0', 2, 2, 44);
INSERT INTO `order_product` VALUES (58, b'0', 2, 8, 45);
INSERT INTO `order_product` VALUES (59, b'0', 1, 11, 45);
INSERT INTO `order_product` VALUES (60, b'0', 1, 2, 45);
INSERT INTO `order_product` VALUES (61, b'0', 1, 6, 46);
INSERT INTO `order_product` VALUES (62, b'0', 2, 7, 47);
INSERT INTO `order_product` VALUES (63, b'0', 2, 8, 47);
INSERT INTO `order_product` VALUES (64, b'0', 2, 1, 48);
INSERT INTO `order_product` VALUES (65, b'0', 1, 2, 48);
INSERT INTO `order_product` VALUES (66, b'0', 2, 7, 49);
INSERT INTO `order_product` VALUES (67, b'0', 1, 4, 50);
INSERT INTO `order_product` VALUES (68, b'0', 1, 5, 50);
INSERT INTO `order_product` VALUES (69, b'0', 1, 10, 50);
INSERT INTO `order_product` VALUES (70, b'0', 1, 4, 51);
INSERT INTO `order_product` VALUES (71, b'0', 2, 1, 52);
INSERT INTO `order_product` VALUES (72, b'0', 1, 9, 53);
INSERT INTO `order_product` VALUES (73, b'0', 1, 8, 53);
INSERT INTO `order_product` VALUES (74, b'0', 1, 1, 54);
INSERT INTO `order_product` VALUES (75, b'0', 1, 2, 54);
INSERT INTO `order_product` VALUES (76, b'0', 2, 2, 55);
INSERT INTO `order_product` VALUES (77, b'0', 1, 2, 56);
INSERT INTO `order_product` VALUES (78, b'0', 1, 8, 56);
INSERT INTO `order_product` VALUES (79, b'0', 2, 2, 57);
INSERT INTO `order_product` VALUES (80, b'0', 1, 11, 58);
INSERT INTO `order_product` VALUES (81, b'0', 1, 6, 59);
INSERT INTO `order_product` VALUES (82, b'0', 2, 4, 60);
INSERT INTO `order_product` VALUES (83, b'0', 1, 2, 61);
INSERT INTO `order_product` VALUES (84, b'0', 1, 10, 61);
INSERT INTO `order_product` VALUES (85, b'0', 1, 8, 61);
INSERT INTO `order_product` VALUES (86, b'0', 1, 1, 61);
INSERT INTO `order_product` VALUES (87, b'0', 1, 11, 62);
INSERT INTO `order_product` VALUES (88, b'0', 1, 1, 62);
INSERT INTO `order_product` VALUES (89, b'0', 1, 8, 63);
INSERT INTO `order_product` VALUES (90, b'0', 1, 4, 64);
INSERT INTO `order_product` VALUES (91, b'0', 1, 9, 65);
INSERT INTO `order_product` VALUES (92, b'0', 1, 4, 66);
INSERT INTO `order_product` VALUES (93, b'0', 1, 6, 67);
INSERT INTO `order_product` VALUES (94, b'0', 1, 4, 68);
INSERT INTO `order_product` VALUES (95, b'0', 1, 2, 69);
INSERT INTO `order_product` VALUES (96, b'0', 2, 4, 70);
INSERT INTO `order_product` VALUES (97, b'0', 2, 4, 71);
INSERT INTO `order_product` VALUES (98, b'0', 1, 2, 72);
INSERT INTO `order_product` VALUES (99, b'0', 1, 8, 72);
INSERT INTO `order_product` VALUES (100, b'0', 2, 7, 73);
INSERT INTO `order_product` VALUES (101, b'0', 2, 4, 73);
INSERT INTO `order_product` VALUES (102, b'0', 2, 4, 74);
INSERT INTO `order_product` VALUES (103, b'0', 1, 10, 75);
INSERT INTO `order_product` VALUES (104, b'0', 1, 4, 76);
INSERT INTO `order_product` VALUES (105, b'0', 1, 1, 77);
INSERT INTO `order_product` VALUES (106, b'0', 1, 8, 77);
INSERT INTO `order_product` VALUES (107, b'0', 2, 4, 78);
INSERT INTO `order_product` VALUES (108, b'0', 1, 4, 79);
INSERT INTO `order_product` VALUES (109, b'0', 2, 8, 80);
INSERT INTO `order_product` VALUES (110, b'0', 1, 6, 81);
INSERT INTO `order_product` VALUES (111, b'0', 1, 4, 82);
INSERT INTO `order_product` VALUES (112, b'0', 2, 9, 83);
INSERT INTO `order_product` VALUES (113, b'0', 1, 2, 83);
INSERT INTO `order_product` VALUES (114, b'0', 1, 4, 84);
INSERT INTO `order_product` VALUES (115, b'0', 1, 11, 85);
INSERT INTO `order_product` VALUES (116, b'0', 1, 2, 85);
INSERT INTO `order_product` VALUES (117, b'0', 1, 5, 85);
INSERT INTO `order_product` VALUES (118, b'0', 1, 8, 85);
INSERT INTO `order_product` VALUES (119, b'0', 1, 10, 85);
INSERT INTO `order_product` VALUES (120, b'0', 2, 2, 86);
INSERT INTO `order_product` VALUES (121, b'0', 2, 1, 87);
INSERT INTO `order_product` VALUES (122, b'0', 1, 2, 88);
INSERT INTO `order_product` VALUES (123, b'0', 2, 7, 89);
INSERT INTO `order_product` VALUES (124, b'0', 1, 6, 90);
INSERT INTO `order_product` VALUES (125, b'0', 2, 10, 91);
INSERT INTO `order_product` VALUES (126, b'0', 2, 4, 92);
INSERT INTO `order_product` VALUES (127, b'0', 1, 2, 93);
INSERT INTO `order_product` VALUES (128, b'0', 1, 8, 93);
INSERT INTO `order_product` VALUES (129, b'0', 1, 6, 94);
INSERT INTO `order_product` VALUES (130, b'0', 1, 2, 95);
INSERT INTO `order_product` VALUES (131, b'0', 2, 1, 96);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) NOT NULL,
  `create_at` date DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `update_at` date DEFAULT NULL,
  `award` double DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc15qx7vbdrtto776d5o8vumx1` (`person_id`)
) ENGINE=MyISAM AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (5, b'0', '2019-03-01', NULL, NULL, 71, 6, 0);
INSERT INTO `t_order` VALUES (6, b'0', '2019-03-01', NULL, NULL, 10, 7, 0);
INSERT INTO `t_order` VALUES (7, b'0', '2019-03-01', NULL, NULL, 71, 8, 0);
INSERT INTO `t_order` VALUES (8, b'0', '2019-03-02', NULL, NULL, 26, 9, 0);
INSERT INTO `t_order` VALUES (9, b'0', '2019-03-02', NULL, NULL, 10, 10, 0);
INSERT INTO `t_order` VALUES (10, b'0', '2019-03-02', NULL, NULL, 80, 11, 0);
INSERT INTO `t_order` VALUES (11, b'0', '2019-03-02', NULL, NULL, 130, 12, 0);
INSERT INTO `t_order` VALUES (12, b'0', '2019-03-02', NULL, NULL, 10, 13, 0);
INSERT INTO `t_order` VALUES (13, b'0', '2019-03-02', NULL, NULL, 10, 14, 0);
INSERT INTO `t_order` VALUES (14, b'0', '2019-03-02', NULL, NULL, 20, 15, 0);
INSERT INTO `t_order` VALUES (15, b'0', '2019-03-02', NULL, NULL, 80, 16, 0);
INSERT INTO `t_order` VALUES (16, b'0', '2019-03-02', NULL, NULL, 130, 17, 0);
INSERT INTO `t_order` VALUES (17, b'0', '2019-03-02', NULL, NULL, 65, 11, 0);
INSERT INTO `t_order` VALUES (22, b'0', '2019-03-03', NULL, NULL, 10, 20, 0);
INSERT INTO `t_order` VALUES (21, b'0', '2019-03-03', NULL, NULL, 10, 19, 0);
INSERT INTO `t_order` VALUES (20, b'0', '2019-03-03', NULL, NULL, 12, 18, 0);
INSERT INTO `t_order` VALUES (23, b'0', '2019-03-03', NULL, NULL, 6, 21, 0);
INSERT INTO `t_order` VALUES (24, b'0', '2019-03-03', NULL, NULL, 10, 22, 0);
INSERT INTO `t_order` VALUES (25, b'0', '2019-03-03', NULL, NULL, 10, 23, 0);
INSERT INTO `t_order` VALUES (26, b'0', '2019-03-03', NULL, NULL, 71, 11, 0);
INSERT INTO `t_order` VALUES (27, b'0', '2019-03-03', NULL, NULL, 130, 11, 0);
INSERT INTO `t_order` VALUES (28, b'0', '2019-03-03', NULL, NULL, 12, 11, 0);
INSERT INTO `t_order` VALUES (29, b'0', '2019-03-03', NULL, NULL, 260, 11, 0);
INSERT INTO `t_order` VALUES (30, b'0', '2019-03-04', NULL, NULL, 10, 24, 0);
INSERT INTO `t_order` VALUES (31, b'0', '2019-03-04', NULL, NULL, 20, 25, 0);
INSERT INTO `t_order` VALUES (32, b'0', '2019-03-04', NULL, NULL, 12, 26, 0);
INSERT INTO `t_order` VALUES (33, b'0', '2019-03-04', NULL, NULL, 10, 12, 0);
INSERT INTO `t_order` VALUES (34, b'0', '2019-03-04', NULL, NULL, 10, 27, 0);
INSERT INTO `t_order` VALUES (35, b'0', '2019-03-04', NULL, NULL, 5, 28, 0);
INSERT INTO `t_order` VALUES (36, b'0', '2019-03-04', NULL, NULL, 12, 29, 0);
INSERT INTO `t_order` VALUES (37, b'0', '2019-03-04', NULL, NULL, 163, 11, 0);
INSERT INTO `t_order` VALUES (38, b'0', '2019-03-05', NULL, NULL, 10, 30, 0);
INSERT INTO `t_order` VALUES (39, b'0', '2019-03-05', NULL, NULL, 130, 31, 0);
INSERT INTO `t_order` VALUES (40, b'0', '2019-03-05', NULL, NULL, 89, 3, 0);
INSERT INTO `t_order` VALUES (41, b'0', '2019-03-05', NULL, NULL, 6, 1, 0);
INSERT INTO `t_order` VALUES (42, b'0', '2019-03-05', NULL, NULL, 10, 2, 0);
INSERT INTO `t_order` VALUES (43, b'0', '2019-03-05', NULL, NULL, 71, 7, 0);
INSERT INTO `t_order` VALUES (44, b'0', '2019-03-05', NULL, NULL, 130, 32, 0);
INSERT INTO `t_order` VALUES (45, b'0', '2019-03-05', NULL, NULL, 95, 6, 0);
INSERT INTO `t_order` VALUES (46, b'0', '2019-03-05', NULL, NULL, 80, 33, 0);
INSERT INTO `t_order` VALUES (47, b'0', '2019-03-05', NULL, NULL, 36, 8, 0);
INSERT INTO `t_order` VALUES (48, b'0', '2019-03-06', NULL, NULL, 195, 34, 0);
INSERT INTO `t_order` VALUES (49, b'0', '2019-03-06', NULL, NULL, 24, 35, 0);
INSERT INTO `t_order` VALUES (50, b'0', '2019-03-06', NULL, NULL, 21, 36, 0);
INSERT INTO `t_order` VALUES (51, b'0', '2019-03-06', NULL, NULL, 10, 37, 0);
INSERT INTO `t_order` VALUES (52, b'0', '2019-03-07', NULL, NULL, 130, 38, 0);
INSERT INTO `t_order` VALUES (53, b'0', '2019-03-07', NULL, NULL, 19, 39, 0);
INSERT INTO `t_order` VALUES (54, b'0', '2019-03-07', NULL, NULL, 130, 6, 0);
INSERT INTO `t_order` VALUES (55, b'0', '2019-03-08', NULL, NULL, 130, 40, 0);
INSERT INTO `t_order` VALUES (56, b'0', '2019-03-08', NULL, NULL, 71, 6, 0);
INSERT INTO `t_order` VALUES (57, b'0', '2019-03-08', NULL, NULL, 130, 41, 0);
INSERT INTO `t_order` VALUES (58, b'0', '2019-03-08', NULL, NULL, 18, 33, 0);
INSERT INTO `t_order` VALUES (59, b'0', '2019-03-09', NULL, NULL, 80, 42, 0);
INSERT INTO `t_order` VALUES (60, b'0', '2019-03-09', NULL, NULL, 20, 43, 0);
INSERT INTO `t_order` VALUES (61, b'0', '2019-03-09', NULL, NULL, 142, 11, 0);
INSERT INTO `t_order` VALUES (62, b'0', '2019-03-09', NULL, NULL, 83, 7, 0);
INSERT INTO `t_order` VALUES (63, b'0', '2019-03-09', NULL, NULL, 6, 34, 0);
INSERT INTO `t_order` VALUES (64, b'0', '2019-03-09', NULL, NULL, 10, 44, 0);
INSERT INTO `t_order` VALUES (65, b'0', '2019-03-09', NULL, NULL, 13, 45, 0);
INSERT INTO `t_order` VALUES (66, b'0', '2019-03-10', NULL, NULL, 10, 29, 0);
INSERT INTO `t_order` VALUES (67, b'0', '2019-03-10', NULL, NULL, 80, 22, 0);
INSERT INTO `t_order` VALUES (68, b'0', '2019-03-10', NULL, NULL, 10, 46, 0);
INSERT INTO `t_order` VALUES (69, b'0', '2019-03-10', NULL, NULL, 65, 47, 0);
INSERT INTO `t_order` VALUES (70, b'0', '2019-03-10', NULL, NULL, 20, 48, 0);
INSERT INTO `t_order` VALUES (71, b'0', '2019-03-10', NULL, NULL, 20, 49, 0);
INSERT INTO `t_order` VALUES (72, b'0', '2019-03-10', NULL, NULL, 71, 50, 0);
INSERT INTO `t_order` VALUES (73, b'0', '2019-03-10', NULL, NULL, 44, 45, 0);
INSERT INTO `t_order` VALUES (74, b'0', '2019-03-10', NULL, NULL, 20, 51, 0);
INSERT INTO `t_order` VALUES (75, b'0', '2019-03-10', NULL, NULL, 6, 52, 0);
INSERT INTO `t_order` VALUES (76, b'0', '2019-03-10', NULL, NULL, 10, 53, 0);
INSERT INTO `t_order` VALUES (77, b'0', '2019-03-10', NULL, NULL, 71, 43, 0);
INSERT INTO `t_order` VALUES (78, b'0', '2019-03-10', NULL, NULL, 20, 54, 0);
INSERT INTO `t_order` VALUES (79, b'0', '2019-03-10', NULL, NULL, 10, 37, 0);
INSERT INTO `t_order` VALUES (80, b'0', '2019-03-10', NULL, NULL, 12, 34, 0);
INSERT INTO `t_order` VALUES (81, b'0', '2019-03-11', NULL, NULL, 80, 27, 0);
INSERT INTO `t_order` VALUES (82, b'0', '2019-03-11', NULL, NULL, 10, 48, 0);
INSERT INTO `t_order` VALUES (83, b'0', '2019-03-11', NULL, NULL, 91, 55, 0);
INSERT INTO `t_order` VALUES (84, b'0', '2019-03-11', NULL, NULL, 10, 41, 0);
INSERT INTO `t_order` VALUES (85, b'0', '2019-03-11', NULL, NULL, 100, 56, 0);
INSERT INTO `t_order` VALUES (86, b'0', '2019-03-11', NULL, NULL, 130, 42, 0);
INSERT INTO `t_order` VALUES (87, b'0', '2019-03-11', NULL, NULL, 130, 6, 0);
INSERT INTO `t_order` VALUES (88, b'0', '2019-03-11', NULL, NULL, 65, 21, 0);
INSERT INTO `t_order` VALUES (89, b'0', '2019-03-11', NULL, NULL, 24, 57, 0);
INSERT INTO `t_order` VALUES (90, b'0', '2019-03-11', NULL, NULL, 80, 49, 0);
INSERT INTO `t_order` VALUES (91, b'0', '2019-03-11', NULL, NULL, 12, 58, 0);
INSERT INTO `t_order` VALUES (92, b'0', '2019-03-11', NULL, NULL, 20, 58, 0);
INSERT INTO `t_order` VALUES (93, b'0', '2019-03-12', NULL, NULL, 71, 31, 0);
INSERT INTO `t_order` VALUES (94, b'0', '2019-03-12', NULL, NULL, 80, 17, 0);
INSERT INTO `t_order` VALUES (95, b'0', '2019-03-12', NULL, NULL, 65, 45, 0);
INSERT INTO `t_order` VALUES (96, b'0', '2019-03-12', NULL, NULL, 130, 45, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deleted` bit(1) NOT NULL,
  `from_area` varchar(255) DEFAULT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person
-- ----------------------------
BEGIN;
INSERT INTO `t_person` VALUES (1, b'0', '萝岗', '许云溪');
INSERT INTO `t_person` VALUES (2, b'0', '江高', '晓红');
INSERT INTO `t_person` VALUES (3, b'0', '萝岗', '陈丽华');
INSERT INTO `t_person` VALUES (6, b'0', '萝岗', '李彩滨');
INSERT INTO `t_person` VALUES (7, b'0', '太和', '范燕媚');
INSERT INTO `t_person` VALUES (8, b'0', '荔红', '吕亚妹');
INSERT INTO `t_person` VALUES (9, b'0', '元岗', '小丽');
INSERT INTO `t_person` VALUES (10, b'0', '东奥', '林少丽');
INSERT INTO `t_person` VALUES (11, b'0', '萝岗', '李秋杏');
INSERT INTO `t_person` VALUES (12, b'0', '元岗', '徐少春');
INSERT INTO `t_person` VALUES (13, b'0', '东区', '钟群英');
INSERT INTO `t_person` VALUES (14, b'0', '联和', '刘佩思');
INSERT INTO `t_person` VALUES (15, b'0', '江高', '江文意');
INSERT INTO `t_person` VALUES (16, b'0', '荔红', '陈丽华');
INSERT INTO `t_person` VALUES (17, b'0', '长兴', '尤玉容');
INSERT INTO `t_person` VALUES (18, b'0', '赵溪', '麦丽娇');
INSERT INTO `t_person` VALUES (19, b'0', '联和', '许伟仙');
INSERT INTO `t_person` VALUES (20, b'0', '元岗', '陈珍琴');
INSERT INTO `t_person` VALUES (21, b'0', '太和', '何翠玲');
INSERT INTO `t_person` VALUES (22, b'0', '联和', '姚采韵');
INSERT INTO `t_person` VALUES (23, b'0', '太和', '温誉');
INSERT INTO `t_person` VALUES (24, b'0', '九佛中', '石润银');
INSERT INTO `t_person` VALUES (25, b'0', '九佛中', '林庆风');
INSERT INTO `t_person` VALUES (26, b'0', '太和', '何翠玲');
INSERT INTO `t_person` VALUES (27, b'0', '东区', '卓雪杏');
INSERT INTO `t_person` VALUES (28, b'0', '镇龙', '汤彩兰');
INSERT INTO `t_person` VALUES (29, b'0', '赵溪', '李若楠');
INSERT INTO `t_person` VALUES (30, b'0', '镇龙', '张芷双');
INSERT INTO `t_person` VALUES (31, b'0', '萝岗', '姚燕玲');
INSERT INTO `t_person` VALUES (32, b'0', '东区', '张双文');
INSERT INTO `t_person` VALUES (33, b'0', '元岗', '谢婉霞');
INSERT INTO `t_person` VALUES (34, b'0', '萝岗', '涂亭亭');
INSERT INTO `t_person` VALUES (35, b'0', '太和', '黄倩晨');
INSERT INTO `t_person` VALUES (36, b'0', '镇龙', '陈秀云');
INSERT INTO `t_person` VALUES (37, b'0', '长兴', '梁美华');
INSERT INTO `t_person` VALUES (38, b'0', '长兴', '小尤');
INSERT INTO `t_person` VALUES (39, b'0', '中海', '黄月芳');
INSERT INTO `t_person` VALUES (40, b'0', '镇龙', '潘美婷');
INSERT INTO `t_person` VALUES (41, b'0', '棠溪', '林少香');
INSERT INTO `t_person` VALUES (42, b'0', '荔红', '黄燕辉');
INSERT INTO `t_person` VALUES (43, b'0', '荔红', '廖彩灵');
INSERT INTO `t_person` VALUES (44, b'0', '长兴', '梁敏仪');
INSERT INTO `t_person` VALUES (45, b'0', '荔红', '伟娟');
INSERT INTO `t_person` VALUES (46, b'0', '太和', '谢浩宇');
INSERT INTO `t_person` VALUES (47, b'0', '萝岗', '刘菊秋');
INSERT INTO `t_person` VALUES (48, b'0', '江高', '黄家仪');
INSERT INTO `t_person` VALUES (49, b'0', '荔红', '吴冬玲');
INSERT INTO `t_person` VALUES (50, b'0', '联和', '邹香花');
INSERT INTO `t_person` VALUES (51, b'0', '九佛', '林丽敏');
INSERT INTO `t_person` VALUES (52, b'0', '东区', '林木明');
INSERT INTO `t_person` VALUES (53, b'0', '九佛', '邱建品');
INSERT INTO `t_person` VALUES (54, b'0', '江高', '黄美维');
INSERT INTO `t_person` VALUES (55, b'0', '东区', '雷双华');
INSERT INTO `t_person` VALUES (56, b'0', '九佛', '陈柏巧');
INSERT INTO `t_person` VALUES (57, b'0', '九佛', '陈欣怡');
INSERT INTO `t_person` VALUES (58, b'0', '长兴', '阿兰');
COMMIT;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_at` date DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `update_at` date DEFAULT NULL,
  `award` double DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
BEGIN;
INSERT INTO `t_product` VALUES (1, NULL, NULL, b'0', '2019-03-08', 65, '2019-04-25', '熟三七粉', 650, '2019-02-26');
INSERT INTO `t_product` VALUES (2, NULL, NULL, b'0', '2019-03-08', 65, '2019-04-30', '生三七粉', 688, '2019-03-04');
INSERT INTO `t_product` VALUES (4, '2019-03-11', NULL, b'0', NULL, 10, '2019-04-30', '四物膏', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (5, '2019-03-11', NULL, b'0', NULL, 5, '2019-04-30', '山楂粉', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (6, '2019-03-11', NULL, b'0', NULL, 80, '2019-04-30', '阿胶', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (7, '2019-03-11', NULL, b'0', NULL, 12, '2019-04-30', '灵芝粉', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (8, '2019-03-11', NULL, b'0', NULL, 6, '2019-04-30', '丹参粉', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (9, '2019-03-11', NULL, b'0', NULL, 13, '2019-04-30', '天麻粉', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (10, NULL, NULL, b'0', '2019-03-11', 6, '2019-04-30', '黄芪粉', 100, '2019-03-01');
INSERT INTO `t_product` VALUES (11, NULL, NULL, b'0', '2019-03-12', 18, '2019-04-30', '西洋参粉', 100, '2019-03-01');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
