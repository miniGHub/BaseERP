CREATE TABLE `XS004` (
  `sales_note_id` varchar(50) COMMENT '销售单单据编号',
  `product_id` varchar(10) COMMENT '商品编号',
  `respority_id` varchar(10) COMMENT '仓库编号',
  `amount` int COMMENT '数量',
  `unit_price` double COMMENT '单价',
  `balance` double COMMENT '金额（总价）',
  `discount_unit_price` double COMMENT '折后单价',
  `discount_balance` double COMMENT '折后金额',
  `invoice_balance` double COMMENT '开票金额',
  `barcode` varchar(50) COMMENT '条码',
  `state` int COMMENT '状态',
  `comment` varchar(255) COMMENT '备用',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2',
  `freeuse3` date COMMENT '备用3',
  KEY idx_sales_note_id (sales_note_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
