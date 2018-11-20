
CREATE TABLE  `auth`.`doctors` (
  `doctor_id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `doctor_type` varchar(45) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  `phone` varchar(20) NOT NULL default '',
  `doctor_info` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`doctor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE  `auth`.`centres` (
  `centre_id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `address` varchar(200) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  `phone` varchar(20) NOT NULL default '',
  `centre_info` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`centre_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE  `auth`.`appointments` (
  `appointment_id` int(11) NOT NULL auto_increment,
  `name` varchar(45) NOT NULL default '',
  `age` varchar(20) NOT NULL default '',
  `phone` varchar(20) NOT NULL default '',
  `address` varchar(200) NOT NULL default '',
  `doctor` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`appointment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- CREATE TABLE  `transformers`.`employees` (
--   `employee_id` int(11) NOT NULL auto_increment,
--   `first_name` varchar(45) NOT NULL default '',
--   `last_name` varchar(45) NOT NULL default '',
--   `email` varchar(45) NOT NULL default '',
--   `phone` varchar(20) NOT NULL default '',
--   `job_title` varchar(100) NOT NULL default '',
--   PRIMARY KEY  (`employee_id`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
