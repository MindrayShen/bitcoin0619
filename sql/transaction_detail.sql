SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for transaction_detail
-- ----------------------------
DROP TABLE IF EXISTS `transaction_detail`;
CREATE TABLE `transaction_detail`
(
  `tx_detail_id` bigint NOT NULL auto_increment,
  `address`      varchar(100),
  `amount`       float ,
  `type`         tinyint,
  `txhash`       char(64),
  `notransactios`         int,
  `totalreceived`         float,
  `finalbalance`         float,
  `transactionaddress`         varchar ,
  PRIMARY KEY (`tx_detail_id`),
  index `idx_address` (`address`),
  index `idx_txhash` (`txhash`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
