CREATE TABLE CG002 (
  purchase_note_id varchar(50) NOT NULL COMMENT 'purchase note',
  product_id varchar(10),
  repository_id varchar(10),
  amount int,
  unit_price double,
  balance double,
  invoice_balance double,
  barcode varchar(50),
  state int,
  comment varchar(255),
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 date,
  KEY idx_purchase_note_id (purchase_note_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO CG002 (purchase_note_id, product_id, repository_id, amount, unit_price)
values ('JH-2018-12-23-0001', 'p-0001', 'shenyang', 100, 2339.00),
('JH-2018-12-23-0001', 'p-0002', 'shenyang', 200, 3399.99),
('JH-2018-12-23-0001', 'b-0001', 'shenyang', 150, 129.50),
('JH-2018-12-23-0002', 'c-0001', 'shenyang', 300, 788.90),
('JH-2018-12-23-0002', 'm-0001', 'shenyang', 300, 234.00),
('JH-2018-12-30-0001', 'a-0002', 'shenyang', 200, 3399.99),
('JH-2018-12-30-0001', 'r-0011', 'shenyang', 150, 129.50),
('JH-2018-12-30-0001', 'o-0101', 'shenyang', 300, 788.90),
('JH-2019-01-02-0001', 'x-0002', 'shenyang', 200, 3399.99),
('JH-2019-01-02-0001', 'g-0001', 'shenyang', 150, 129.50),
('JH-2019-01-02-0001', 'g-0011', 'shenyang', 300, 788.90),
('JH-2019-01-02-0001', 'w-0001', 'shenyang', 300, 234.00);