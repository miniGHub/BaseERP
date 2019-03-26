CREATE TABLE `DIC_PRODUCT` (
  `product_type` int NOT NULL COMMENT '商品类别',
  `product_dic_name` varchar(255) NOT NULL COMMENT '商品名称',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DIC_PRODUCT` VALUES (1, '打印机', null, null);
INSERT INTO `DIC_PRODUCT` VALUES (2, '路由器', null, null);
