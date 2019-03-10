CREATE TABLE `INFO_USER` (
  `id` varchar(10) NOT NULL COMMENT '登录账号',
  `password` varchar(20) COMMENT '登录密码',
  `role_id` int COMMENT '用户角色',
  `name` varchar(100) COMMENT '姓名',
  `depart_id` int COMMENT '部门编号',
  `phone` varchar(50) COMMENT '联系电话',
  `freeuse1` int COMMENT '备用1',
  `freeuse2` varchar(255) COMMENT '备用2',
  `freeuse3` date COMMENT '备用3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `INFO_USER` VALUES ('0000', '0000', 1, '超级用户', 1, '13012345678', null, null, null);
