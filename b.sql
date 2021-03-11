/*
 Navicat Premium Data Transfer

 Source Server         : HLJ
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : b

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 24/12/2019 11:10:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, '123', '123');
INSERT INTO `t_admin` VALUES (2, '456', '456');

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `flag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `top` bit(1) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `views` int(11) NULL DEFAULT NULL,
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES (12, '# 大家好\r\n#### 我是人\r\n。。。', '2019-12-20 17:15:56', '测试中...', '', b'1', b'0', b'0', '你好', '2019-12-22 15:01:11', 79, 6, 130);
INSERT INTO `t_blog` VALUES (13, '      11月8日，由中国信息通信研究院、中国通信标准化协会、中国互联网协会、可信区块链推进计划联合主办，科技行者协办的2019可信区块链峰会将在北京悠唐皇冠假日酒店开幕。\r\n\r\n###### ####~~互联网彻底改变了信息传递的方式，区块链作为构造信任的技术有重要的价值。　　区块链技术被认为是继蒸汽机、电力、互联网之后，下一代颠覆性的核心技术。如果说蒸汽机释放了人类的生产力，电力解决了人类基本的生活需求，互联网彻底改变了信息传递的方式，区块链作为构造信任的技术有重要的价值。~~[百度摘录](http://www.baidu.com \"百度摘录\")\r\n', '2019-12-22 13:33:40', '第二个尝试', '', b'1', b'0', b'0', '加快推动区块链技术和产业创新发展，2019可信区块链峰会在京召开', '2019-12-22 13:41:07', 11, 5, 130);
INSERT INTO `t_blog` VALUES (14, '111\r\n1111111111111111', '2019-12-22 17:10:59', '11111111111111111111', '原创', b'1', b'0', b'0', '打卡1', '2019-12-23 15:58:24', 13, 4, 130);
INSERT INTO `t_blog` VALUES (17, '1', '2019-12-23 01:49:38', '1', '', b'1', b'0', b'0', '学习打卡', '2019-12-23 01:49:38', 1, 4, 132);
INSERT INTO `t_blog` VALUES (19, '再再再测试中Ing', '2019-12-23 09:52:40', '111111111111111', '原创', b'1', b'1', b'1', '2019.12.23', '2019-12-23 09:52:40', 1, 5, 132);
INSERT INTO `t_blog` VALUES (20, '1111111111111', '2019-12-23 09:53:47', '1111111111111111', '', b'1', b'0', b'0', '11111111111', '2019-12-23 09:53:47', 1, 6, 132);
INSERT INTO `t_blog` VALUES (21, '22222222222222', '2019-12-23 09:54:46', '222222222222222222222222', '', b'1', b'0', b'0', '2222222222222', '2019-12-23 09:54:46', 1, 5, 133);
INSERT INTO `t_blog` VALUES (22, '2019-12-23', '2019-12-23 10:00:24', '227', '原创', b'1', b'1', b'1', '大作业检查', '2019-12-23 10:00:24', 7, 6, 133);
INSERT INTO `t_blog` VALUES (23, 'Javaweb', '2019-12-23 10:01:34', 'Javaweb', '原创', b'1', b'0', b'0', 'Javaweb', '2019-12-23 10:01:34', 1, 6, 133);
INSERT INTO `t_blog` VALUES (24, '33333333333333333333333333333333', '2019-12-23 11:35:42', '333333333333333333333333333', '转载', b'1', b'0', b'0', '33333333333333333333333', '2019-12-23 11:35:42', 1, 5, 134);
INSERT INTO `t_blog` VALUES (25, '444444444444444', '2019-12-23 11:40:33', '444444444444444444444444', '', b'1', b'0', b'0', '4444444444444444', '2019-12-23 11:40:33', 2, 5, 130);
INSERT INTO `t_blog` VALUES (27, '555555555555555555555555', '2019-12-23 11:43:14', '5555555555555555555555555555555555', '', b'1', b'0', b'0', '55555555555555555555555555', '2019-12-23 11:43:14', 0, 5, 130);
INSERT INTO `t_blog` VALUES (29, '66666666666', '2019-12-23 15:52:44', '6666666666', '原创', b'1', b'0', b'1', '6666666666', '2019-12-23 15:53:03', 4, 5, 136);

-- ----------------------------
-- Table structure for t_blog_tags
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_tags`;
CREATE TABLE `t_blog_tags`  (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  INDEX `FK5feau0gb4lq47fdb03uboswm8`(`tags_id`) USING BTREE,
  INDEX `FKh4pacwjwofrugxa9hpwaxg6mr`(`blogs_id`) USING BTREE,
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_blog_tags
-- ----------------------------
INSERT INTO `t_blog_tags` VALUES (13, 12);
INSERT INTO `t_blog_tags` VALUES (13, 14);
INSERT INTO `t_blog_tags` VALUES (13, 15);
INSERT INTO `t_blog_tags` VALUES (12, 12);
INSERT INTO `t_blog_tags` VALUES (17, 14);
INSERT INTO `t_blog_tags` VALUES (17, 15);
INSERT INTO `t_blog_tags` VALUES (19, 13);
INSERT INTO `t_blog_tags` VALUES (19, 14);
INSERT INTO `t_blog_tags` VALUES (20, 14);
INSERT INTO `t_blog_tags` VALUES (20, 15);
INSERT INTO `t_blog_tags` VALUES (21, 12);
INSERT INTO `t_blog_tags` VALUES (21, 13);
INSERT INTO `t_blog_tags` VALUES (21, 14);
INSERT INTO `t_blog_tags` VALUES (21, 15);
INSERT INTO `t_blog_tags` VALUES (22, 13);
INSERT INTO `t_blog_tags` VALUES (22, 14);
INSERT INTO `t_blog_tags` VALUES (23, 14);
INSERT INTO `t_blog_tags` VALUES (23, 15);
INSERT INTO `t_blog_tags` VALUES (24, 13);
INSERT INTO `t_blog_tags` VALUES (24, 14);
INSERT INTO `t_blog_tags` VALUES (24, 15);
INSERT INTO `t_blog_tags` VALUES (25, 13);
INSERT INTO `t_blog_tags` VALUES (25, 14);
INSERT INTO `t_blog_tags` VALUES (25, 15);
INSERT INTO `t_blog_tags` VALUES (27, 13);
INSERT INTO `t_blog_tags` VALUES (27, 14);
INSERT INTO `t_blog_tags` VALUES (27, 15);
INSERT INTO `t_blog_tags` VALUES (29, 12);
INSERT INTO `t_blog_tags` VALUES (29, 13);
INSERT INTO `t_blog_tags` VALUES (29, 14);
INSERT INTO `t_blog_tags` VALUES (29, 15);
INSERT INTO `t_blog_tags` VALUES (14, 13);
INSERT INTO `t_blog_tags` VALUES (14, 14);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_comment` bit(1) NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `blog_id` bigint(20) NULL DEFAULT NULL,
  `parent_comment_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKke3uogd04j4jx316m1p51e05u`(`blog_id`) USING BTREE,
  INDEX `FK4jj284r3pb7japogvo6h72q95`(`parent_comment_id`) USING BTREE,
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 81 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (43, b'1', NULL, '好的', '2019-12-20 21:41:30', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (44, b'1', NULL, '请问请问 ', '2019-12-20 21:43:48', NULL, 'play2', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (45, b'1', NULL, 'nihao ', '2019-12-20 22:21:48', NULL, NULL, 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (46, b'1', NULL, 'nihao ', '2019-12-20 22:21:48', NULL, NULL, 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (47, b'1', NULL, '你好', '2019-12-20 22:21:53', NULL, NULL, 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (48, b'1', NULL, '好的', '2019-12-20 22:47:10', NULL, NULL, 12, 46, NULL);
INSERT INTO `t_comment` VALUES (49, b'0', '/images/avatar.png', '你们好啊', '2019-12-20 22:49:26', NULL, 'Lurenjia', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (50, b'1', NULL, 'nihao', '2019-12-20 22:49:53', NULL, 'play2', 12, 44, NULL);
INSERT INTO `t_comment` VALUES (51, b'1', NULL, 'nihao', '2019-12-20 22:50:02', NULL, 'play2', 12, 43, NULL);
INSERT INTO `t_comment` VALUES (52, b'1', NULL, 'nihao', '2019-12-20 22:50:25', NULL, 'play2', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (53, b'1', NULL, 'baobei', '2019-12-20 23:04:49', NULL, 'play2', 12, 50, NULL);
INSERT INTO `t_comment` VALUES (54, b'0', '/images/touristAvatar.png', '。。。', '2019-12-21 13:50:59', NULL, '路人B', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (55, b'0', '/images/userAvatar.png', ',,,', '2019-12-21 13:51:14', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (56, b'0', '/images/userAvatar.png', '?', '2019-12-21 13:54:24', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (57, b'0', '/images/userAvatar.png', '...', '2019-12-21 13:59:37', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (58, b'1', '/images/userAvatar.png', '...', '2019-12-21 14:04:39', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (59, b'0', '/images/touristAvatar.png', '大家好啊', '2019-12-21 14:05:42', NULL, '我是路人C', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (60, b'0', '/images/userAvatar.png', 'nihao ', '2019-12-21 14:05:55', NULL, 'play2', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (61, b'0', '/images/userAvatar.png', 'nihao ', '2019-12-21 14:06:09', NULL, 'play2', 12, 60, NULL);
INSERT INTO `t_comment` VALUES (62, b'0', '/images/userAvatar.png', 'niyehao', '2019-12-21 14:06:14', NULL, 'play2', 12, 58, NULL);
INSERT INTO `t_comment` VALUES (63, b'0', '/images/touristAvatar.png', 'fds', '2019-12-21 23:11:17', NULL, 'play', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (64, b'1', '/images/userAvatar.png', '...', '2019-12-22 12:55:11', NULL, 'PlayNine', 12, NULL, 130);
INSERT INTO `t_comment` VALUES (65, b'0', '/images/touristAvatar.png', 'wer', '2019-12-22 13:07:59', NULL, 'play132', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (66, b'0', '/images/touristAvatar.png', 'wer', '2019-12-22 13:08:01', NULL, 'play132', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (67, b'0', '/images/touristAvatar.png', 'asdfsdf', '2019-12-22 13:11:29', NULL, '123', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (68, b'0', '/images/touristAvatar.png', '234', '2019-12-22 13:15:37', NULL, '234', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (69, b'0', '/images/userAvatar.png', 'asdasdsad', '2019-12-22 13:15:53', NULL, 'play2', 12, NULL, 132);
INSERT INTO `t_comment` VALUES (70, b'1', '/images/userAvatar.png', '大记号', '2019-12-22 15:00:10', NULL, 'PlayNine', 13, NULL, 130);
INSERT INTO `t_comment` VALUES (71, b'0', '/images/touristAvatar.png', 'mark', '2019-12-22 15:08:22', NULL, '路人丙', 13, NULL, NULL);
INSERT INTO `t_comment` VALUES (72, b'0', '/images/touristAvatar.png', 'mark', '2019-12-22 15:09:04', NULL, '路人丁', 13, NULL, NULL);
INSERT INTO `t_comment` VALUES (73, b'0', '/images/touristAvatar.png', '123', '2019-12-22 15:28:25', NULL, 'hlh', 12, NULL, NULL);
INSERT INTO `t_comment` VALUES (74, b'1', '/images/userAvatar.png', '1111111111', '2019-12-22 23:50:10', NULL, 'PlayNine', 14, NULL, 130);
INSERT INTO `t_comment` VALUES (75, b'1', '/images/userAvatar.png', '111111111', '2019-12-23 09:30:01', NULL, 'PlayNine', 12, NULL, 130);
INSERT INTO `t_comment` VALUES (76, b'0', '/images/userAvatar.png', '1111111111111', '2019-12-23 09:30:41', NULL, 'play2', 12, NULL, 132);
INSERT INTO `t_comment` VALUES (77, b'1', '/images/userAvatar.png', '232424', '2019-12-23 11:40:53', NULL, 'PlayNine', 25, NULL, 130);
INSERT INTO `t_comment` VALUES (78, b'0', '/images/touristAvatar.png', '121323', '2019-12-23 15:51:38', NULL, 'wq', 13, NULL, NULL);
INSERT INTO `t_comment` VALUES (79, b'1', '/images/userAvatar.png', '45645', '2019-12-23 15:53:48', NULL, '23', 29, NULL, 136);
INSERT INTO `t_comment` VALUES (80, b'0', '/images/userAvatar.png', '1111111111111111111', '2019-12-24 08:19:05', NULL, 'PlayNine', 22, NULL, 130);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (12, 'PengLiuYi');
INSERT INTO `t_tag` VALUES (13, '互联网');
INSERT INTO `t_tag` VALUES (14, '技术');
INSERT INTO `t_tag` VALUES (15, '日常');

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (4, 'dt');
INSERT INTO `t_type` VALUES (5, '日常交流');
INSERT INTO `t_type` VALUES (6, '技术讨论');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (130, NULL, '782527347@qq.com', 'PlayNine', '123', 'ply', 'Coding', '南昌大学', '666666666666');
INSERT INTO `t_user` VALUES (132, NULL, NULL, 'play2', '123', 'ply2', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (133, NULL, NULL, 'play3', '123', 'ply3', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (134, NULL, 'hljwl520@gmail.com', 'hlj', '123456', 'hlj', '1', '1', '1');
INSERT INTO `t_user` VALUES (135, NULL, NULL, 'mwan', 'wanming', 'mwan', NULL, NULL, NULL);
INSERT INTO `t_user` VALUES (136, NULL, '3434', '23', '123', 'lan', '23432', '2342', '234235');

SET FOREIGN_KEY_CHECKS = 1;
