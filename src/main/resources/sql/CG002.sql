CREATE TABLE CG002 (
  purchase_detail_id varchar(50) NOT NULL,
  purchase_note_id varchar(50) NOT NULL COMMENT 'purchase note',
  product_id varchar(10),
  repority_id varchar(10),
  amount  int,
  unit_price  double,
  balance     double,
  invoice_balance  double,
  barcode    varchar(50),
  state   int,
  comment varchar(255),
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 date,
  PRIMARY KEY (purchase_detail_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;