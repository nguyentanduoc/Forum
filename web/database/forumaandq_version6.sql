-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 06, 2017 lúc 09:19 AM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `forumaandq`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `anwser`
--

CREATE TABLE `anwser` (
  `anwser_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `anwser_content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `anwser_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `anwser`
--

INSERT INTO `anwser` (`anwser_id`, `question_id`, `member_id`, `anwser_content`, `anwser_date`) VALUES
(1, 13, 13, 'hỏi cái gì  z?', '2017-11-06 13:55:31'),
(2, 15, 1, 'LOL.', '2017-11-06 14:47:53'),
(3, 15, 1, 'LOL.', '2017-11-06 14:55:46'),
(4, 15, 1, 'LOL.', '2017-11-06 14:55:46'),
(5, 15, 1, 'LOL.', '2017-11-06 14:55:47'),
(6, 15, 1, 'LOL.', '2017-11-06 14:55:47'),
(7, 15, 1, 'LOL.', '2017-11-06 14:55:47'),
(8, 15, 1, 'LOL.', '2017-11-06 14:55:47'),
(9, 15, 1, 'LOL.', '2017-11-06 14:55:47');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `image`
--

CREATE TABLE `image` (
  `image_id` int(11) NOT NULL,
  `image_alt` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `image_src` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `image_date_upload` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `image`
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
(27, 'anh dai dien cua thanh vien ', 'images/user/windows-phone-logo-topic.png', '2017-11-06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member`
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
-- Đang đổ dữ liệu cho bảng `member`
--

INSERT INTO `member` (`member_id`, `member_name`, `member_email`, `member_pass`, `member_sex`, `member_birthday`, `member_isAdmin`, `member_date_register`, `member_introduce`, `member_accept`) VALUES
(1, 'Nguyễn Tấn Được', 'adminforum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'Nam', '1996-06-01', 1, NULL, 'Thành viên khóa vĩnh viễn', 0),
(2, 'Nguyễn Minh An', 'admin2forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', 'Nam', '1996-01-06', 0, '2017-10-21', 'Chấp nhận đầu tiên', 1),
(3, 'adminforum3', 'admin3forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, '1996-01-22', 0, '2017-10-21', NULL, 0),
(4, 'admin4', 'admin4forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 1),
(5, 'admin5', 'admin5forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 2),
(6, 'admin6', 'admin6forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0),
(7, 'admin7', 'admin7forum@gmail.com', '21232f297a57a5a743894a0e4a801fc3', NULL, NULL, 0, '2017-10-21', NULL, 0),
(8, 'admin2', 'admin2@gmail.com', 'admin2', NULL, NULL, 0, '2017-11-02', NULL, 0),
(9, 'Kim Thanh Hoang', 'ew@gmail.com', '92a6ec6a38f85c0fc4e0a5761c68d856', 'Nam', '1995-10-09', 0, '2017-11-06', 'Nhà có điều kiện!', 1),
(10, 'sindt263', 'sindt263@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', NULL, '2017-11-30', 1, '2017-11-06', 'asd', 1),
(11, 'phucdz', 'phuctaag123@gmail.com', 'e41f8ada43fef269e3aba8d5065a45ce', NULL, NULL, 1, '2017-11-06', NULL, 1),
(12, 'Chi Pham', 'chipham031196@gmail.com', 'a460ea74ce939d2ffc7175ddd92f3ac4', NULL, NULL, 0, '2017-11-06', NULL, 0),
(13, 'ChiPham', 'email@gmail.com', '202cb962ac59075b964b07152d234b70', NULL, NULL, 0, '2017-11-06', NULL, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `member_image`
--

CREATE TABLE `member_image` (
  `image_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `member_image`
--

INSERT INTO `member_image` (`image_id`, `member_id`) VALUES
(2, 1),
(4, 1),
(5, 1),
(27, 9);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `subject_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `member_id` int(11) NOT NULL,
  `question_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `question_decription` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `question_content` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `question_date` datetime NOT NULL,
  `question_accept` tinyint(4) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `question`
--

INSERT INTO `question` (`question_id`, `subject_id`, `member_id`, `question_name`, `question_decription`, `question_content`, `question_date`, `question_accept`) VALUES
(13, 'C', 10, 'fffff', 'asdf', '<p>asdf</p>\r\n', '2017-11-06 13:53:33', 1),
(14, 'C', 10, 'ddddd', 'dddd', '<p>asdfg</p>\r\n', '2017-11-06 13:53:49', 2),
(15, 'C#', 9, 'Clone Project từ Github vào Visual Studio 2017', 'C# Github clone.', '<p>Như ti&ecirc;u đề ạ.</p>\r\n', '2017-11-06 14:06:14', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `subject_id` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `image_id` int(11) NOT NULL,
  `subject_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `subject`
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
('Technology', 21, 'Công nghệ'),
('TTW', 26, 'Thủ thuật Windows');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `anwser`
--
ALTER TABLE `anwser`
  ADD PRIMARY KEY (`anwser_id`),
  ADD KEY `question_id` (`question_id`),
  ADD KEY `member_id` (`member_id`);

--
-- Chỉ mục cho bảng `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`image_id`);

--
-- Chỉ mục cho bảng `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`);

--
-- Chỉ mục cho bảng `member_image`
--
ALTER TABLE `member_image`
  ADD PRIMARY KEY (`image_id`,`member_id`),
  ADD KEY `FK_MEMBER_IMAGE` (`image_id`),
  ADD KEY `FK_IMAGE_MEMBER` (`member_id`);

--
-- Chỉ mục cho bảng `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`),
  ADD KEY `FK_QUESTION_SUBJECT` (`subject_id`),
  ADD KEY `FR_QUESTION_MEMBER` (`member_id`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `image_id` (`image_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `anwser`
--
ALTER TABLE `anwser`
  MODIFY `anwser_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT cho bảng `image`
--
ALTER TABLE `image`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT cho bảng `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT cho bảng `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `anwser`
--
ALTER TABLE `anwser`
  ADD CONSTRAINT `anwser_ibfk_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`),
  ADD CONSTRAINT `anwser_ibfk_2` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- Các ràng buộc cho bảng `member_image`
--
ALTER TABLE `member_image`
  ADD CONSTRAINT `FK_IMAGE_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  ADD CONSTRAINT `FK_MEMBER_IMAGE` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`);

--
-- Các ràng buộc cho bảng `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FK_QUESTION_SUBJECT` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  ADD CONSTRAINT `FR_QUESTION_MEMBER` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`);

--
-- Các ràng buộc cho bảng `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `image` (`image_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
