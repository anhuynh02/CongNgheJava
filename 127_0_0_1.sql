-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2022 at 06:51 AM
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
CREATE DATABASE IF NOT EXISTS `cuahangthucung` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `cuahangthucung`;

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `id` int(11) NOT NULL,
  `purchased` bit(1) NOT NULL,
  `total` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `date` char(30) NOT NULL DEFAULT current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`id`, `purchased`, `total`, `user_id`, `date`) VALUES
(2, b'1', 55000000, 1, '2022-11-16'),
(3, b'0', 0, 3, '2022-10-17'),
(4, b'0', 49000000, 2, '2022-9-17'),
(5, b'1', 18100000, 1, '2022-8-17'),
(6, b'1', 30600000, 1, '2022-8-17'),
(7, b'1', 40100000, 1, '2022-8-17'),
(8, b'1', 15016000, 1, '2022-7-17'),
(9, b'1', 10065000, 1, '2022-7-17'),
(10, b'1', 35000000, 1, '2022-12-17'),
(11, b'1', 50000000, 1, '2022-12-17'),
(12, b'0', 0, 1, '2022-12-17');

-- --------------------------------------------------------

--
-- Table structure for table `bill_detail`
--

CREATE TABLE `bill_detail` (
  `id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `bill_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_detail`
--

INSERT INTO `bill_detail` (`id`, `quantity`, `bill_id`, `product_id`) VALUES
(1, 1, 1, 16),
(2, 1, 1, 17),
(3, 1, 1, 19),
(4, 1, 1, 21),
(5, 2, 2, 16),
(6, 2, 4, 16),
(7, 1, 4, 2),
(8, 1, 2, 17),
(9, 1, 5, 1),
(10, 1, 5, 13),
(11, 1, 5, 31),
(12, 1, 6, 14),
(13, 1, 6, 36),
(14, 1, 6, 37),
(15, 1, 7, 33),
(16, 2, 7, 19),
(17, 1, 8, 18),
(18, 1, 8, 7),
(19, 1, 8, 35),
(20, 1, 9, 44),
(21, 1, 9, 43),
(22, 1, 9, 26),
(23, 1, 10, 17),
(24, 1, 10, 16),
(25, 1, 11, 23),
(26, 2, 11, 17);

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
(1, 'Mèo', 'Thú cưng là mèo.'),
(2, 'Chó', 'Thú cưng là chó.'),
(3, 'Đồ ăn', 'Đồ ăn cho chó và mèo'),
(4, 'Đồ chơi', 'Đồ chơi cho thú cưng');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `vote` int(11) NOT NULL,
  `image` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `description`, `vote`, `image`, `category_id`) VALUES
(1, 'Mèo Xiêm', 2800000, 'Một trong những loài mèo đầu tiên của mèo lông ngắn phương Đông được công nhận', 4, './images/product/meoxiem.jpg', 1),
(2, 'Chó Alaska', 9000000, 'Chó Alaska hay Alaska Malamute hoặc Mahlemuts là một giống chó kéo xe ở Alaska', 4, './images/product/alaska.jpg', 2),
(3, 'Royal Canin Kitten', 115000, 'Thức ăn cho mèo con ROYAL CANIN Kitten bao gồm protein từ lòng trắng trứng + Probiotic, chất chống o', 4, './images/product/thucan1.jpg', 3),
(5, 'Mèo Anh lông ngắn', 10000000, 'British Shorthair là giống mèo cảnh cổ của Vương quốc Anh. Chúng đã có quá trình sinh sống và phát triển trên quần đảo Anh quốc từ hàng ngàn năm.', 4, './images/product/anhlongngan.jpg', 1),
(6, 'Mèo Anh lông dài', 15000000, 'British Longthair là giống mèo cảnh cổ của Vương quốc Anh. Chúng đã có quá trình sinh sống và phát triển trên quần đảo Anh quốc từ hàng ngàn năm.', 4, './images/product/meoanhlongdai.jpg', 1),
(7, 'Mèo Munchkin', 5000000, 'Mèo Munchkin là một giống mèo rất mới trên thế giới. Chúng mới chỉ bắt đầu được lai tạo và phát triển thành giống hoàn chỉnh một cách chính thức từ năm 1983.', 4, './images/product/meomunchkin.jpg', 1),
(8, 'Mèo tai cụp', 20000000, 'Ngày nay, mèo Scottish Fold được hầu hết các hiệp hội mèo lớn như: Tica, Cfa, Aace, Acfa/Caa công nhận tiêu chuẩn giống chính thức. Mèo tai cụp được nhập khẩu vào Hoa Kỳ năm 1971 và ngày nay được các hiệp hội mèo Bắc Mỹ công nhận.', 4, './images/product/meoscottish.jpg', 1),
(9, 'Mèo Bengal', 30000000, 'Mèo Bengal không phải là một \"quý cô\" thanh lịch, tinh tế, thướt tha dịu dàng như hầu hết giống mèo cảnh khác. Chúng là những \"vận động viên\" nhanh nhẹn, mạnh mẽ cùng sự uyển chuyển, cơ bắp như một chú báo rừng.', 4, './images/product/meobengal.png', 1),
(10, 'Mèo Toyer', 10000000, 'Mèo Toyger với vằn hổ ấn tượng. Toyger được lai tạo để giống với những con hổ trong tự nhiên nhất, nhưng được thu cho nhỏ phù hợp với cuộc sống đô thị hiện đại và thân thiện như mèo nhà.', 4, './images/product/meotoyger.jpg', 1),
(11, 'Mèo Maine Coon', 50000000, 'Mèo Maine Coon hay còn gọi là mèo Mỹ lông dài là một trong số những giống mèo hiếm, được săn đón nhiều nhất và có giá bán cao nhất tại Việt Nam hiện nay. Bên cạnh bộ lông dài, ngoại hình to lớn mang vẻ đẹp huyền bí, quý tộc.', 4, './images/product/meomainecoon.jpg', 1),
(12, 'Mèo Ragdoll', 10000000, 'Mèo Ragdoll là giống mèo lông dài, mắt xanh, có bộ lông hai màu tương phản rất thu hút. Ngoài ra giống mèo Ragdoll rất ngoan hiền và dễ bảo.', 4, './images/product/meoragdoll.jpg', 1),
(13, 'Mèo Ba Tư', 15000000, 'Mèo Ba tư (mèo Persian) là giống mèo có nguồn gốc từ xứ sở “nghìn lẻ một đêm” huyền thoại. Giống mèo này có khuôn mặt tròn trịa, mõm ngắn và bộ lông dài tha thướt tuyệt đẹp. Với nhiều biến thể gồm: mèo Ba tư truyền thống, mèo Exotic (mèo ba tư lông ngắn), mèo Himalayan và mèo Chichilla.', 4, './images/product/meobatu.jpg', 1),
(14, 'Mèo không lông Sphynx', 30000000, 'Mặc dù không có bộ lông dày mềm mượt đầy màu sắc như hầu hết các giống mèo cảnh khác, nhưng mèo không lông Ai Cập Sphynx lại gây ấn tượng mạnh với bạn ngay lần đầu gặp mặt.', 4, './images/product/meosphynx.jpg', 1),
(15, 'Mèo chân ngắn tai cụp', 20000000, 'Mèo tai cụp hay còn gọi là là mèo Scottish Fold. Chỉ cần nghe tên, chúng ta đã biết chúng đến từ đất nước Scotland. Thông thường, việc tạo ra một giống mèo mới phụ thuộc vào một đột biến gen tự nhiên xảy ra bất ngờ ở một con mèo bình thường.', 4, './images/product/meochanngan.jpg', 1),
(16, 'Chó Bull Pháp', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA), bố mẹ nhập.', 4, './images/product/chobull.png', 2),
(17, 'Pug mặt xệ đen', 15000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA).', 4, './images/product/chopug.png', 2),
(18, 'Chó Chow Chow', 10000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA).', 4, './images/product/chochow.png', 2),
(19, 'Chó Border Collie', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA), bố mẹ nhập.', 4, './images/product/choborder.png', 2),
(20, 'Chó Shiba Inu', 10000000, ' Giống: chó Shiba Inu Nhật Bản.', 4, './images/product/choinu.png', 2),
(21, 'Chó Poodle Tiny', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA), bố mẹ nhập.', 4, './images/product/chopoodle.png', 2),
(22, 'Chó Basenji', 5000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA), bố mẹ nhập – sinh sản tại Việt Nam.', 4, './images/product/chobasejin.png', 2),
(23, 'Chó Corgi Pembroke', 20000000, 'Giống: chó Corgi Pembroke.', 4, './images/product/chocorgi.png', 2),
(24, 'Chó Bichon Frise', 10000000, 'Giống: chó Bichons Frise.', 4, './images/product/chobichon.png', 2),
(25, 'Chó Rottweiler', 20000000, 'nhân giống tại Trang trại Dogily Kennel Đà Lạt (thành viên Hiệp hội những người nuôi chó giống Việt Nam – VKA), bố mẹ nhập.', 4, './images/product/chorottweiler.png', 2),
(26, 'Chó Phốc Sóc Pomeranian', 10000000, 'Giống: chó Pomeranian (Phốc sóc, Pom).', 4, './images/product/chophoc.png', 2),
(27, 'Hạt Royal Cannin Mother & Baby Cat bịch 400g', 100000, 'Thành phần: Protein gia cầm, chất béo động vật, bột bắp, gạo, protein thực vật*, protein động vật, men, dầu cá, củ cải đường, xơ thực vật, dầu đậu nành, khoáng chất, fructo-oligo-sacarit (0,35%), men thủy phân (nguồn manno-oligo-sacarit), chiết xuất men (nguồn betaglucan), chiết xuất cúc vạn thọ (nguồn lutein).\r\nPhụ gia dinh dưỡng: Vitamin A, Vitamin D3, Vitamin E, E1 (Sắt), E2 (I ốt), E4 (Đồng), E5 (Mangan), E6 (Kẽm), E8 (Selen) – Phụ gia kỹ thuật: Clinoptilolite – Chất chống oxi hóa – Trên mỗi kg: DHA: 1,87 g.\r\n*L.I.P.: Protein có độ tiêu hóa cao.', 4, './images/product/royalmother.png', 3),
(28, 'Hạt Royal Cannin Second Age Kitten 2kg', 400000, 'Thành phần: Protein gia cầm, gạo, protein thực vật*, chất béo động vật, bột bắp, protein động vật, bột lúa mì, gluten bắp, men, củ cải đường, xơ thực vật, dầu cá, dầu đậu nành, khoáng chất, fructo-oligo-sacarit (0,38%), psyllium, men thủy phân (nguồn manno-oligo-sacarit), chiết xuất men (nguồn betaglucan), chiết xuất cúc vạn thọ (nguồn lutein).\r\nPhụ gia dinh dưỡng: Vitamin A, Vitamin D3, Vitamin E, E1 (Sắt), E2 (I ốt), E4 (Đồng), E5 (Mangan), E6 (Kẽm), E8 (Selen) – Phụ gia kỹ thuật: Clinoptilolite – Chất chống oxi hóa.\r\n*L.I.P.: Protein có độ tiêu hóa cao.', 4, './images/product/royalsecond.jpg', 3),
(29, 'Hạt Royal Canin Regular Fit32 2kg', 400000, 'Thành phần: Protein gia cầm, gạo, lúa mì, bắp, chất béo động vật, protein thịt heo*, xơ thực vật, bột lúa mì, protein động vật, gluten bắp,  men, củ cải đường, dầu đậu nành, dầu cá, khoáng chất, psyllium, men thủy phân (nguồn manno-oligo-sacarit), chiết xuất cúc vạn thọ (nguồn lutein).\r\nPhụ gia dinh dưỡng: Vitamin A, Vitamin D3, E1 (Sắt), E2 (I ốt), E4 (Đồng), E5 (Mangan), E6 (Kẽm), E8 (Selen) – Phụ gia chăn nuôi: Amoni clorua: 5 g – Chất chống oxi hóa.\r\n*L.I.P. : Protein có độ tiêu hóa cao.', 4, './images/product/royalcanin.jpg', 3),
(30, 'Hạt Royal Canin Adult British Shorthair 2kg', 400000, 'thành phần: Protein gia cầm đã khử nước, gạo, protein thực vật cô lập *, mỡ động vật, ngô, protein động vật thủy phân, gluten ngô, bột mì, củ cải đường, sợi thực vật, dầu cá, khoáng chất, dầu đậu nành, men và các bộ phận của chúng, vỏ trấu và hạt (0,5%), fructo-oligo-saccharides, men thủy phân (nguồn gốc của manno-oligosaccharides), chiết xuất men (nguồn betaglucans), dầu borage, chiết xuất cúc vạn thọ (nguồn lutein), động vật giáp xác thủy phân (nguồn glucosamine), sụn thủy phân (nguồn của chondroitin).', 4, './images/product/royalaldult.jpg', 3),
(31, 'Thức ăn cho chó trưởng thành mọi giống Equilibrio ', 300000, 'Thịt gà rút xương, bột gia cầm, bột cá, gạo nấu bia, ngô vàng nghiền, gluten ngô, mỡ gia cầm ( được bảo quản bằng tocopherols hỗn hợp tự nhiên và dầu hương thảo), dầu cá, men bia khô, hạt lanh nghiền, dầu đậu nành, kali clorua, dicalcium phosphate, natri hexametaphosphate, chiết xuấ Yucca (cây ngọc giá), men vi sinh (Probiotic) inulin (Prebiotic), choline clorua, canxi propionate, thịt gà thủy phân, vitamin hỗn hợp, khoáng chelate hỗn hợp.', 4, './images/product/breedadult.jpg', 3),
(32, 'Hạt Dog Mania Cho Chó Trưởng Thành 3kg', 280000, 'hHạt Dog Mania Cho Chó Trưởng Thành là loại thức ăn khô dạng hạt tiện lợi, phù hợp với khẩu vị của hầu hết các giống chó. Giúp chó cưng khỏe mạnh và phát triển toàn diện.', 4, './images/product/mania.jpg', 3),
(33, 'Hạt Smartheart Adult Roast Beef Flavor hương thịt ', 100000, 'Hạt Smartheart Adult Roast Beef Flavor hương thịt bò nướng là loại thức ăn khô dạng hạt chuyên dụng giúp tạo cơ bắp cho các giống chó lớn đang ở độ tuổi chó trưởng thành', 4, './images/product/adultroast.jpg', 3),
(34, 'Hạt Nature’s Kitchen xương khớp bịch 2kg cho chó', 360000, 'Nature’s Kitchen được sản xuất trên dây chuyền công nghệ hiện đại. Với những nguyên liệu chất lượng cao, cân bằng và đa dạng, giúp hỗ trợ vật nuôi phát triển toàn diện, khỏe mạnh.', 4, './images/product/kitchen.jpg', 3),
(35, 'Pate Pedigree bịch 80g cho chó con vị gà gan trứng', 16000, 'Pate Pedigree bịch 80g cho chó con vị gà gan trứng và rau được sản xuất trên dây chuyền công nghệ hiện đại. Với những nguyên liệu chất lượng cao, gia vị được cân bằng hoàn hảo giúp cún cưng ăn ngon miệng và phát triển khỏe mạnh toàn diện.', 4, './images/product/pate.jpg', 3),
(36, 'Hạt Royal Canin Persian Kitten 2kg', 400000, 'Protein gia cầm, gạo, chất béo động vật, bắp, protein thực vật*, protein động vật, xơ thực vật, củ cải đường, men, dầu cái, dầu cá, dầu đậu nành, khoáng chất, psyllium (0,5%), fructo-oligo-sacarit, men thủy phân (nguồn manno-oligo-sacarit), chiết xuất men (nguồn betaglucan), dầu borage, chiết xuất cúc vạn thọ (nguồn lutein).', 4, './images/product/royalpersian.jpg', 3),
(37, 'Dầu Thơm khử mùi và mềm lông Forcans', 200000, 'Dầu Thơm khử mùi và mềm lông Forcans là sản phẩm chuyên dùng khử mùi và giúp mượt mà lông.', 4, './images/product/dauthom.jpg', 4),
(38, 'Ổ nệm trong suốt cho mèo', 400000, 'Ổ nệm trong suốt cho mèo', 4, './images/product/onem.jpg', 4),
(39, 'Bàn cào móng mèo D4', 200000, 'Bàn cào móng mèo D4 giúp móng mèo luôn chắc khỏe, tránh thiệt hại các vật dụng trong nhà. Với chất liệu sisal, bông nhung không tổn thương tới móng mèo. Mèo cưng có thể thoải mái mài móng của mình ở tư thế thoải mái nhất. ', 4, './images/product/bancao.jpg', 4),
(40, 'Trụ cào móng cho mèo kèm đồ chơi', 400000, 'Trụ cào móng cho mèo kèm đồ chơi được làm từ thừng sisal, sisal là vật liệu rất chắc, bền được làm thành dạng dây. Trụ cào móng cho mèo giúp mèo cưng loại bỏ lớp móng cũ, mài móng giảm độ sắc nhọn. Với món đồ chơi này, bạn sẽ không lo đồ đạc trong nhà có các vết xước do móng mèo gây ra. Đặc biệt an toàn, không gây tổn thương cho móng mèo khi cào.', 4, './images/product/trucao.jpg', 4),
(41, 'Vòng cổ cho mèo Ferplast Fantasia', 20000, '. Trong suốt 50 năm, Ferplast đã tham gia vào nghiên cứu và tạo ra các sản phẩm sáng tạo, an toàn. Với phần chất lượng cao nhằm đảm bảo cho sự thoải mái của vật nuôi. Công ty dành nhiều khoản đầu tư đáng kể cho các công trình nghiên cứu những công nghệ tiên tiến có thể áp dụng vào sản xuất.', 4, './images/product/vongco.jpg', 4),
(42, 'Đồ chơi bóng in hình bàn chân size M', 20000, 'Đồ chơi bóng in hình bàn chân size M là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt mắt, đáng yêu, kích thước vừa phải. Có độ bền cao và an toàn cho sức khỏe cún cưng. Bạn có thể tái sử dụng Đồ chơi bóng in hình bàn chân nhiều lần. ', 4, './images/product/banchan.jpg', 4),
(43, 'Đồ chơi bóng mặt chó size L', 45000, 'Đồ chơi bóng mặt chó size L là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt mắt, đáng yêu, kích thước vừa phải. Có độ bền cao và an toàn cho sức khỏe cún cưng. Bạn có thể tái sử dụng Đồ chơi bóng in hình bàn chân nhiều lần. Sản phẩm phù hợp với mọi giống chó ở mọi lứa tuổi.', 4, './images/product/matcho.jpg', 4),
(44, 'Đồ chơi xương gặm in hình bàn chân', 20000, 'Đồ chơi xương gặm in hình bàn chân là sản phẩm đồ chơi cho chó rất được ưa chuộng bởi thiết kế bắt mắt, đáng yêu, kích thước vừa phải. Có độ bền cao và an toàn cho sức khỏe cún cưng.', 4, './images/product/xuong.jpg', 4),
(45, 'Chuông cho chó mèo nhiều sắc màu\r\n', 10000, 'Chuông cho chó mèo nhiều sắc màu hay còn được gọi là lục lạc. Với đầy đủ các sắc màu và kích cỡ khác nhau. Phù hợp với tất cả các loại giống chó mèo.', 4, './images/product/chuong.jpg', 4),
(46, 'Mèo nhà', 100000, 'Mèo nhà là mèo nhà', 0, './images/product/pet.png', 4);

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
  `phone` varchar(13) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `enable` bit(1) NOT NULL,
  `role_id` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`phone`, `name`, `username`, `password`, `enable`, `role_id`, `id`) VALUES
('0700000001', 'Admin', 'admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', b'1', 1, 1),
('0700000002', 'Trần Văn A', 'customer', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', b'1', 3, 2),
('0700000010', 'Lê Khánh Văn', 'staff', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', b'1', 2, 3),
('0700000020', 'Liễu Duy Ngôn', 'staffTemp', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', b'1', 2, 4),
('1234567890', 'Nguyễn Văn B', 'admin3', '$2a$10$ZXzevJKM8Gfz1GTvfHMja.xcfz8/6J.GlGoe4W8XNmBTs6DcojiVu', b'1', 2, 5);

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
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `phone` (`phone`),
  ADD KEY `role_id` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `bill_detail`
--
ALTER TABLE `bill_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
