CREATE TABLE KC001 (
  product_id varchar(50) NOT NULL,
  repository_id varchar(50) NOT NULL,
  amount int,
  freeuse1 int,
  freeuse2 varchar(255),
  freeuse3 datetime,
  PRIMARY KEY (product_id, repository_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
INSERT INTO KC001 (product_id, repository_id, amount)
VALUES ('a-0002', 'shenyang', 0),
('b-0001', 'shenyang', 0),
('c-0001', 'shenyang', 0),
('g-0001', 'shenyang', 0),
('g-0011', 'shenyang', 0),
('m-0001', 'shenyang', 0),
('o-0101', 'shenyang', 0),
('p-0001', 'shenyang', 0),
('p-0002', 'shenyang', 0),
('w-0001', 'shenyang', 0),
('x-0002', 'shenyang', 0);