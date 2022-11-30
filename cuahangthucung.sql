SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cuahangthucung`
--

--
-- Table: `category`
--

CREATE TABLE category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) COLLATE utf8_unicode_ci NOT NULL,
  description VARCHAR(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

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
    username VARCHAR(36) collate utf8_unicode_ci NOT NULL,
    password VARCHAR(128) collate utf8_unicode_ci NOT NULL,
    enable BIT NOT NULL,
	role_id INT collate utf8_unicode_ci NOT NULL,
	PRIMARY KEY (username),
	FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `user` (username, password, enable, role_id) VALUES
('admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 1),
('customer', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 3);

-- --------------------------------------------------------