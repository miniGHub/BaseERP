CREATE TABLE `INFO_REPOSITORY` (
  repository_id varchar(10) NOT NULL COMMENT '仓库编号',
  repository_type int NOT NULL COMMENT '仓库类别',
  repository_name varchar(255) not null  COMMENT '仓库名称',
  address varchar(255) COMMENT '仓库地址',
  manager varchar(100) COMMENT '负责人',
  phone varchar(100) COMMENT '联系电话',
  freeuse1 int COMMENT '备用1',
  freeuse2 varchar(255) COMMENT '备用2',
  freeuse3 date COMMENT '备用3',
  PRIMARY KEY (repository_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `INFO_REPOSITORY` VALUES
('SY-001', 0, '沈阳总库', '沈阳浑南新区国际软件园', 'ABC', '12345678901', 0, '', null),
('FS-001', 0, '抚顺分库', '抚顺哪哪哪', 'XYZ', '11223344556', 0, '', null),
('SY-002', 0, '沈阳分库', '沈阳市府广场', 'ABC', '12345678901', 0, '', null);