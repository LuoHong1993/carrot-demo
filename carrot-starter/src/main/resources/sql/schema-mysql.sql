


CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` varchar(64) CHARACTER SET latin1 NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '用户名称',
  `account` varchar(64) CHARACTER SET latin1 NOT NULL COMMENT '用户账号',
  `password` varchar(256) CHARACTER SET latin1 NOT NULL COMMENT '密码',
  `sex` varchar(8) CHARACTER SET utf8 DEFAULT NULL COMMENT '性别',
  `mobile` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号码',
  `flag` varchar(8) CHARACTER SET latin1 NOT NULL COMMENT '是否存在,0-存在，1-删除',
  `email` varchar(128) CHARACTER SET latin1 NOT NULL COMMENT '邮箱',
  `create_time` datetime(6) DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(6) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
