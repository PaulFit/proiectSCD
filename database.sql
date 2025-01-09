CREATE DATABASE delivery_system;
USE delivery_system;

CREATE TABLE roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE user_roles (
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);
CREATE TABLE packages (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    status ENUM('Pending', 'In Progress', 'Delivered') NOT NULL DEFAULT 'Pending',
    courier_id INT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (courier_id) REFERENCES users(id) ON DELETE SET NULL
);
INSERT INTO roles (name) VALUES ('ADMIN'), ('MANAGER'), ('COURIER');
INSERT INTO users (username, password, email) VALUES
('admin', 'encrypted_password1', 'admin@example.com'),
('manager', 'encrypted_password2', 'manager@example.com'),
('courier', 'encrypted_password3', 'courier@example.com');
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1), -- Admin
(2, 2), -- Manager
(3, 3); -- Courier