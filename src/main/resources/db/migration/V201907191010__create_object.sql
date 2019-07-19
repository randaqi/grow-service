CREATE TABLE if NOT EXISTS `object` (

  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id' PRIMARY  key ,
  `description` varchar(50) NOT NULL DEFAULT '' COMMENT '目标描述',
  `key_results` varchar(255) NOT NULL DEFAULT '' COMMENT '关键结果',
  `reason` varchar(127) NOT NULL DEFAULT '' COMMENT '追求目标理由',
  `status_and_block` varchar(255) NOT NULL DEFAULT '' COMMENT '现状和障碍',
  `ways_to_cross_blocks` varchar(255) NOT NULL DEFAULT '' COMMENT '跨越障碍方法',
  `begin_date` datetime NOT NULL COMMENT '开始日期',
  `end_date` datetime NOT NULL COMMENT '结束日期',
  `imgs_path` varchar(255) NOT NULL DEFAULT '' COMMENT '图片地址'

) ENGINE=InnoDB DEFAULT CHARSET=utf8;