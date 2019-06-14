SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zk_area
-- ----------------------------
DROP TABLE IF EXISTS `zk_area`;
CREATE TABLE `zk_area` (
  `area_id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL ,
  `parent_id` int(11),
  PRIMARY KEY (`area_id`),
  index `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;


