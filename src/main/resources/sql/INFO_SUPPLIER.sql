CREATE TABLE `INFO_SUPPLIER` (
  `supplier_id` varchar(10) NOT NULL COMMENT '供应商编号',
  `supplier_name` varchar(255) NOT NULL COMMENT '供应商名称',
  `manager` varchar(100) NOT NULL COMMENT '负责人',
  `phone` varchar(50) NOT NULL COMMENT '电话',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2',
  `freeuse3` date COMMENT '备用3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `INFO_SUPPLIER` VALUES (1, '华为', '路先生', '13334344343',null,null,null);
INSERT INTO `INFO_SUPPLIER` VALUES (2, '中兴', '陈女士', '13334344343',null,null,null);
INSERT INTO `INFO_SUPPLIER` VALUES (3, '高通', '赵先生', '13334344343',null,null,null);
INSERT INTO `INFO_SUPPLIER` VALUES (4, 'Intel', '张先生', '13334344343',null,null,null);
