SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`
(
  `txhash`        char(64) NOT NULL,
  `time`          datetime,
  `amount`        float,
  `feeperbyte`        float,
  `feeperweight`        float,
  `fees`        float,
  `weight`        smallint ,
  `totaloutput`        float,
  `totalinput`        float,
  `size`          smallint ,
  `confirmations`          smallint ,
  `visualize`          varchar(255) ,
  `estimated`          varchar(255) ,
  `blockhash`     char(64) NOT NULL,
  `scripts`          varchar(255),
  PRIMARY KEY (`txhash`),
  index `idx_time` (`time`),
  index `idx_blockhash` (`blockhash`)


) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
