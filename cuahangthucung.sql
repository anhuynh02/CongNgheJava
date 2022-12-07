SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cuahangthucung`
--

CREATE DATABASE IF NOT EXISTS `cuahangthucung` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `cuahangthucung`;

-- --------------------------------------------------------

--
-- Table: `category`
--

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) COLLATE utf8_unicode_ci NOT NULL,
  description VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO category (id, name, description) VALUES
(1, 'cat', 'Thú cưng là mèo.'),
(2, 'dog', 'Thú cưng là chó.'),
(3, 'food', 'Đồ ăn cho chó và mèo'),
(4, 'toy', 'Đồ chơi cho thú cưng');

-- --------------------------------------------------------

--
-- Table: `product`
--

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) COLLATE utf8_unicode_ci NOT NULL,
  price INT NOT NULL,
  description VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
  vote INT NOT NULL,
  `image` VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
  category_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO product (id, name, price, description, vote, `image`, category_id) VALUES
(1, 'Mèo Xiêm', 2800000, 'Một trong những loài mèo đầu tiên của mèo lông ngắn phương Đông được công nhận', 4, './images/cat/meoxiem.jpg', 1),
(2, 'Chó Alaska', 9000000, 'Chó Alaska hay Alaska Malamute hoặc Mahlemuts là một giống chó kéo xe ở Alaska', 4, './images/dog/alaska.jpg', 2),
(3, 'Royal Canin Kitten', 115000, 'Thức ăn cho mèo con ROYAL CANIN Kitten bao gồm protein từ lòng trắng trứng + Probiotic, chất chống oxy hóa giúp nâng cao sức khỏe', 4, './images/food/thucan1.jpg', 3),
(4, 'Đồ chơi tạm', 100000, 'Placeholder', 4, './images/toy/temp', 4);

-- --------------------------------------------------------

--
-- Table: `role`
--

CREATE TABLE role (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) COLLATE utf8_unicode_ci NOT NULL,
  description VARCHAR(80) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO role (id, name, description) VALUES
(1, 'admin', 'Quản trị viên quản lý hệ thống'),
(2, 'staff', 'Nhân viên quản lý kho xuất nhập hàng'),
(3, 'customer', 'Khách hàng sử dụng dịch vụ của hệ thống');

-- --------------------------------------------------------

--
-- Table: `user`
--

CREATE TABLE `user`
(
    phone VARCHAR(13) collate utf8_unicode_ci NOT NULL UNIQUE,
	name VARCHAR(150) collate utf8_unicode_ci NOT NULL,
    username VARCHAR(36) collate utf8_unicode_ci NOT NULL,
    password VARCHAR(128) collate utf8_unicode_ci NOT NULL,
    enable BIT NOT NULL,
	role_id INT collate utf8_unicode_ci NOT NULL,
	PRIMARY KEY (username),
	FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `user` (phone, name, username, password, enable, role_id) VALUES
('0700000001', 'Admin', 'admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 1),
('0700000010', 'Lê Khánh Văn', 'staff', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 2),
('0700000020', 'Liễu Duy Ngôn', 'staffTemp', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 2),
('0700000002', 'Trần Văn A', 'customer', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 3);

-- --------------------------------------------------------