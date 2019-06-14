SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zk_employee
-- ----------------------------
DROP TABLE IF EXISTS `zk_employee`;
CREATE TABLE `zk_employee` (
  `employee_id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL ,
  `gender` int(11)  ,
  `create_time` VARCHAR (255),
  `area_id` int(11)  ,
  `position_id` int(11),
  PRIMARY KEY (`employee_id`),
  index `idx_name` (`name`) ,
  index `idx_create_time` (`create_time`),
  index `idx_area_id` (`area_id`) ,
  index `idx_position_id` (`position_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
