CREATE TABLE User (
  id INT AUTO_INCREMENT,
  name VARCHAR(60),
  login VARCHAR(20),
  password VARCHAR(20),
  is_txt_enable BOOL,

  PRIMARY KEY (id)
);

CREATE TABLE gun_model (
  id INT AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL ,
  start_date TIMESTAMP NULL,
  end_date TIMESTAMP NULL,
  calibr VARCHAR(10) NOT NULL,

  PRIMARY KEY (id)
);

CREATE TABLE gun (
  id int(11) NOT NULL auto_increment,
  model_id int(11) default NULL,
  date timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  isSH tinyint(1) default '0',
  PRIMARY KEY  (`id`),
  KEY `fk_gun_to_model` (`model_id`),
  CONSTRAINT `fk_gun_to_model` FOREIGN KEY (`model_id`) REFERENCES `gun_model` (`id`)
);


INSERT INTO User (name, login, password, is_txt_enable)
VALUES ('Вася', 'Vasya', 'qwerty90', TRUE);

INSERT INTO User (name, login, password, is_txt_enable)
VALUES ('Петя', 'Petro', 'qwerty91', FALSE);

INSERT INTO User (name, login, password, is_txt_enable)
VALUES ('Марину', 'marina', 'marinasuperstar', TRUE);


INSERT INTO gun_model (name, start_date, end_date, calibr)
VALUES ('Парабеллум', '2000-01-01 00:00:00', '2037-01-01 00:00:00', '9 мм');


INSERT INTO gun (model_id, date, isSH)
VALUES (1, '1971-01-01 01:01:01', TRUE);
