CREATE TABLE CG001 (
  purchase_note_id varchar(50) COMMENT '进货单单据编号',
  sales_order_note_id varchar(50) COMMENT '销售订单单据编号',
  supplier_id varchar(10) COMMENT '供应商编号',
  repository_id varchar(10) COMMENT '仓库编号',
  entry_date date COMMENT '录单日期',
  pay_date date COMMENT '付款日期',
  pay_id varchar(50) COMMENT '付款账号',
  pay_balance double COMMENT '付款金额',
  contact_id varchar(10) COMMENT '往来单位',
  contact_pay_id varchar(50) COMMENT '往来单位付款账号',
  contact_pay_balance double COMMENT '往来单位付款金额',
  discount_balance double COMMENT '优惠金额',
  operator_id varchar(10) COMMENT '经办人',
  depart_id  int COMMENT '部门编号',
  note_status int COMMENT '单据状态',
  remark  varchar(255) COMMENT '摘要',
  addition varchar(255) COMMENT '附件说明',
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 date,
  PRIMARY KEY (purchase_note_id),
  KEY idx_purchase_note_id (purchase_note_id),
  KEY idx_sales_order_note_id (sales_order_note_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO CG001 (purchase_note_id, sales_order_note_id, supplier_id, repository_id, entry_date, operator_id, note_status)
values ('JH-2018-12-23-0001', 'XSD-2018-12-23-0001', 'huawei', 'shenyang', '2018-12-23 12:20:30', 'luchao', 0),
('JH-2018-12-23-0002', 'XSD-2018-12-23-0002', 'huawei', 'shenyang', '2018-12-23 12:30:30', 'zhaolei', 0),
('JH-2018-12-30-0001', 'XSD-2018-12-29-0001', 'huawei', 'shenyang', '2018-12-30 10:20:30', 'luchao', 0),
('JH-2019-01-02-0001', 'XSD-2018-12-30-0001', 'huawei', 'shenyang', '2019-01-02 12:20:30', 'zhangxl', 0),
('JH-2019-01-02-0002', 'XSD-2018-12-30-0002', 'huawei', 'shenyang', '2019-01-02 13:20:30', 'luchao', 0);