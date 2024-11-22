CREATE DATABASE IF NOT EXISTS `labanca`;

USE `labanca`;
CREATE TABLE results (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         n INT,
                         value VARCHAR(255),
                         created_at DATETIME(6),
                         updated_at DATETIME(6),
                         PRIMARY KEY (id)
) ENGINE=InnoDB;

CREATE TABLE fibonacci_query_statistics (
                                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                            n INT NOT NULL UNIQUE,
                                            query_count INT NOT NULL DEFAULT 1,
                                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                            updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);