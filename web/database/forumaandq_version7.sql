-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2017 at 01:05 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `forumaandq`
--

-- --------------------------------------------------------

--
-- Table structure for table `anwser`
--

CREATE TABLE `anwser` (
  `anwser_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `anwser_content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `anwser_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `image_id` int(11) NOT NULL,
  `image_alt` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_src` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `image_date_upload` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`image_id`, `image_alt`, `image_src`, `image_date_upload`) VALUES
(1, 'default avatar', 'images/user/default.png', '2017-10-21'),
(2, 'admin 1', 'images/user/1.jpg', '2017-10-22'),
(4, 'anh dai dien cua thanh vien 1', 'images/user/11.jpg', '2017-10-23'),
(5, 'anh dai dien cua thanh vien 1', 'images/user/14.jpg', '2017-10-23'),
(11, 'subject\'s Công Nghệ Thông Tin', 'images/subject/3.jpg', '2017-10-28'),
(12, 'subject\'s Language C#', 'images/subject/cthang.jpg', '2017-10-29'),
(13, 'subject\'s Language C', 'images/subject/c.jpg', '2017-10-29'),
(14, 'subject\'s Language C++', 'images/subject/cplus.jpg', '2017-10-29'),
(15, 'subject\'s Web with HTML5', 'images/subject/html5.jpg', '2017-10-29'),
(16, 'subject\'s Language Java', 'images/subject/java.jpg', '2017-10-29'),
(17, 'subject\'s Web with PHP', 'images/subject/PHP.png', '2017-10-29'),
(18, 'subject\'s Language Python', 'images/subject/python.png', '2017-10-29'),
(19, 'subject\'s Language R', 'images/subject/R.jpg', '2017-10-29'),
(20, 'subject\'s Khoa Học', 'images/subject/scient.png', '2017-10-29'),
(21, 'subject\'s Công nghệ', 'images/subject/cong_nghe_thong_tin_1.jpg', '2017-10-29'),
(22, 'subject\'s Làm việc nhóm', 'images/subject/group_study.jpg', '2017-10-29'),
(23, 'subject\'s Chia sẽ kinh nghiệm', 'images/subject/shareexp.png', '2017-10-29'),
(24, 'subject\'s Chia sẽ kinh nghiệm', 'images/subject/shareexp.png', '2017-10-29'),
(25, 'subject\'s Share Experence', 'images/subject/shareexp.png', '2017-10-29'),
(26, 'subject\'s Thủ thuật Windows', 'images/subject/windows-phone-logo-topic.png', '2017-11-06'),
(27, 'anh dai dien cua thanh vien ', 'images/user/windows-phone-logo-topic.png', '2017-11-06'),
(28, 'anh dai dien cua thanh vien ', 'images/user/22089205_1975422449393934_6211534651707274887_n.jpg', '2017-11-17'),
(29, 'anh dai dien cua thanh vien ', 'images/user/20170827_122205.jpg', '2017-11-17');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `member_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `member_email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `member_pass` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `member_sex` enum('Nam','Nu') COLLATE utf8_unicode_ci DEFAULT NULL,
  `member_birthday` date DEFAULT NULL,
  `member_isAdmin` tinyint(4) DEFAULT '0',
  `member_date_register` date DEFAULT NULL,
  `member_introduce` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `member_accept` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `member_name`, `member_email`, `member_pass`, `member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, `member_introduce`, `member_accept`) VALUES
(1, 'Nguyễn Tấn Được', 'adminforum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'Nam', '1996-06-01', 1, NULL, 'Thành viên khóa vĩnh viễn', 1),
(9, 'Kim Thanh Hoang', 'ew@gmail.com', '202cb962ac59075b964b07152d234b70', 'Nam', '1995-10-09', 0, '2017-11-06', 'Độ đẹp zai thì em đây vô đối ! ^^', 1),
(10, 'sindt263', 'sindt263@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', NULL, '2017-11-30', 1, '2017-11-06', 'asd', 1),
(11, 'phucdz', 'phuctaag123@gmail.com', 'e41f8ada43fef269e3aba8d5065a45ce', NULL, NULL, 1, '2017-11-06', NULL, 1),
(12, 'Chi Pham', 'chipham031196@gmail.com', 'a460ea74ce939d2ffc7175ddd92f3ac4', NULL, NULL, 0, '2017-11-06', NULL, 1),
(13, 'net', 'net@gmail.com', '202cb962ac59075b964b07152d234b70', NULL, NULL, 0, '2017-11-17', NULL, 0),
(14, 'Trần Thiện Phúc', 'phucttag123@gmail.com', 'e41f8ada43fef269e3aba8d5065a45ce', 'Nam', '1996-07-07', 0, '2017-11-17', 'User', 0),
(15, 'Đạt Vinh', 'datvinh299@gmail.com', 'fcea920f7412b5da7be0cf42b8c93759', 'Nam', '1996-03-20', 0, '2017-11-17', ' Đây là một đoạn giới thiệu rất dài và thật thú vị !', 0);

-- --------------------------------------------------------

--
-- Table structure for table `member_image`
--

CREATE TABLE `member_image` (
  `image_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `member_image`
--

INSERT INTO `member_image` (`image_id`, `member_id`) VALUES
(5, 1),
(27, 9),
(28, 9),
(29, 15);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `subject_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `member_id` int(11) NOT NULL,
  `question_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `question_decription` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `question_content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `question_date` datetime NOT NULL,
  `question_accept` tinyint(4) DEFAULT '0',
  `vote` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `subject_id`, `member_id`, `question_name`, `question_decription`, `question_content`, `question_date`, `question_accept`, `vote`) VALUES
(7, 'TTW', 9, 'Làm thế nào để tắt Windows Update trên Windows 7', 'Tắt Updates Windows 7', '<p>Như ti&ecirc;u đề, L&agrave;m sao tắt <u>Update Windows 7</u> ?&nbsp;<img alt=\"yes\" src=\"http://192.168.24.27:8080/ForumA-Q/ckeditor/plugins/smiley/images/thumbs_up.png\" style=\"height:23px; width:23px\" title=\"yes\" /></p>\r\n', '2017-11-17 16:38:52', 1, 2),
(8, 'Technology', 14, 'Include & Extend in Design Use Case Demo', 'Study ', '<p>How to difference&nbsp;beetwen&nbsp;Include and extend</p>\r\n', '2017-11-17 16:31:09', 1, 0),
(9, 'Java', 15, 'Cách tạo server chạy Java Web', 'Làm thế nào để tạo được một server Tomcat hay glassfish khi bị trùng cổng với chương trình khác.', '<p><span style=\"color:#3498db\"><span style=\"font-size:24px\">Ai gi&uacute;p với m&igrave;nh bị tr&ugrave;ng cổng glassfish v&agrave; tomcat với xampp, l&agrave;m thế n&agrave;o để đổi cổng tomcat v&agrave; glassfish.</span></span></p>\r\n', '2017-11-17 16:59:43', 0, 2);

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `image_id` int(11) NOT NULL,
  `subject_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `image_id`, `subject_name`) VALUES
('C', 13, 'Language C'),
('CNTT', 11, 'Công Nghệ Thông Tin'),
('Cplusplus', 14, 'Language C++'),
('Csharp', 12, 'Language C#'),
('HTML5', 15, 'Web with HTML5'),
('Java', 16, 'Language Java'),
('PHP', 17, 'Web with PHP'),
('Python', 18, 'Language Python'),
('R', 19, 'Language R'),
('Science', 20, 'Khoa Học'),
('Share Exp', 25, 'Share Experence'),
('Team Works', 22, 'Làm việc nhóm'),
('Technology', 21, 'Công nghệ'),
('TTW', 26, 'Thủ thuật Windows');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anwser`
--
ALTER TABLE `anwser`
  ADD PRIMARY KEY (`anwser_id`),
  ADD KEY `question_id` (`question_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`image_id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`);

--
-- Indexes for table `member_image`
--
ALTER TABLE `member_image`
  ADD PRIMARY KEY (`image_id`,`member_id`),
  ADD KEY `FK_MEMBER_IMAGE` (`image_id`),
  ADD KEY `FK_IMAGE_MEMBER` (`member_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `FK_QUESTION_SUBJECT` (`subject_id`),
  ADD KEY `FR_QUESTION_MEMBER` (`member_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `image_id` (`image_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `anwser`
--
ALTER TABLE `anwser`
  MODIFY `anwser_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `anwser`
--
ALTER TABLE `anwser`
  ADD CONSTRAINT `anwser_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  ADD CONSTRAINT `anwser_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- Constraints for table `member_image`
--
ALTER TABLE `member_image`
  ADD CONSTRAINT `FK_IMAGE_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  ADD CONSTRAINT `FK_MEMBER_IMAGE` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`);

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK_QUESTION_SUBJECT` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `FR_QUESTION_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
