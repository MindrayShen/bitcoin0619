SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for block
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
  `blockhash`  char(64) NOT NULL,
  `height`     int NOT NULL,
  `time`       datetime,
  `transactions`     smallint,
  `miner`       varchar(255),
  `size`       float,
  `outputtotal`     float,
  `merkleroot` char(64),
  `estimated`     float,
  `fees`     float,
  `difficulty` double,
  `weight`     float,
  `bits`     float,
  `version`       varchar(255),
  `nonce`     int,
  `next_block` char(64),
  `prev_block` char(64),
  `blockreward`     float,
  PRIMARY KEY (`blockhash`),
  index `idx_height` (`height`),
  index `idx_time` (`time`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;