/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ibase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-09-18 18:05:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `arcsoft_face`
-- ----------------------------
DROP TABLE IF EXISTS `arcsoft_face`;
CREATE TABLE `arcsoft_face` (
  `id` int(11) NOT NULL,
  `user_sn` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `face_id` varchar(255) DEFAULT NULL,
  `face_feature` varbinary(1032) DEFAULT NULL COMMENT '脸部特性数据',
  `edit_time` datetime DEFAULT NULL,
  `edit_user` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of arcsoft_face
-- ----------------------------

-- ----------------------------
-- Table structure for `system_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `system_dictionary`;
CREATE TABLE `system_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL COMMENT '编号',
  `iname` varchar(255) DEFAULT NULL COMMENT '名称',
  `psn` varchar(255) DEFAULT NULL COMMENT '父节点',
  `dic_type_sn` varbinary(255) DEFAULT NULL COMMENT '类型编码',
  `order_number` int(11) DEFAULT NULL COMMENT '排序号',
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_dictionary
-- ----------------------------
INSERT INTO `system_dictionary` VALUES ('1', 'state_001', '启用', null, 0x3030315F7075626C69635F7374617465, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('2', 'state_002', '停用', null, 0x3030315F7075626C69635F7374617465, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('3', 'file_001', '文件', null, 0x3030325F7075626C69635F66696C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('4', 'file_002', '目录', null, 0x3030325F7075626C69635F66696C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('7', 'system_config_001', '系统信息配置', null, 0x3030315F73797374656D5F6D6F64756C65, '1', 'state_001', '系统名称等');
INSERT INTO `system_dictionary` VALUES ('8', 'navigation_001', '横向导航', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('9', 'navigation_002', '侧边导航', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('10', 'toolbar_001', '头工具栏', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('11', 'toolbar_002', '行工具栏', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('12', 'toolbar_003', '扩展头工具栏', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);
INSERT INTO `system_dictionary` VALUES ('13', 'toolbar_004', '扩展行工具栏', null, 0x3030315F73797374656D5F6D6F64756C65, null, 'state_001', null);

-- ----------------------------
-- Table structure for `system_dictionary_type`
-- ----------------------------
DROP TABLE IF EXISTS `system_dictionary_type`;
CREATE TABLE `system_dictionary_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(40) DEFAULT NULL COMMENT '编号',
  `iname` varchar(255) DEFAULT NULL COMMENT '名称',
  `psn` varchar(255) DEFAULT NULL COMMENT '父节点',
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_dictionary_type
-- ----------------------------
INSERT INTO `system_dictionary_type` VALUES ('1', '001_system', '系统管理', null, 'state_001', null);
INSERT INTO `system_dictionary_type` VALUES ('2', '002_public', '公用属性', null, 'state_001', null);
INSERT INTO `system_dictionary_type` VALUES ('3', '001_system_module', '模块类型', '001_system', 'state_001', null);
INSERT INTO `system_dictionary_type` VALUES ('4', '002_public_state', '数据状态', '002_public', 'state_001', null);
INSERT INTO `system_dictionary_type` VALUES ('5', '002_public_file', '文件类型', '002_public', 'state_001', null);

-- ----------------------------
-- Table structure for `system_module`
-- ----------------------------
DROP TABLE IF EXISTS `system_module`;
CREATE TABLE `system_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL COMMENT '编号',
  `iname` varchar(255) DEFAULT NULL COMMENT '名称',
  `psn` varchar(255) DEFAULT NULL COMMENT '父节点',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `dic_sn` varchar(255) DEFAULT NULL COMMENT '字典编码',
  `order_number` int(11) DEFAULT NULL COMMENT '排序号',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_module
-- ----------------------------
INSERT INTO `system_module` VALUES ('1', 'system_info', '赚钱杨胖胖', null, null, null, 'system_config_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('2', 'nav_001', '横向导航1', null, null, null, 'navigation_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('3', 'nav_002', '横向导航2', null, null, null, 'navigation_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('4', 'nav_003', '横向导航3', null, null, null, 'navigation_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('5', 'nav_side_system', '系统管理', null, null, null, 'navigation_002', null, 'file_002', 'state_001', null);
INSERT INTO `system_module` VALUES ('6', 'nav_side_002', '侧边导航2', null, null, null, 'navigation_002', null, 'file_002', 'state_001', null);
INSERT INTO `system_module` VALUES ('7', 'nav_side_003', '侧边导航3', null, null, null, 'navigation_002', null, 'file_001', 'state_001', null);
INSERT INTO `system_module` VALUES ('8', 'dictionary', '数据字典', 'nav_side_system', '/systemdictionary/show', null, 'navigation_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('9', 'module', '应用模块', 'nav_side_system', '/systemmodule/show', null, 'navigation_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('10', 'side_001_003', '侧边导航1-003', 'nav_side_system', '/main', null, 'navigation_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('11', 'side_002_001', '侧边导航2-001', 'nav_side_002', '/main', null, 'navigation_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('12', 'side-002-002', '侧边导航2-002', 'nav_side_002', '/main', null, 'navigation_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('13', 'nav_003_001', '横向导航3-001', 'nav_003', '/main', null, 'navigation_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('14', 'add', '新增', 'dictionary', '/systemdictionary/add', null, 'toolbar_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('15', 'del', '删除', 'dictionary', '/systemdictionary/del', null, 'toolbar_001', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('16', 'detail', '查看', 'dictionary', '/systemdictionary/edit', null, 'toolbar_002', null, null, 'state_001', null);
INSERT INTO `system_module` VALUES ('17', 'edit', '编辑', 'dictionary', '/systemdictionary/edit', null, 'toolbar_002', null, null, 'state_001', null);

-- ----------------------------
-- Table structure for `system_user`
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL COMMENT '编码',
  `iname` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `phone` varchar(25) DEFAULT NULL COMMENT '手机号码',
  `role_sn` varchar(255) DEFAULT NULL COMMENT '角色编号',
  `org_sn` varchar(255) DEFAULT NULL COMMENT '组织编码',
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  `edit_time` datetime DEFAULT NULL COMMENT '添加/编辑时间',
  `edit_user` varchar(255) DEFAULT NULL COMMENT '添加/编辑人员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', 'root', '管理员', 'root', '13093790968', null, null, null, null, null);

-- ----------------------------
-- Table structure for `system_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `system_user_info`;
CREATE TABLE `system_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_sn` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `gender` int(4) DEFAULT NULL COMMENT '性别（1-男，2-女）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `signature` varchar(255) DEFAULT NULL COMMENT '个人签名',
  `edit_time` datetime DEFAULT NULL COMMENT '编辑时间',
  `edit_user` varchar(255) DEFAULT NULL COMMENT '编辑人编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_user_info
-- ----------------------------
