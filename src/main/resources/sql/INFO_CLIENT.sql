CREATE TABLE `INFO_CLIENT` (
  client_id varchar (10) NOT NULL COMMENT '客户ID',
  client_name varchar(255) NOT NULL COMMENT '客户名称',
  manager varchar (100) COMMENT '负责人',
  phone varchar (50) COMMENT '联系电话',
  freeuse1 int COMMENT '备用1',
  freeuse2 varchar(255) COMMENT '备用2',
  freeuse3 date COMMENT '备用3'
  PRIMARY KEY (client_id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `INFO_CLIENT` VALUES
('001', '华润万家', '张经理', '11223344556', 0, '', ''),
('002', '乐购', '李经理', '12345678901', 0, '', ''),
('003', '山姆', '王经理', '333', 0, '', '');