CREATE TABLE CG001 (
  purchase_note_id varchar(50) NOT NULL COMMENT 'purchase note',
  sales_order_note_id varchar(50) NOT NULL COMMENT 'sales order note',
  supplier_id varchar(10),
  repository_id varchar(10),
  entry_date datetime,
  pay_date datetime,
  pay_id varchar(50),
  pay_balance double,
  contact_id varchar(10),
  contact_pay_id varchar(50),
  contact_pay_balance double,
  discount_balance double,
  operator_id varchar(10),
  depart_id  int,
  remark  varchar(255),
  addition varchar(255),
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 datetime,
  PRIMARY KEY (purchase_note_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO CG001 (purchase_note_id, sales_order_note_id, supplier_id, repository_id, entry_date, operator_id)
values ('JH-2018-12-23-0001', 'XSD-2018-12-23-0001', 'huawei', 'shenyang', '2018-12-23 12:20:30', 'luchao'),
('JH-2018-12-23-0002', 'XSD-2018-12-23-0002', 'huawei', 'shenyang', '2018-12-23 12:30:30', 'zhaolei'),
('JH-2018-12-30-0001', 'XSD-2018-12-29-0001', 'huawei', 'shenyang', '2018-12-30 10:20:30', 'luchao'),
('JH-2019-01-02-0001', 'XSD-2018-12-30-0001', 'huawei', 'shenyang', '2019-01-02 12:20:30', 'zhangxl'),
('JH-2019-01-02-0002', 'XSD-2018-12-30-0002', 'huawei', 'shenyang', '2019-01-02 13:20:30', 'luchao');