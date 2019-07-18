CREATE TABLE if NOT EXISTS `task` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `weekly_plan_id` int NOT NULL COMMENT '所属周计划',
    `status` int DEFAULT 0 COMMENT '完成情况',
    `objective_id` int NOT NULL COMMENT '所属目标',
    `desc` varchar(500) NOT NULL COMMENT '任务描述'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
