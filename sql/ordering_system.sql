/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50536
 Source Host           : 127.0.0.1:3306
 Source Schema         : ordering_system

 Target Server Type    : MySQL
 Target Server Version : 50536
 File Encoding         : 65001

 Date: 08/03/2023 16:47:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_announcement
-- ----------------------------
DROP TABLE IF EXISTS `tb_announcement`;
CREATE TABLE `tb_announcement`  (
  `announcementID` int(11) NOT NULL AUTO_INCREMENT,
  `createdTime` datetime NULL DEFAULT NULL,
  `url` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`announcementID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `categoryID` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`categoryID`) USING BTREE,
  UNIQUE INDEX `category`(`category`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_chef
-- ----------------------------
DROP TABLE IF EXISTS `tb_chef`;
CREATE TABLE `tb_chef`  (
  `chefID` int(11) NOT NULL AUTO_INCREMENT,
  `chef` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profilePhoto` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdTime` datetime NULL DEFAULT NULL,
  `performance` float NULL DEFAULT NULL,
  PRIMARY KEY (`chefID`) USING BTREE,
  UNIQUE INDEX `chef`(`chef`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_customer
-- ----------------------------
DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`  (
  `customerID` int(11) NOT NULL AUTO_INCREMENT,
  `customer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profilePhoto` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `accumulatedAmount` float NULL DEFAULT 0,
  `createdTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`customerID`) USING BTREE,
  UNIQUE INDEX `customer`(`customer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_dish
-- ----------------------------
DROP TABLE IF EXISTS `tb_dish`;
CREATE TABLE `tb_dish`  (
  `dishID` int(11) NOT NULL AUTO_INCREMENT,
  `dish` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `categoryID` int(11) NULL DEFAULT NULL,
  `dishPhoto` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float NOT NULL,
  `Inventory` int(11) NULL DEFAULT NULL,
  `createdTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`dishID`) USING BTREE,
  UNIQUE INDEX `dish`(`dish`) USING BTREE,
  INDEX `categoryID`(`categoryID`) USING BTREE,
  CONSTRAINT `tb_dish_ibfk_1` FOREIGN KEY (`categoryID`) REFERENCES `tb_category` (`categoryID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager`  (
  `managerID` int(11) NOT NULL AUTO_INCREMENT,
  `manager` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profilePhoto` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdTime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`managerID`) USING BTREE,
  UNIQUE INDEX `manager`(`manager`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `orderID` int(11) NOT NULL AUTO_INCREMENT,
  `customerID` int(11) NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `userRatings` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `totalAmount` float NULL DEFAULT NULL,
  `createdTime` datetime NULL DEFAULT NULL,
  `chefID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`orderID`) USING BTREE,
  INDEX `customerID`(`customerID`) USING BTREE,
  INDEX `chefID`(`chefID`) USING BTREE,
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `tb_customer` (`customerID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_order_ibfk_2` FOREIGN KEY (`chefID`) REFERENCES `tb_chef` (`chefID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_order_detail`;
CREATE TABLE `tb_order_detail`  (
  `orderDetailID` int(11) NOT NULL AUTO_INCREMENT,
  `orderID` int(11) NULL DEFAULT NULL,
  `dishID` int(11) NULL DEFAULT NULL,
  `number` int(11) NOT NULL,
  `dishAmount` float NULL DEFAULT NULL,
  PRIMARY KEY (`orderDetailID`) USING BTREE,
  INDEX `orderID`(`orderID`) USING BTREE,
  INDEX `dishID`(`dishID`) USING BTREE,
  CONSTRAINT `tb_order_detail_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `tb_order` (`orderID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `tb_order_detail_ibfk_2` FOREIGN KEY (`dishID`) REFERENCES `tb_dish` (`dishID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
