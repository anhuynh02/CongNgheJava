-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2022 at 12:59 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuahangthucung`
--
CREATE DATABASE IF NOT EXISTS `cuahangthucung` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `cuahangthucung`;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `purchased` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `user_id`, `total`, `purchased`) VALUES
(1, 1, 11800000, 1),
(2, 2, 0, 0),
(3, 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `bill_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`id`, `product_id`, `quantity`, `bill_id`) VALUES
(19, 1, 2, 2),
(20, 2, 2, 2),
(27, 2, 1, 1),
(28, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`, `description`) VALUES
(1, 'cat', 'Thú cưng là mèo.'),
(2, 'dog', 'Thú cưng là chó.'),
(3, 'food', 'Đồ ăn cho chó và mèo'),
(4, 'toy', 'Đồ chơi cho thú cưng');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `vote` int(11) NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `vote`, `image`, `category_id`) VALUES
(1, 'Mèo Xiêm', 2800000, 'Một trong những loài mèo đầu tiên của mèo lông ngắn phương Đông được công nhận', 4, './images/cat/meoxiem.jpg', 1),
(2, 'Chó Alaska', 9000000, 'Chó Alaska hay Alaska Malamute hoặc Mahlemuts là một giống chó kéo xe ở Alaska', 4, './images/dog/alaska.jpg', 2),
(3, 'Royal Canin Kitten', 115000, 'Thức ăn cho mèo con ROYAL CANIN Kitten bao gồm protein từ lòng trắng trứng + Probiotic, chất chống o', 4, './images/food/thucan1.jpg', 3),
(4, 'Chuông cho chó mèo nhiều sắc màu', 10000, 'Chuông cho chó mèo nhiều sắc màu hay còn được gọi là lục lạc. Với đầy đủ các sắc màu và kích cỡ khác', 4, './images/toy/chuong.jpg', 4),
(5, 'Mèo Anh lông ngắn', 10000000, 'British Shorthair là giống mèo cảnh cổ của Vương quốc Anh. Chúng đã có quá trình sinh sống và phát t', 4, './images/cat/anhlongngan.jpg', 1),
(6, 'Mèo Anh lông dài', 15000000, 'British Longthair là giống mèo cảnh cổ của Vương quốc Anh. Chúng đã có quá trình sinh sống và phát t', 4, './images/cat/meoanhlongdai.jpg', 1),
(7, 'Mèo Munchkin', 5000000, 'Mèo Munchkin là một giống mèo rất mới trên thế giới. Chúng mới chỉ bắt đầu được lai tạo và phát triể', 4, './images/cat/meomunchkin.jpg', 1),
(8, 'Mèo tai cụp', 20000000, 'Ngày nay, mèo Scottish Fold được hầu hết các hiệp hội mèo lớn như: Tica, Cfa, Aace, Acfa/Caa công nh', 4, './images/cat/meoscottish.jpg', 1),
(9, 'Mèo Bengal', 30000000, 'Mèo Bengal không phải là một \"quý cô\" thanh lịch, tinh tế, thướt tha dịu dàng như hầu hết giống mèo ', 4, './images/cat/meobengal.png', 1),
(10, 'Mèo Toyer', 10000000, 'Mèo Toyger với vằn hổ ấn tượng. Toyger được lai tạo để giống với những con hổ trong tự nhiên nhất, ', 4, './images/cat/meotoyger.jpg', 1),
(11, 'Mèo Maine Coon', 50000000, 'Mèo Maine Coon hay còn gọi là mèo Mỹ lông dài là một trong số những giống mèo hiếm, được săn đón nhi', 4, './images/cat/meomainecoon.jpg', 1),
(12, 'Mèo Ragdoll', 10000000, 'Mèo Ragdoll là giống mèo lông dài, mắt xanh, có bộ lông hai màu tương phản rất thu hút. Ngoài ra giố', 4, './images/cat/meoragdoll.jpg', 1),
(13, 'Mèo Ba Tư', 15000000, 'Mèo Ba tư (mèo Persian) là giống mèo có nguồn gốc từ xứ sở “nghìn lẻ một đêm” huyền thoại. Giống mèo', 4, './images/cat/meobatu.jpg', 1),
(14, 'Mèo không lông Sphynx', 30000000, 'Mặc dù không có bộ lông dày mềm mượt đầy màu sắc như hầu hết các giống mèo cảnh khác, nhưng mèo khôn', 4, './images/cat/meosphynx.jpg', 1),
(15, 'Mèo chân ngắn tai cụp', 20000000, 'Mèo tai cụp hay còn gọi là là mèo Scottish Fold. Chỉ cần nghe tên, chúng ta đã biết chúng đến từ đất', 4, './images/cat/meochanngan.jpg', 1),
(16, 'Chó Bull Pháp', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chobull.png', 2),
(17, 'Pug mặt xệ đen', 15000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chopug.png', 2),
(18, 'Chó Chow Chow', 10000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chochow.png', 2),
(19, 'Chó Border Collie', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/choborder.png', 2),
(20, 'Chó Shiba Inu', 10000000, ' Giống: chó Shiba Inu Nhật Bản.', 4, './images/dog/choinu.png', 2),
(21, 'Chó Poodle Tiny', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chopoodle.png', 2),
(22, 'Chó Basenji', 5000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chobasejin.png', 2),
(23, 'Chó Corgi Pembroke', 20000000, 'Giống: chó Corgi Pembroke.', 4, './images/dog/chocorgi.png', 2),
(24, 'Chó Bichon Frise', 10000000, 'Giống: chó Bichons Frise.', 4, './images/dog/chobichon.png', 2),
(25, 'Chó Rottweiler', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt ', 4, './images/dog/chorottweiler.png', 2),
(26, 'Chó Phốc Sóc Pomeranian', 10000000, 'Giống: chó Pomeranian (Phốc sóc, Pom).', 4, './images/dog/chophoc.png', 2),
(27, 'Hạt Royal Cannin Mother & Baby Cat bịch 400g', 100000, 'Thành phần: Protein gia cầm, chất béo động vật, bột bắp, gạo, protein thực vật*, protein động vật, m', 4, './images/food/royalmother.png', 3),
(28, 'Hạt Royal Cannin Second Age Kitten 2kg', 400000, 'Thành phần: Protein gia cầm, gạo, protein thực vật*, chất béo động vật, bột bắp, protein động vật, b', 4, './images/food/royalsecond.jpg', 3),
(29, 'Hạt Royal Canin Regular Fit32 2kg', 400000, 'Thành phần: Protein gia cầm, gạo, lúa mì, bắp, chất béo động vật, protein thịt heo*, xơ thực vật, bộ', 4, './images/food/royalcanin.jpg', 3),
(30, 'Hạt Royal Canin Adult British Shorthair 2kg', 400000, 'thành phần: Protein gia cầm đã khử nước, gạo, protein thực vật cô lập *, mỡ động vật, ngô, protein đ', 4, './images/food/royalaldult.jpg', 3),
(31, 'Thức ăn cho chó trưởng thành mọi giống Equilibrio ', 300000, 'Thịt gà rút xương, bột gia cầm, bột cá, gạo nấu bia, ngô vàng nghiền, gluten ngô, mỡ gia cầm ( được ', 4, './images/food/breedadult.jpg', 3),
(32, 'Hạt Dog Mania Cho Chó Trưởng Thành 3kg', 280000, 'hHạt Dog Mania Cho Chó Trưởng Thành là loại thức ăn khô dạng hạt tiện lợi, phù hợp với khẩu vị của h', 4, './images/food/mania.jpg', 3),
(33, 'Hạt Smartheart Adult Roast Beef Flavor hương thịt ', 100000, 'Hạt Smartheart Adult Roast Beef Flavor hương thịt bò nướng là loại thức ăn khô dạng hạt chuyên dụng ', 4, './images/food/adultroast.jpg', 3),
(34, 'Hạt Nature’s Kitchen xương khớp bịch 2kg cho chó', 360000, 'Nature’s Kitchen được sản xuất trên dây chuyền công nghệ hiện đại. Với những nguyên liệu chất lượng ', 4, './images/food/kitchen.jpg', 3),
(35, 'Pate Pedigree bịch 80g cho chó con vị gà gan trứng', 16000, 'Pate Pedigree bịch 80g cho chó con vị gà gan trứng và rau được sản xuất trên dây chuyền công nghệ hi', 4, './images/food/pate.jpg', 3),
(36, 'Hạt Royal Canin Persian Kitten 2kg', 400000, 'Protein gia cầm, gạo, chất béo động vật, bắp, protein thực vật*, protein động vật, xơ thực vật, củ c', 4, './images/food/royalpersian.jpg', 3),
(37, 'Dầu Thơm khử mùi và mềm lông Forcans', 200000, 'Dầu Thơm khử mùi và mềm lông Forcans là sản phẩm chuyên dùng khử mùi và giúp mượt mà lông.', 4, './images/toy/dauthom.jpg', 4),
(38, 'Ổ nệm trong suốt cho mèo', 400000, 'Ổ nệm trong suốt cho mèo', 4, './images/toy/onem.jpg', 4),
(39, 'Bàn cào móng mèo D4', 200000, 'Bàn cào móng mèo D4 giúp móng mèo luôn chắc khỏe, tránh thiệt hại các vật dụng trong nhà. Với chất l', 4, './images/toy/bancao.jpg', 4),
(40, 'Trụ cào móng cho mèo kèm đồ chơi', 400000, 'Trụ cào móng cho mèo kèm đồ chơi được làm từ thừng sisal, sisal là vật liệu rất chắc, bền được làm t', 4, './images/toy/trucao.jpg', 4),
(41, 'Vòng cổ cho mèo Ferplast Fantasia', 20000, '. Trong suốt 50 năm, Ferplast đã tham gia vào nghiên cứu và tạo ra các sản phẩm sáng tạo, an toàn.', 4, './images/toy/vongco.jpg', 4),
(42, 'Đồ chơi bóng in hình bàn chân size M', 20000, 'Đồ chơi bóng in hình bàn chân size M là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt', 4, './images/toy/banchan.jpg', 4),
(43, 'Đồ chơi bóng mặt chó size L', 45000, 'Đồ chơi bóng mặt chó size L là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt mắt, đán', 4, './images/toy/matcho.jpg', 4),
(44, 'Đồ chơi xương gặm in hình bàn chân', 20000, 'Đồ chơi xương gặm in hình bàn chân là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt m', 4, './images/toy/xuong.jpg', 4);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(80) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`, `description`) VALUES
(1, 'admin', 'Quản trị viên quản lý hệ thống'),
(2, 'staff', 'Nhân viên quản lý kho xuất nhập hàng'),
(3, 'customer', 'Khách hàng sử dụng dịch vụ của hệ thống');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `phone` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `enable` tinyint(1) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `phone`, `name`, `username`, `password`, `enable`, `role_id`) VALUES
(1, '0700000001', 'Admin', 'admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 1),
(2, '0700000010', 'Lê Khánh Văn', 'staff', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 2),
(3, '0700000020', 'Liễu Duy Ngôn', 'staffTemp', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 2),
(4, '0700000002', 'Trần Văn A', 'customer', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqhq5aolak9ku5x5mx11cpjad9` (`user_id`);

--
-- Indexes for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeolgwyayei3o80bb7rj7t207q` (`bill_id`),
  ADD KEY `FKe7fmo7042u349ftue4g4oeiuy` (`product_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD UNIQUE KEY `username` (`username`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill`
--
ALTER TABLE `bill`
  ADD CONSTRAINT `FKqhq5aolak9ku5x5mx11cpjad9` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `bill_detail`
--
ALTER TABLE `bill_detail`
  ADD CONSTRAINT `FKe7fmo7042u349ftue4g4oeiuy` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKeolgwyayei3o80bb7rj7t207q` FOREIGN KEY (`bill_id`) REFERENCES `bill` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
