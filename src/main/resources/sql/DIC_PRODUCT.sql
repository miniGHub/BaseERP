CREATE TABLE `DIC_PRODUCT` (
  `product_type` int NOT NULL COMMENT '商品类别',
  `product_type_name` varchar(255) NOT NULL COMMENT '商品类别名称',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DIC_PRODUCT` VALUES (1, '办公用品', null, null);
INSERT INTO `DIC_PRODUCT` VALUES (2, '文具', null, null);
INSERT INTO `DIC_PRODUCT` VALUES (3, '网络设备耗材', null, null);
