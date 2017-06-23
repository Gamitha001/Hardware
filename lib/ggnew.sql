-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sql12179853
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sql12179853` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
-- -----------------------------------------------------
-- Schema sql12179853
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sql12179853
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sql12179853` DEFAULT CHARACTER SET latin1 ;
USE `sql12179853` ;

-- -----------------------------------------------------
-- Table `sql12179853`.`user_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`user_status` (
  `iduser_status` INT(11) NOT NULL COMMENT '',
  `user_status_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`iduser_status`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `user_username` VARCHAR(45) NOT NULL COMMENT '',
  `user_password` VARCHAR(45) NOT NULL COMMENT '',
  `recovery_password` VARCHAR(45) NOT NULL COMMENT '',
  `user_email` VARCHAR(45) NOT NULL COMMENT '',
  `user_status_iduser_status` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`iduser`)  COMMENT '',
  INDEX `fk_user_user_status1_idx` (`user_status_iduser_status` ASC)  COMMENT '',
  CONSTRAINT `fk_user_user_status1`
    FOREIGN KEY (`user_status_iduser_status`)
    REFERENCES `sql12179853`.`user_status` (`iduser_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`supplier` (
  `idsupplier` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `supplier_name` VARCHAR(45) NOT NULL COMMENT '',
  `supplier_email` VARCHAR(45) NOT NULL COMMENT '',
  `supplier_address_no` VARCHAR(45) NOT NULL COMMENT '',
  `supplier_address_street1` VARCHAR(45) NOT NULL COMMENT '',
  `supplier_address_street2` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `supplier_address_city` VARCHAR(45) NOT NULL COMMENT '',
  `supplier_office_tp` VARCHAR(12) NOT NULL COMMENT '',
  `supplier_contact_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `supplier_contact_tp` VARCHAR(12) NULL DEFAULT NULL COMMENT '',
  `supplier_fax` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `supplier_status` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idsupplier`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`grn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`grn` (
  `idgrn` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `grn_showid` VARCHAR(5) NOT NULL COMMENT '',
  `grn_date` DATE NOT NULL COMMENT '',
  `grn_time` TIME NOT NULL COMMENT '',
  `supplier_idsupplier` INT(11) NOT NULL COMMENT '',
  `grn_subtotal` DOUBLE NOT NULL COMMENT '',
  `grn_discount` DOUBLE NOT NULL COMMENT '',
  `grn_nettotal` DOUBLE NOT NULL COMMENT '',
  `grn_status` INT(11) NOT NULL COMMENT '',
  `user_iduser` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idgrn`)  COMMENT '',
  INDEX `fk_supplier_has_stock_supplier1_idx` (`supplier_idsupplier` ASC)  COMMENT '',
  INDEX `fk_grn_user1_idx` (`user_iduser` ASC)  COMMENT '',
  CONSTRAINT `fk_grn_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `sql12179853`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_supplier_has_stock_supplier1`
    FOREIGN KEY (`supplier_idsupplier`)
    REFERENCES `sql12179853`.`supplier` (`idsupplier`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`brand_product_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`brand_product_status` (
  `idbrand_product_status` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `brand_product_status_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idbrand_product_status`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`brand` (
  `idbrand` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `brand_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `brand_product_status_idbrand_product_status` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idbrand`)  COMMENT '',
  INDEX `fk_brand_brand_product_status1_idx` (`brand_product_status_idbrand_product_status` ASC)  COMMENT '',
  CONSTRAINT `fk_brand_brand_product_status1`
    FOREIGN KEY (`brand_product_status_idbrand_product_status`)
    REFERENCES `sql12179853`.`brand_product_status` (`idbrand_product_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`category` (
  `idcategory` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `category_name` VARCHAR(45) NOT NULL COMMENT '',
  `category_description` VARCHAR(500) NOT NULL COMMENT '',
  PRIMARY KEY (`idcategory`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`product_stock_code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`product_stock_code` (
  `idproduct_stock_code` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `product_stock_code_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idproduct_stock_code`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`selling_price_change_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`selling_price_change_status` (
  `idselling_price_change_status` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `selling_price_change_status_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idselling_price_change_status`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`unit` (
  `idunit` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `unit_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idunit`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`product` (
  `idproduct` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `product_code` VARCHAR(45) NOT NULL COMMENT '',
  `product_name` VARCHAR(70) NOT NULL COMMENT '',
  `product_description` VARCHAR(500) NOT NULL COMMENT '',
  `product_status` INT(11) NOT NULL COMMENT '',
  `category_idcategory` INT(11) NOT NULL COMMENT '',
  `unit_idunit` INT(11) NOT NULL COMMENT '',
  `brand_idbrand` INT(11) NOT NULL COMMENT '',
  `selling_price_change_status_idselling_price_change_status` INT(11) NOT NULL COMMENT '',
  `mix_product_stock_code_idproduct_stock_code` INT(11) NOT NULL COMMENT '',
  `product_min_stock_qty` DOUBLE NOT NULL COMMENT '',
  PRIMARY KEY (`idproduct`)  COMMENT '',
  INDEX `fk_category_idx` (`category_idcategory` ASC)  COMMENT '',
  INDEX `fk_brand_idx` (`brand_idbrand` ASC)  COMMENT '',
  INDEX `fk_selliing_price_change_idx` (`selling_price_change_status_idselling_price_change_status` ASC)  COMMENT '',
  INDEX `fk_product_stock_code_idx` (`mix_product_stock_code_idproduct_stock_code` ASC)  COMMENT '',
  INDEX `fk_unit_idx` (`unit_idunit` ASC)  COMMENT '',
  CONSTRAINT `fk_brand`
    FOREIGN KEY (`brand_idbrand`)
    REFERENCES `sql12179853`.`brand` (`idbrand`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_category`
    FOREIGN KEY (`category_idcategory`)
    REFERENCES `sql12179853`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_stock_code`
    FOREIGN KEY (`mix_product_stock_code_idproduct_stock_code`)
    REFERENCES `sql12179853`.`product_stock_code` (`idproduct_stock_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_selliing_price_change`
    FOREIGN KEY (`selling_price_change_status_idselling_price_change_status`)
    REFERENCES `sql12179853`.`selling_price_change_status` (`idselling_price_change_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_unit`
    FOREIGN KEY (`unit_idunit`)
    REFERENCES `sql12179853`.`unit` (`idunit`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`stock` (
  `idstock` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `product_idproduct` INT(11) NOT NULL COMMENT '',
  `stock_product_code` VARCHAR(45) NOT NULL COMMENT '',
  `stock_qty` DOUBLE NOT NULL COMMENT '',
  `stock_buyingprice` DOUBLE NOT NULL COMMENT '',
  `stock_selling_price` DOUBLE NOT NULL COMMENT '',
  `grn_idgrn` INT(11) NOT NULL COMMENT '',
  `stock_status` INT(11) NOT NULL COMMENT '',
  `stock_discount_one` DOUBLE NOT NULL COMMENT '',
  `stock_discount_two` DOUBLE NOT NULL COMMENT '',
  PRIMARY KEY (`idstock`)  COMMENT '',
  INDEX `fk_stock_product1_idx` (`product_idproduct` ASC)  COMMENT '',
  INDEX `fk_stock_grn1_idx` (`grn_idgrn` ASC)  COMMENT '',
  CONSTRAINT `fk_stock_grn1`
    FOREIGN KEY (`grn_idgrn`)
    REFERENCES `sql12179853`.`grn` (`idgrn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stock_product1`
    FOREIGN KEY (`product_idproduct`)
    REFERENCES `sql12179853`.`product` (`idproduct`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`stock_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`stock_items` (
  `idstock_items` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `stock_idstock` INT(11) NOT NULL COMMENT '',
  `stock_item_code` VARCHAR(45) NOT NULL COMMENT '',
  `stock_item_remain_qty` DOUBLE NULL COMMENT '',
  PRIMARY KEY (`idstock_items`)  COMMENT '',
  INDEX `fk_stock_items_stock_idx` (`stock_idstock` ASC)  COMMENT '',
  CONSTRAINT `fk_stock_items_stock`
    FOREIGN KEY (`stock_idstock`)
    REFERENCES `sql12179853`.`stock` (`idstock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sql12179853` ;

-- -----------------------------------------------------
-- Table `sql12179853`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`customer` (
  `idcustomer` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `customer_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idcustomer`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`customer_company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`customer_company` (
  `idcustomer_company` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `customer_company_office_tp` VARCHAR(12) NOT NULL COMMENT '',
  `customer_company_con_person` VARCHAR(45) NOT NULL COMMENT '',
  `customer_company_con_tp` VARCHAR(12) NULL DEFAULT NULL COMMENT '',
  `customer_company_credit_week_count` INT(11) NOT NULL COMMENT '',
  `customer_company_status` INT(11) NOT NULL COMMENT '',
  `customer_idcustomer` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idcustomer_company`)  COMMENT '',
  INDEX `fk_customer_company_customer1_idx` (`customer_idcustomer` ASC)  COMMENT '',
  CONSTRAINT `fk_customer_company_customer1`
    FOREIGN KEY (`customer_idcustomer`)
    REFERENCES `sql12179853`.`customer` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`return_stock_reason`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`return_stock_reason` (
  `idreturn_stock_reason` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `return_stock_reason_name` VARCHAR(45) NOT NULL COMMENT '',
  `return_stock_reason_description` VARCHAR(500) NOT NULL COMMENT '',
  PRIMARY KEY (`idreturn_stock_reason`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`return_stock_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`return_stock_status` (
  `idreturn_stock_status` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `return_stock_status_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idreturn_stock_status`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`return_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`return_type` (
  `idreturn_type` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `return_type_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idreturn_type`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`order_payment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`order_payment_type` (
  `idorder_payment_type` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_payment_type_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idorder_payment_type`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`order_status` (
  `idorder_status` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_status_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idorder_status`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`order_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`order_type` (
  `idorder_type` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_type_name` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idorder_type`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`order` (
  `idorder` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_date` DATE NOT NULL COMMENT '',
  `order_time` TIME NOT NULL COMMENT '',
  `order_subtotal` DOUBLE NULL DEFAULT NULL COMMENT '',
  `order_discount` DOUBLE NOT NULL COMMENT '',
  `order_nettotal` DOUBLE NOT NULL COMMENT '',
  `order_type_idorder_type` INT(11) NOT NULL COMMENT '',
  `order_payment_type_idorder_payment_type` INT(11) NOT NULL COMMENT '',
  `order_status_idorder_status` INT(11) NOT NULL COMMENT '',
  `user_iduser` INT(11) NOT NULL COMMENT '',
  `customer_idcustomer` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idorder`)  COMMENT '',
  INDEX `fk_order_order_type1_idx` (`order_type_idorder_type` ASC)  COMMENT '',
  INDEX `fk_order_order_payment_type1_idx` (`order_payment_type_idorder_payment_type` ASC)  COMMENT '',
  INDEX `fk_order_order_status1_idx` (`order_status_idorder_status` ASC)  COMMENT '',
  INDEX `fk_order_user1_idx` (`user_iduser` ASC)  COMMENT '',
  INDEX `fk_order_customer1_idx` (`customer_idcustomer` ASC)  COMMENT '',
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_idcustomer`)
    REFERENCES `sql12179853`.`customer` (`idcustomer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_payment_type1`
    FOREIGN KEY (`order_payment_type_idorder_payment_type`)
    REFERENCES `sql12179853`.`order_payment_type` (`idorder_payment_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_status1`
    FOREIGN KEY (`order_status_idorder_status`)
    REFERENCES `sql12179853`.`order_status` (`idorder_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_order_type1`
    FOREIGN KEY (`order_type_idorder_type`)
    REFERENCES `sql12179853`.`order_type` (`idorder_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `sql12179853`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`order_items`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`order_items` (
  `idorder_items` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_item_qty` DOUBLE NOT NULL COMMENT '',
  `order_item_subtotal` DOUBLE NOT NULL COMMENT '',
  `order_item_discount` DOUBLE NOT NULL COMMENT '',
  `order_item_nettotal` DOUBLE NOT NULL COMMENT '',
  `order_idorder` INT(11) NOT NULL COMMENT '',
  `stock_idstock` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idorder_items`)  COMMENT '',
  INDEX `fk_order_items_order1_idx` (`order_idorder` ASC)  COMMENT '',
  INDEX `fk_order_items_stock1_idx` (`stock_idstock` ASC)  COMMENT '',
  CONSTRAINT `fk_order_items_order1`
    FOREIGN KEY (`order_idorder`)
    REFERENCES `sql12179853`.`order` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_items_stock1`
    FOREIGN KEY (`stock_idstock`)
    REFERENCES `sql12179853`.`stock` (`idstock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`customer_return`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`customer_return` (
  `idcustomer_return` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `order_items_idorder_items` INT(11) NOT NULL COMMENT '',
  `customer_return_qty` DOUBLE NOT NULL COMMENT '',
  `return_type_idreturn_type` INT(11) NOT NULL COMMENT '',
  `return_stock_status_idreturn_stock_status` INT(11) NOT NULL COMMENT '',
  `return_stock_reason_idreturn_stock_reason` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idcustomer_return`)  COMMENT '',
  INDEX `fk_customer_returns_order_items1_idx` (`order_items_idorder_items` ASC)  COMMENT '',
  INDEX `fk_customer_return_return_type1_idx` (`return_type_idreturn_type` ASC)  COMMENT '',
  INDEX `fk_customer_return_return_stock_status1_idx` (`return_stock_status_idreturn_stock_status` ASC)  COMMENT '',
  INDEX `fk_customer_return_return_stock_reason1_idx` (`return_stock_reason_idreturn_stock_reason` ASC)  COMMENT '',
  CONSTRAINT `fk_customer_return_return_stock_reason1`
    FOREIGN KEY (`return_stock_reason_idreturn_stock_reason`)
    REFERENCES `sql12179853`.`return_stock_reason` (`idreturn_stock_reason`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_return_return_stock_status1`
    FOREIGN KEY (`return_stock_status_idreturn_stock_status`)
    REFERENCES `sql12179853`.`return_stock_status` (`idreturn_stock_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_return_return_type1`
    FOREIGN KEY (`return_type_idreturn_type`)
    REFERENCES `sql12179853`.`return_type` (`idreturn_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_returns_order_items1`
    FOREIGN KEY (`order_items_idorder_items`)
    REFERENCES `sql12179853`.`order_items` (`idorder_items`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`frame`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`frame` (
  `idframe` INT(11) NOT NULL COMMENT '',
  `frame_name` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idframe`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`return_in_stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`return_in_stock` (
  `idreturn_stock` INT(11) NOT NULL COMMENT '',
  `return_stock_qty` DOUBLE NOT NULL COMMENT '',
  `return_stock_description` VARCHAR(500) NOT NULL COMMENT '',
  `return_stock_reason_idreturn_stock_reason` INT(11) NOT NULL COMMENT '',
  `stock_idstock` INT(11) NOT NULL COMMENT '',
  `return_stock_status_idreturn_stock_status` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idreturn_stock`)  COMMENT '',
  INDEX `fk_return_stock_return_stock_reason1_idx` (`return_stock_reason_idreturn_stock_reason` ASC)  COMMENT '',
  INDEX `fk_return_stock_stock1_idx` (`stock_idstock` ASC)  COMMENT '',
  INDEX `fk_return_stock_return_stock_status1_idx` (`return_stock_status_idreturn_stock_status` ASC)  COMMENT '',
  CONSTRAINT `fk_return_stock_return_stock_reason1`
    FOREIGN KEY (`return_stock_reason_idreturn_stock_reason`)
    REFERENCES `sql12179853`.`return_stock_reason` (`idreturn_stock_reason`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_return_stock_return_stock_status1`
    FOREIGN KEY (`return_stock_status_idreturn_stock_status`)
    REFERENCES `sql12179853`.`return_stock_status` (`idreturn_stock_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_return_stock_stock1`
    FOREIGN KEY (`stock_idstock`)
    REFERENCES `sql12179853`.`stock` (`idstock`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`sub_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`sub_category` (
  `idsub_category` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `sub_category_name` VARCHAR(45) NOT NULL COMMENT '',
  `subcategory_description` VARCHAR(500) NOT NULL COMMENT '',
  `category_idcategory` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idsub_category`)  COMMENT '',
  INDEX `fk_sub_category_category_idx` (`category_idcategory` ASC)  COMMENT '',
  CONSTRAINT `fk_sub_category_category`
    FOREIGN KEY (`category_idcategory`)
    REFERENCES `sql12179853`.`category` (`idcategory`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `sql12179853`.`user_access_frame`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sql12179853`.`user_access_frame` (
  `iduser_access_frame` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `frame_idframe` INT(11) NOT NULL COMMENT '',
  `user_iduser` INT(11) NOT NULL COMMENT '',
  `status` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`iduser_access_frame`)  COMMENT '',
  INDEX `fk_frame_has_user_user1_idx` (`user_iduser` ASC)  COMMENT '',
  INDEX `fk_frame_has_user_frame1_idx` (`frame_idframe` ASC)  COMMENT '',
  CONSTRAINT `fk_frame_has_user_frame1`
    FOREIGN KEY (`frame_idframe`)
    REFERENCES `sql12179853`.`frame` (`idframe`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_frame_has_user_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `sql12179853`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
