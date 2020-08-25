/*
 Navicat Premium Data Transfer

 Source Server         : root@mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : sms

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 25/08/2020 15:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`
(
    `id`     int UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `eno`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `eclass` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `ename`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `esex`   varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    `eage`   int                                                    NULL DEFAULT NULL,
    `ewage`  decimal(16, 2)                                         NOT NULL,
    `etel`   varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`
(
    `id`     int UNSIGNED                                           NOT NULL AUTO_INCREMENT,
    `gno`    varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gname`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gclass` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gprice` decimal(16, 2)                                         NULL DEFAULT NULL,
    `gmix`   decimal(16, 2)                                         NULL DEFAULT NULL,
    `gstnum` int                                                    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `i_goods` (`gno`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`
(
    `pfno`   varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gno`    varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `pnum`   int                                                    NOT NULL,
    `pprice` decimal(6, 2)                                          NOT NULL,
    `stsum`  decimal(8, 2)                                          NOT NULL,
    PRIMARY KEY (`pfno`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage`
(
    `stno`   varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gno`    varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `gname`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `stnum`  int                                                    NOT NULL,
    `stsum`  decimal(8, 2)                                          NOT NULL,
    `stdate` date                                                   NOT NULL,
    PRIMARY KEY (`stno`) USING BTREE,
    INDEX `i_storage` (`stno`, `stdate`, `gno`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`
(
    `spno`   varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `spname` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `sptel`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`spno`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`       int UNSIGNED                                            NOT NULL AUTO_INCREMENT,
    `name`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `email`    varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL,
    PRIMARY KEY (`id`, `name`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 36
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip`
(
    `id`          int UNSIGNED                                            NOT NULL AUTO_INCREMENT,
    `vipno`       varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `vipname`     varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL,
    `vipbalance`  decimal(16, 2)                                          NOT NULL,
    `vippassword` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `vipresdate`  date                                                    NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse`
(
    `whno`     varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `whname`   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    `whadress` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
    PRIMARY KEY (`whno`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
