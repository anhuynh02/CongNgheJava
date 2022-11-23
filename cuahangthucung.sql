SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cuahangthucung`
--

CREATE TABLE `user`
(
    username VARCHAR(36) collate utf8_unicode_ci NOT NULL,
    password VARCHAR(128) collate utf8_unicode_ci NOT NULL,
    enable BIT NOT NULL,
	role VARCHAR(30) collate utf8_unicode_ci NOT NULL,
	PRIMARY KEY (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `user`(username, password, enable, role) VALUES
('admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 'admin'),
('user', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 'user');