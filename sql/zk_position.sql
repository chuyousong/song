SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for zk_position
-- ----------------------------
DROP TABLE IF EXISTS `zk_position`;
CREATE TABLE `zk_position` (
  `position_id` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`position_id`),
  index `idx_name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 auto_increment=1;
