CREATE TABLE `INFO_PRODUCT` (
  `product_id` varchar(10) NOT NULL COMMENT '商品编号',
  `product_type` int COMMENT '商品分类',
  `product_name` varchar(255) COMMENT '商品名称',
  `barcode` varchar(50) COMMENT '条码',
  `state` int COMMENT '状态',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2',
  `freeuse3` date COMMENT '备用3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `INFO_PRODUCT` VALUES ('000', 1, "HP-111", 'xxx', 1,null, null, null);
INSERT INTO `INFO_PRODUCT` VALUES ('001', 1, "DELL-222", 'xxx', 2,null, null, null);
INSERT INTO `INFO_PRODUCT` VALUES ('002', 2, "XL-33", 'xxx', 3,null, null, null);
INSERT INTO `INFO_PRODUCT` VALUES ('003', 2, "bafalo-4", 'xxx', 4,null, null, null);
