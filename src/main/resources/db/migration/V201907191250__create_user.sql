CREATE TABLE IF NOT EXISTS `user` (

    `user_id` int NOT NULL PRIMARY KEY,
    `avator` varchar(255),
    `nickname` varchar(20),
    `introduction` varchar(255)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;