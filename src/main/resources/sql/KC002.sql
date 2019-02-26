CREATE TABLE KC002 (
  product_id varchar(50) NOT NULL,
  repository_id varchar(50) NOT NULL,
  in_date datetime,
  amount int,
  purchase_note_id varchar(50),
  sales_return_note_id varchar(50),
  sales_exchange_note_id varchar(50),
  purchase_exchange_note_id varchar(50),
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 datetime,
  PRIMARY KEY (product_id, repository_id, purchase_note_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO KC002 (product_id, repository_id, in_date, amount, purchase_note_id)
VALUES ('a-0002', 'shenyang', '2019-01-02 12:30:30', 200, 'JH-2018-12-30-0001'),
('b-0001', 'shenyang', '2019-01-02 12:30:30', 150, 'JH-2018-12-23-0001'),
('c-0001', 'shenyang', '2019-01-02 13:30:30', 300, 'JH-2018-12-23-0002'),
('g-0001', 'shenyang', '2019-01-03 10:30:30', 150, 'JH-2019-01-02-0001'),
('g-0011', 'shenyang', '2019-01-03 12:30:30', 300, 'JH-2019-01-02-0001'),
('m-0001', 'shenyang', '2019-01-05 11:30:30', 300, 'JH-2018-12-23-0002'),
('o-0101', 'shenyang', '2019-01-05 12:44:30', 100, 'JH-2018-12-30-0001'),
('p-0001', 'shenyang', '2019-01-05 12:45:30', 200, 'JH-2018-12-23-0001');