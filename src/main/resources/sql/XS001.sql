CREATE TABLE `XS001` (
  `sales_order_note_id` varchar(50) COMMENT '销售订单单据编号',
  `client_id` varchar(10) COMMENT '客户编号',
  `repository_id` varchar(10) COMMENT '仓库编号',
  `entry_date` date COMMENT '录单日期',
  `delivery_date` date COMMENT '交货日期',
  `note_status` int COMMENT '单据状态',
  `operator_id` varchar(10) COMMENT '经办人',
  `depart_id` int COMMENT '部门编号',
  `remark` varchar(255) COMMENT '摘要',
  `addition` varchar(255) COMMENT '附加说明',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2',
  `freeuse3` date COMMENT '备用3',
  PRIMARY KEY (sales_order_note_id),
  KEY idx_sales_order_note_id (sales_order_note_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;