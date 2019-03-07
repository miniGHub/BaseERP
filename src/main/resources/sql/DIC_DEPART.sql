CREATE TABLE `DIC_DEPART` (
  `depart_id` int NOT NULL COMMENT '部门编号',
  `depart_name` varchar(255) NOT NULL COMMENT '部门名称',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DIC_DEPART` VALUES (1, '总经办', null, null);
INSERT INTO `DIC_DEPART` VALUES (2, '销售部', null, null);
INSERT INTO `DIC_DEPART` VALUES (3, '采购部', null, null);
INSERT INTO `DIC_DEPART` VALUES (4, '财务部', null, null);
INSERT INTO `DIC_DEPART` VALUES (5, '行政部', null, null);
