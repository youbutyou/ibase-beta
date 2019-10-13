/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ibase

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-10-13 19:39:11
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
  `file_type` varbinary(255) DEFAULT NULL COMMENT '类型编码',
  `order_number` int(11) DEFAULT NULL COMMENT '排序号',
  `state` varchar(255) DEFAULT NULL COMMENT '数据状态',
  `checked` tinyint(1) DEFAULT NULL COMMENT '是否默认选中',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_dictionary
-- ----------------------------
INSERT INTO `system_dictionary` VALUES ('2', 'ibase', 'ibase', 'zero', 0x66696C655F303032, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('3', '001_system', '系统管理', 'ibase', 0x66696C655F303032, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('4', '002_public', '公用属性', 'ibase', 0x66696C655F303032, null, 'state_001', null, null);
INSERT INTO `system_dictionary` VALUES ('5', '001_system_module', '模块类型', '001_system', 0x66696C655F303032, null, 'state_001', null, null);
INSERT INTO `system_dictionary` VALUES ('6', '002_public_state', '数据状态', '002_public', 0x66696C655F303032, null, 'state_001', null, null);
INSERT INTO `system_dictionary` VALUES ('7', '002_public_file', '文件类型', '002_public', 0x66696C655F303032, null, 'state_001', null, null);
INSERT INTO `system_dictionary` VALUES ('8', 'state_001', '启用', '002_public_state', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('9', 'state_002', '停用', '002_public_state', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('10', 'file_001', '文件', '002_public_file', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('11', 'file_002', '目录', '002_public_file', 0x66696C655F303031, null, 'state_001', null, '');
INSERT INTO `system_dictionary` VALUES ('12', 'system_001', '系统信息', '001_system_module', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('13', 'module_001', '横向导航', '001_system_module', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('14', 'module_002', '应用模块', '001_system_module', 0x66696C655F303031, null, 'state_001', '0', '');
INSERT INTO `system_dictionary` VALUES ('15', 'toolbar_001', '头工具栏', '001_system_module', 0x66696C655F303031, null, 'state_001', null, '');
INSERT INTO `system_dictionary` VALUES ('16', 'toolbar_002', '行工具栏', '001_system_module', 0x66696C655F303031, null, 'state_001', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_module
-- ----------------------------
INSERT INTO `system_module` VALUES ('2', 'system', '赚钱杨胖胖', 'zero', '', '', 'system_001', null, 'file_002', 'state_001', '');
INSERT INTO `system_module` VALUES ('3', 'nav_001', '横向导航1', 'system', '', '', 'module_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('4', 'nav_002', '横向导航2', 'system', '', '', 'module_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('5', 'nav_003', '横向导航3', 'system', '', '', 'module_001', null, 'file_002', 'state_001', '');
INSERT INTO `system_module` VALUES ('6', 'nav_side_system', '系统管理', 'system', '', '', 'module_002', null, 'file_002', 'state_001', '');
INSERT INTO `system_module` VALUES ('7', 'nav_side_002', '侧边导航2', 'system', null, null, 'module_002', null, 'file_002', 'state_001', null);
INSERT INTO `system_module` VALUES ('9', 'dictionary', '数据字典', 'nav_side_system', '/systemdictionary/show', '', 'module_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('10', 'module', '应用模块', 'nav_side_system', '/systemmodule/show', '', 'module_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('11', 'user', '用户管理', 'nav_side_system', '/systemuser/show', null, 'module_002', null, 'file_001', 'state_001', null);
INSERT INTO `system_module` VALUES ('12', 'side_002_001', '侧边导航2-001', 'nav_side_002', '/main', null, 'module_002', null, 'file_001', 'state_001', null);
INSERT INTO `system_module` VALUES ('13', 'side-002-002', '侧边导航2-002', 'nav_side_002', '/main', '', 'module_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('14', 'nav_003_001', '横向导航3-001', 'nav_003', '/main', '', 'module_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('15', 'add', '新增', 'dictionary', '/systemdictionary/add', 'layui-icon-add-1', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('16', 'del', '删除', 'dictionary', '/systemdictionary/del', 'layui-icon-delete', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('17', 'detail', '查看', 'dictionary', '/systemdictionary/edit', 'layui-btn-primary', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('18', 'edit', '编辑', 'dictionary', '/systemdictionary/edit', '', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('19', 'del', '删除', 'dictionary', '/systemdictionary/del', 'layui-btn-danger', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('20', 'test', '测试', 'dictionary', '', '', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('21', 'add', '新增', 'module', '/systemmodule/add', 'layui-icon-add-1', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('22', 'del', '删除', 'module', '/systemmodule/del', 'layui-icon-delete', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('23', 'detail', '查看', 'module', '/systemmodule/edit', 'layui-btn-primary', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('24', 'edit', '编辑', 'module', '/systemmodule/edit', '', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('25', 'del', '删除', 'module', '/systemmodule/del', 'layui-btn-danger', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('26', 'add', '新增', 'user', '/systemuser/add', 'layui-icon-add-1', 'toolbar_001', '1', 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('27', 'del', '删除', 'user', '/systemuser/del', 'layui-icon-delete', 'toolbar_001', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('29', 'edit', '查看', 'user', '/systemuser/edit', 'layui-btn-primary', 'toolbar_002', null, 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('30', 'edit', '编辑', 'user', '/systemuser/edit', '', 'toolbar_002', '4', 'file_001', 'state_001', '');
INSERT INTO `system_module` VALUES ('31', 'del', '删除', 'user', '/systemuser/del', 'layui-btn-danger', 'toolbar_002', null, 'file_001', 'state_001', '');

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
