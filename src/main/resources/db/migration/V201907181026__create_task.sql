CREATE TABLE if NOT EXISTS `task` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `weekly_plan_id` int COMMENT '所属周计划',
    `task_status` int DEFAULT 0 COMMENT '完成情况',
    `objective_id` int COMMENT '所属目标',
    `task_desc` varchar(500) COMMENT '任务描述'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
