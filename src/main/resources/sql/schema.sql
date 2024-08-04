CREATE TABLE `crypto-automation`.`report_histories`
(
    `id` INT NOT NULL AUTO_INCREMENT,
    `market` VARCHAR(100) NOT NULL,
    `price` VARCHAR(1000) NOT NULL,
    `reproted_at` DATETIME NOT NULL,
    PRIMARY KEY(`id`)
);