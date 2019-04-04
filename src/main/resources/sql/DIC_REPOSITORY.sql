CREATE TABLE `DIC_REPOSITORY` (
  `repository_type` int NOT NULL COMMENT '仓库类别',
  `repository_type_name` varchar(255) NOT NULL COMMENT '仓库类别名称',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `DIC_REPOSITORY` VALUES (1, '总库', null, null);
INSERT INTO `DIC_REPOSITORY` VALUES (2, '分库', null, null);
