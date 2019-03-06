CREATE TABLE `DIC_ROLE` (
  `role_id` int NOT NULL COMMENT '角色编号',
  `role_name` varchar(255) NOT NULL COMMENT '角色名称',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DIC_ROLE` VALUES (1, '超级管理员', null, null);
INSERT INTO `DIC_ROLE` VALUES (2, '总经理', null, null);
INSERT INTO `DIC_ROLE` VALUES (3, '销售主管', null, null);
INSERT INTO `DIC_ROLE` VALUES (4, '采购主管', null, null);
INSERT INTO `DIC_ROLE` VALUES (5, '财务会计', null, null);
INSERT INTO `DIC_ROLE` VALUES (6, '出纳', null, null);
INSERT INTO `DIC_ROLE` VALUES (7, '销售专员', null, null);
INSERT INTO `DIC_ROLE` VALUES (8, '采购专员', null, null);
