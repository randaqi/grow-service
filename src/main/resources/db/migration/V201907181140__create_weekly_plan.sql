CREATE TABLE IF NOT EXISTS `weekly_plan` (

    `weekly_plan_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `time` int NOT NULL,
    `completion_percent` float NOT NULL DEFAULT 0 COMMENT '完成百分比'

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;