-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2017 at 12:39 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Table structure for table `aandq`
--

CREATE TABLE `aandq` (
  `anwser_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `anwser`
--

CREATE TABLE `anwser` (
  `anwser_id` int(11) NOT NULL,
  `anwser_content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `anwser_date` date NOT NULL
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
(11, 'subject''s Công Nghệ Thông Tin', 'images/subject/3.jpg', '2017-10-28'),
(12, 'subject''s Language C#', 'images/subject/C#.jpg', '2017-10-29'),
(13, 'subject''s Language C', 'images/subject/c.jpg', '2017-10-29'),
(14, 'subject''s Language C++', 'images/subject/c++.jpg', '2017-10-29'),
(15, 'subject''s Web with HTML5', 'images/subject/html5.jpg', '2017-10-29'),
(16, 'subject''s Language Java', 'images/subject/java.jpg', '2017-10-29'),
(17, 'subject''s Web with PHP', 'images/subject/PHP.png', '2017-10-29'),
(18, 'subject''s Language Python', 'images/subject/python.png', '2017-10-29'),
(19, 'subject''s Language R', 'images/subject/R.jpg', '2017-10-29'),
(20, 'subject''s Khoa Học', 'images/subject/scient.png', '2017-10-29'),
(21, 'subject''s Công nghệ', 'images/subject/cong_nghe_thong_tin_1.jpg', '2017-10-29'),
(22, 'subject''s Làm việc nhóm', 'images/subject/group_study.jpg', '2017-10-29'),
(23, 'subject''s Chia sẽ kinh nghiệm', 'images/subject/shareexp.png', '2017-10-29'),
(24, 'subject''s Chia sẽ kinh nghiệm', 'images/subject/shareexp.png', '2017-10-29'),
(25, 'subject''s Share Experence', 'images/subject/shareexp.png', '2017-10-29');

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
(1, 'Nguyễn Tấn Được', 'adminforum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'Nam', '1996-06-01', 1, NULL, 'Thành viên khóa vĩnh viễn', 0),
(2, 'Nguyễn Minh An', 'admin2forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'Nam', '1996-01-06', 0, '2017-10-21', 'Chấp nhận đầu tiên', 1),
(3, 'adminforum3', 'admin3forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, '1996-01-22', 0, '2017-10-21', NULL, 0),
(4, 'admin4', 'admin4forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0),
(5, 'admin5', 'admin5forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0),
(6, 'admin6', 'admin6forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0),
(7, 'admin7', 'admin7forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0);

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
(2, 1),
(4, 1),
(5, 1);

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
  `question_date` date NOT NULL,
  `question_accept` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
('C#', 12, 'Language C#'),
('C++', 14, 'Language C++'),
('CNTT', 11, 'Công Nghệ Thông Tin'),
('HTML5', 15, 'Web with HTML5'),
('Java', 16, 'Language Java'),
('PHP', 17, 'Web with PHP'),
('Python', 18, 'Language Python'),
('R', 19, 'Language R'),
('Science', 20, 'Khoa Học'),
('Share Exp', 25, 'Share Experence'),
('Team Works', 22, 'Làm việc nhóm'),
('Technology', 21, 'Công nghệ');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aandq`
--
ALTER TABLE `aandq`
  ADD PRIMARY KEY (`anwser_id`,`question_id`),
  ADD KEY `FK_AANDQ_ANWSER` (`anwser_id`),
  ADD KEY `FK_AANDQ_QUESTION` (`question_id`);

--
-- Indexes for table `anwser`
--
ALTER TABLE `anwser`
  ADD PRIMARY KEY (`anwser_id`);

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
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `aandq`
--
ALTER TABLE `aandq`
  ADD CONSTRAINT `FK_AANDQ_ANWSER` FOREIGN KEY (`anwser_id`) REFERENCES `anwser` (`anwser_id`),
  ADD CONSTRAINT `FK_AANDQ_QUESTION` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`);

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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
