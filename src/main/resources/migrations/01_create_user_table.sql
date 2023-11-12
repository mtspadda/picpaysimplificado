CREATE TABLE user (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    document VARCHAR(255) UNIQUE,
    email VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    balance DECIMAL(19, 2),
    user_type VARCHAR(255)
);