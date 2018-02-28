create table member(
    member_id int not null AUTO_INCREMENT,
    image_id int NOT null,
    member_name varchar(50) COLLATE utf8_unicode_ci not null ,
    member_email varchar(50) COLLATE utf8_unicode_ci not null,
    member_pass varchar(32) not null,
    member_sex enum('Nam','Nu') DEFAULT null,
    member_birthday date,
    member_isAdmin tinyint DEFAULT '0',
    member_date_register date,
    member_introduce varchar(200) collate utf8_unicode_ci DEFAULT null,
    member_accept tinyint DEFAULT '0',
    PRIMARY KEY (`member_id`),
    KEY	`FK_MEMBER_IMAGE` (`image_id`)
);
create table image(
	image_id int not null AUTO_INCREMENT,
    image_alt varchar(200) COLLATE utf8_unicode_ci DEFAULT null,
    image_src varchar(200) collate utf8_unicode_ci not null,
    PRIMARY KEY(`image_id`)
);
create table subject(
	subject_id varchar(10) COLLATE utf8_unicode_ci not null,
    subject_name varchar(100) COLLATE utf8_unicode_ci not null,
   	PRIMARY key(`subject_id`)
);
create table question(
	question_id int not null AUTO_INCREMENT,
  	subject_id varchar(10) COLLATE utf8_unicode_ci not null,
    member_id int not null,
    question_name varchar(50) COLLATE utf8_unicode_ci not null,
   	question_decription varchar(100) COLLATE utf8_unicode_ci not null,
    question_content varchar(500) COLLATE utf8_unicode_ci not null,
    question_date date,
    question_accept tinyint DEFAULT '0',
    PRIMARY key (`question_id`),
    Key `FK_QUESTION_SUBJECT` (`subject_id`),
    key `FR_QUESTION_MEMBER` (`member_id`)
);
create table anwser(
	anwser_id	int not null AUTO_INCREMENT,
    anwser_content varchar(500) COLLATE utf8_unicode_ci not null,
    anwser_date date,
    PRIMARY key (`anwser_id`)
);
create table aandq(
	anwser_id int NOT null,
    question_id int not null,
    PRIMARY KEY(`anwser_id`,`question_id`),
    KEY `FK_AANDQ_ANWSER` (	`anwser_id`),
    KEY `FK_AANDQ_QUESTION` (`question_id`)
);
ALTER TABLE `member` 
	ADD CONSTRAINT `FK_MEMBER_IMAGE` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`);
ALTER Table `question` 
	ADD CONSTRAINT `FK_QUESTION_SUBJECT` FOREIGN KEY(`subject_id`) REFERENCES `subject` (`subject_id`),
    ADD CONSTRAINT `FR_QUESTION_MEMBER` FOREIGN KEY(`member_id`) REFERENCES `member` (`member_id`);
ALTER TABLE `aandq`
	ADD CONSTRAINT `FK_AANDQ_ANWSER` FOREIGN KEY(`anwser_id`) REFERENCES `anwser`(`anwser_id`),
    ADD CONSTRAINT `FK_AANDQ_QUESTION` FOREIGN KEY(`question_id`) REFERENCES `question` (`question_id`);