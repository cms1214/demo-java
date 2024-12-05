/*
 Navicat Premium Dump SQL

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 80400 (8.4.0)
 Source Host           : localhost:3306
 Source Schema         : tang

 Target Server Type    : MySQL
 Target Server Version : 80400 (8.4.0)
 File Encoding         : 65001

 Date: 05/12/2024 10:45:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `pwd` varchar(124) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint NULL DEFAULT 1 COMMENT '0表示女，1表示男',
  `avatar` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
  `secret` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '盐，用于个人敏感信息处理',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '跟新时间',
  `is_deleted` tinyint UNSIGNED NULL DEFAULT 0 COMMENT '删除标记（1:不可用 0:可用）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '张三', 18, NULL, 'zhangsan@qq.com', 1, NULL, NULL, NULL, NULL, 1);
INSERT INTO `user` VALUES (3, '家佳琪', 15, '123456', 'k8qscp98@yahoo.com.cn', 1, NULL, NULL, NULL, NULL, 0);
INSERT INTO `user` VALUES (4, '钟子韬', 66, 'HWic4aC11H', 'zzita@icloud.com', 0, 'uCVecjYGZZ', 'peYdOgFkbx', NULL, NULL, 0);
INSERT INTO `user` VALUES (5, '姜安琪', 27, 'y16xDQT6XJ', 'jianga9@hotmail.com', 1, 'BFp57lnAbw', 'rMQWPUqmMO', NULL, NULL, 0);
INSERT INTO `user` VALUES (6, '向岚', 97, 'igMFZ4i57d', 'xialan@mail.com', 1, '42I2vuCxFl', 'Mrxng7iD9u', NULL, NULL, 0);
INSERT INTO `user` VALUES (7, '唐宇宁', 54, 'RDGMUaacAz', 'yuningtang@gmail.com', 1, '1gel6wuNUC', 'MOSyVkBoPh', NULL, NULL, 0);
INSERT INTO `user` VALUES (8, '谭子异', 29, 'abFUCQdl53', 'ziyi3@mail.com', 1, 'SKUEq0moYq', 'kEIonyE1tL', NULL, NULL, 0);
INSERT INTO `user` VALUES (9, '侯震南', 31, '48pwBWZfQ2', 'zho@icloud.com', 0, '4ZLcXDZ1dH', '70KcrwwbIO', NULL, NULL, 0);
INSERT INTO `user` VALUES (10, '杜秀英', 84, '1KAYg95HHy', 'dux908@outlook.com', 0, 'oZDO9foFzy', 'sWGDgLKqkd', NULL, NULL, 0);
INSERT INTO `user` VALUES (11, '贺云熙', 22, 'WT13y1nuk9', 'heyunxi2@yahoo.com', 0, 'xuj0cQRcBn', 'L6ebY5IEMl', NULL, NULL, 0);
INSERT INTO `user` VALUES (12, '范嘉伦', 18, 'AvdlaoTtYx', 'fjia6@icloud.com', 0, 'YYkB2VIesC', 'I0mHE5hCWU', NULL, NULL, 0);
INSERT INTO `user` VALUES (13, '邹睿', 80, 'sR86obNwS3', 'ruiz@mail.com', 0, 'Uy3PhYOKVR', 'aO8GazR27W', NULL, NULL, 0);
INSERT INTO `user` VALUES (14, '黄致远', 84, 'lH7sNwmZ9t', 'zhiyhuang10@icloud.com', 0, 'piqkUVUrmz', '0fh8MHjoEu', NULL, NULL, 0);
INSERT INTO `user` VALUES (15, '黎璐', 98, 'ujnVSCT1yp', 'luli310@gmail.com', 1, 'gKrSomwi3j', 'rhatHOcroE', NULL, NULL, 0);
INSERT INTO `user` VALUES (16, '黎岚', 34, 'OlwIdLFtHA', 'lal@hotmail.com', 1, '1KUenY2IXr', 'ptI2xKP5iT', NULL, NULL, 0);
INSERT INTO `user` VALUES (17, '赵杰宏', 23, 'nuD2xZxONL', 'zhao1960@icloud.com', 1, '6OYcScMDEy', 'YRhSR38JI4', NULL, NULL, 0);
INSERT INTO `user` VALUES (18, '刘璐', 95, 'bCAJ7bnz2s', 'lliu1114@outlook.com', 0, 'Wsxt05qH4w', 'I6139BCTLq', NULL, NULL, 0);
INSERT INTO `user` VALUES (19, '史致远', 18, 'xaYkCXMzN7', 'shzhiy827@hotmail.com', 0, 'SedeswaGVB', 'PXdSy77Llb', NULL, NULL, 0);
INSERT INTO `user` VALUES (20, '赵晓明', 39, 'KfDsBTJMXL', 'xiaoming5@gmail.com', 0, 'EBpJwgHkeW', 'FurN6BR5PH', NULL, NULL, 0);
INSERT INTO `user` VALUES (21, '韩杰宏', 97, 'zvPVJfiQYW', 'jiehhan1@gmail.com', 0, 'G3EAgPvdox', 'ZRBatQkmRr', NULL, NULL, 0);
INSERT INTO `user` VALUES (22, '杨子异', 98, 'mOjPIp5lr3', 'yangz4@hotmail.com', 0, 'etH5A0zR4s', 'Xt0cbDe5lI', NULL, NULL, 0);
INSERT INTO `user` VALUES (23, '贾杰宏', 85, 'hWhvC8uan6', 'jijia90@yahoo.com', 0, 'VPQyqZ9xCQ', '0Xh5RpE7eV', NULL, NULL, 0);
INSERT INTO `user` VALUES (24, '张三', 18, '$1$NCRMtS$0rAhlbJTsqtKE62O8lELx0', '123@qq.com', 1, NULL, '$1$NCRMtS', NULL, NULL, 0);
INSERT INTO `user` VALUES (25, '司马玉兰', 30, '$1$vFNs4q$LbiFTgqjqZVq5jldYIFCL1', 'tgmo3v.l5t30@vip.qq.com', 1, NULL, '$1$vFNs4q', '2024-12-05 10:14:24', '2024-12-05 10:14:24', 0);

SET FOREIGN_KEY_CHECKS = 1;
