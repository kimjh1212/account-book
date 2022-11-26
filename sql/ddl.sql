
CREATE DATABASE portfolio;

CREATE TABLE portfolio.account_book(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`accountBookTypeId` bigint(10) NOT NULL COMMENT '통장 타입 ID',
`name` varchar(255) NOT NULL COMMENT '통장 이름',
`created_at` datetime(6) NOT NULL COMMENT 'createdAt',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `account_book_idx01` (`updated_at`),
KEY `account_book_idx02` (`updated_at`),
KEY `account_book_idx03` (`accountBookTypeId`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;


CREATE TABLE portfolio.account_book_item_put_log(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`account_book_id` bigint(10) NOT NULL COMMENT 'AccountBook 엔티티 Id',
`work_type` varchar(10) NOT NULL COMMENT '이동 타입: 입금/출금/이자',
`put_price_sum` DECIMAL(16,2) NOT NULL COMMENT '변동 금액',
`created_at` datetime(6) NOT NULL COMMENT 'created_at',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `account_book_put_log_idx01` (`created_at`),
KEY `account_book_put_log_idx02` (`updated_at`),
KEY `account_book_put_log_idx03` (`account_book_id`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;


CREATE TABLE portfolio.account_book_type(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`name` varchar(30) NOT NULL COMMENT '상품 이름',
`bank_name` varchar(30) NOT NULL COMMENT '은행 이름',
`interest` DECIMAL(10,2) COMMENT '금리',
`active` boolean COMMENT '단종 여부',
`created_at` datetime(6) NOT NULL COMMENT 'createdAt',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `account_book_type_idx01` (`created_at`),
KEY `account_book_type_idx02` (`updated_at`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;
