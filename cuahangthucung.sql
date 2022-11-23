SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `cuahangthucung`
--

CREATE TABLE user_role(
    role_id INT NOT NULL,
    role_name VARCHAR(30) NOT NULL,
	PRIMARY KEY (role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE app_user(
    username VARCHAR(36) collate utf8_unicode_ci NOT NULL,
    password VARCHAR(128) collate utf8_unicode_ci NOT NULL,
    enable BIT NOT NULL,
	role_id INT NOT NULL,
	PRIMARY KEY (username),
	FOREIGN KEY (role_id) REFERENCES user_role(role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO user_role(role_id, role_name) VALUES
(1, 'admin'), (2, 'staff'), (3, 'user');

INSERT INTO app_user(username, password, enable, role_id) VALUES
('admin', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 1),
('user', '$2a$12$6s1OGykfx.oiHzzAs9wQCOnHAQ49W5cHEasOFi6jSSu91INSZZaLy', 1, 3);