/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
/*import static hardware_banukapart.startGUI.da;*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author vextroidMAC
 */

import javax.swing.JFileChooser;

public class databaseconnection {

    static String port;
    static String usern;
    static String paz;
    static String dbname;
    static String portget;
    static String usernget;
    static String pazget;
    static String dbnameget;
    public static Connection c;

    public static void setConnection() throws Exception {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("mysql.properties"));
            portget = prop.getProperty("dburl");
            usernget = prop.getProperty("user");
            pazget = prop.getProperty("password");
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection(portget, usernget, pazget);

        } catch (FileNotFoundException ex) {
            try {
                int conf = JOptionPane.showConfirmDialog(null, "Do you want customize database setting ?\nPress YES to customize ..", "Choice", JOptionPane.INFORMATION_MESSAGE);
                if (conf == 0) {
                    port = JOptionPane.showInputDialog(null, "Please enter the port number");
                    usern = JOptionPane.showInputDialog(null, "Please enter the username");
                    paz = JOptionPane.showInputDialog(null, "Please enter the password");
                    dbname = JOptionPane.showInputDialog(null, "Please enter the Database Name");
                } else if (conf != 0) {
                    port = "3306";
                    usern = "sql12179853";
                    paz = "nVLl6aL3vW";
                    dbname = "sql12179853";
                }
                Properties prop = new Properties();
                OutputStream output = null;

                output = new FileOutputStream("mysql.properties");
                prop.setProperty("dburl", "jdbc:mysql://sql12.freemysqlhosting.net:" + port + "/" + dbname + "");
                prop.setProperty("user", usern);
                prop.setProperty("password", paz);

                prop.store(output, null);
                output.flush();
            } catch (NullPointerException exc) {
                exc.printStackTrace();
                Properties prop = new Properties();
                OutputStream output = null;

                output = new FileOutputStream("mysql.properties");

                prop.setProperty("dburl", "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12179853");
                prop.setProperty("user", "sql12179853");
                prop.setProperty("password", "nVLl6aL3vW");

                prop.store(output, null);
                output.flush();
                setConnection();

            }

        } catch (MySQLSyntaxErrorException exc) {
            exc.printStackTrace();
            int i = JOptionPane.showConfirmDialog(null, "Continue this will create a empty database..\nAre you sure want to continue ??");
            if (i == 0) {
                resBackUP(createDatabase());
            } else if (i == 1 || i == 2) {
                System.exit(1);
            }
        }

    }

    public static void iud(String sql) throws Exception {
        if (c == null) {
            setConnection();
        }
        c.createStatement().executeUpdate(sql);
    }

    public static ResultSet search(String sql) throws Exception {
        try {
            if (c == null) {
                setConnection();
            }
        } catch (MySQLSyntaxErrorException ex) {
            ex.printStackTrace();
            checkDB();
        }
        return c.createStatement().executeQuery(sql);
    }

    public static Connection newCon() throws Exception {
        try {
            if (c == null) {
                setConnection();
            }
        } catch (MySQLSyntaxErrorException ex) {
            ex.printStackTrace();
            checkDB();
        }
        return c;
    }

    public static void BackupDatabase(String ti) throws Exception {
        try {
            if (ti.equals("mainbackup")) {

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");

                String da = sdf.format(date);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -7);
                String da1 = sdf.format(cal.getTime());

                String loc = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/Backup_File";
                File f = new File(loc);
                if (!f.exists()) {
                    f.mkdir();
                }
                String path = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart//Backup_File/yash.sql";

                Runtime.getRuntime().exec("/Applications/AMPPS/mysql/bin/mysqldump -uroot -proot --add-drop-database -B flowerfactroy -r" + path);
                JOptionPane.showMessageDialog(null, "Your Database is backuped");

            } else if (ti.equals("BACKTOCLD")) {

                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy");

                String da = sdf.format(date);

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DATE, -7);
                String da1 = sdf.format(cal.getTime());

                String loc = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/CREATED_BACKUP";
                File f = new File(loc);
                if (!f.exists()) {
                    f.mkdir();
                }
                String path = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/CREATED_BACKUP/" + new SimpleDateFormat("YYYY_MM_dd").format(new Date()) + "__" + ti + ".sql";

                Runtime.getRuntime().exec("/Applications/AMPPS/mysql/bin/mysqldump -uroot -proot --add-drop-database -B flowerfactroy -r" + path);
                JOptionPane.showMessageDialog(null, "Your Database is backuped");
            } else if (ti.equals("CLICKBAC")) {

                JFileChooser jfc = new JFileChooser();

                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                jfc.setAcceptAllFileFilterUsed(false);

                File f;
                if (jfc.showOpenDialog(jfc) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): "
                            + jfc.getCurrentDirectory());
                    f = new File(jfc.getCurrentDirectory().getAbsolutePath());

                } else {
                    f = new File("/Users/vextroidMAC/Desktop");
                }

                if (!f.exists()) {
                    f.mkdir();
                }
                String da = null;
                String path = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/" + da + "/" + new SimpleDateFormat("YYYY_MM_dd").format(new Date()) + "__" + ti + ".sql";

                Runtime.getRuntime().exec("/Applications/AMPPS/mysql/bin/mysqldump -uroot -proot --add-drop-database -B flowerfactroy -r" + path);
                JOptionPane.showMessageDialog(null, "Your Database is backuped");
            } else if (ti.equals("TBAC")) {
                String da = null;

                String loc = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/" + da + "";
                File f = new File(loc);
                if (!f.exists()) {
                    f.mkdir();
                }
                String path = "/Users/vextroidMAC/Dropbox/Hardware_BanukaPart/" + da + "/" + new SimpleDateFormat("YYYY_MM_dd").format(new Date()) + "__" + ti + ".sql";

                Runtime.getRuntime().exec("/Applications/AMPPS/mysql/bin/mysqldump -uroot -proot --add-drop-database -B flowerfactroy -r" + path);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void resBackUP(String path) {
        try {
            String[] restoreCmd = new String[]{"/Applications/AMPPS/mysql/bin/mysql", "--user=" + usernget, "--password=" + pazget, "-e", "source " + path};
            Runtime.getRuntime().exec(restoreCmd);
            JOptionPane.showMessageDialog(null, "Databse restored");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static boolean checkDB() throws Exception {
        boolean sendb = false;
        try {

            setConnection();

            ResultSet resultSet = c.getMetaData().getCatalogs();

            if (!resultSet.first()) {
                throw new Exception();
            } else {
                sendb = true;
            }
        } catch (NullPointerException ex) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendb;
    }

    public static String createDatabase() throws Exception {

        File fw = new File("Database_Table_Only.sql");
        boolean b = fw.exists();

        String s = "CREATE DATABASE  IF NOT EXISTS `Yashoda_Ent` /*!40100 DEFAULT CHARACTER SET latin1 */;\n"
                + "USE `Yashoda_Ent`;\n"
                + "-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)\n"
                + "--\n"
                + "-- Host: localhost    Database: Yashoda_Ent\n"
                + "-- ------------------------------------------------------\n"
                + "-- Server version	5.6.20\n"
                + "\n"
                + "/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;\n"
                + "/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;\n"
                + "/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;\n"
                + "/*!40101 SET NAMES utf8 */;\n"
                + "/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;\n"
                + "/*!40103 SET TIME_ZONE='+00:00' */;\n"
                + "/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;\n"
                + "/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;\n"
                + "/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;\n"
                + "/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `brand`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `brand`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `brand` (\n"
                + "  `idbrand` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `brand_name` varchar(45) DEFAULT NULL,\n"
                + "  `brand_product_status_idbrand_product_status` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idbrand`),\n"
                + "  KEY `fk_brand_brand_product_status1_idx` (`brand_product_status_idbrand_product_status`),\n"
                + "  CONSTRAINT `fk_brand_brand_product_status1` FOREIGN KEY (`brand_product_status_idbrand_product_status`) REFERENCES `brand_product_status` (`idbrand_product_status`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `brand`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `brand` WRITE;\n"
                + "/*!40000 ALTER TABLE `brand` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `brand` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `brand_product_status`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `brand_product_status`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `brand_product_status` (\n"
                + "  `idbrand_product_status` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `brand_product_status_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idbrand_product_status`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `brand_product_status`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `brand_product_status` WRITE;\n"
                + "/*!40000 ALTER TABLE `brand_product_status` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `brand_product_status` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `category`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `category`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `category` (\n"
                + "  `idcategory` int(11) NOT NULL,\n"
                + "  `category_name` varchar(45) NOT NULL,\n"
                + "  `category_description` varchar(500) NOT NULL,\n"
                + "  PRIMARY KEY (`idcategory`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `category`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `category` WRITE;\n"
                + "/*!40000 ALTER TABLE `category` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `category` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `customer`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `customer`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `customer` (\n"
                + "  `idcustomer` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `customer_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idcustomer`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `customer`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `customer` WRITE;\n"
                + "/*!40000 ALTER TABLE `customer` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `customer` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `customer_company`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `customer_company`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `customer_company` (\n"
                + "  `idcustomer_company` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `customer_company_office_tp` varchar(12) NOT NULL,\n"
                + "  `customer_company_con_person` varchar(45) NOT NULL,\n"
                + "  `customer_company_con_tp` varchar(12) DEFAULT NULL,\n"
                + "  `customer_company_credit_week_count` int(11) NOT NULL,\n"
                + "  `customer_company_status` int(11) NOT NULL,\n"
                + "  `customer_idcustomer` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idcustomer_company`),\n"
                + "  KEY `fk_customer_company_customer1_idx` (`customer_idcustomer`),\n"
                + "  CONSTRAINT `fk_customer_company_customer1` FOREIGN KEY (`customer_idcustomer`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `customer_company`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `customer_company` WRITE;\n"
                + "/*!40000 ALTER TABLE `customer_company` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `customer_company` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `customer_return`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `customer_return`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `customer_return` (\n"
                + "  `idcustomer_return` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_items_idorder_items` int(11) NOT NULL,\n"
                + "  `customer_return_qty` double NOT NULL,\n"
                + "  `return_type_idreturn_type` int(11) NOT NULL,\n"
                + "  `return_stock_status_idreturn_stock_status` int(11) NOT NULL,\n"
                + "  `return_stock_reason_idreturn_stock_reason` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idcustomer_return`),\n"
                + "  KEY `fk_customer_returns_order_items1_idx` (`order_items_idorder_items`),\n"
                + "  KEY `fk_customer_return_return_type1_idx` (`return_type_idreturn_type`),\n"
                + "  KEY `fk_customer_return_return_stock_status1_idx` (`return_stock_status_idreturn_stock_status`),\n"
                + "  KEY `fk_customer_return_return_stock_reason1_idx` (`return_stock_reason_idreturn_stock_reason`),\n"
                + "  CONSTRAINT `fk_customer_return_return_stock_reason1` FOREIGN KEY (`return_stock_reason_idreturn_stock_reason`) REFERENCES `return_stock_reason` (`idreturn_stock_reason`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_customer_return_return_stock_status1` FOREIGN KEY (`return_stock_status_idreturn_stock_status`) REFERENCES `return_stock_status` (`idreturn_stock_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_customer_return_return_type1` FOREIGN KEY (`return_type_idreturn_type`) REFERENCES `return_type` (`idreturn_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_customer_returns_order_items1` FOREIGN KEY (`order_items_idorder_items`) REFERENCES `order_items` (`idorder_items`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `customer_return`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `customer_return` WRITE;\n"
                + "/*!40000 ALTER TABLE `customer_return` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `customer_return` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `frame`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `frame`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `frame` (\n"
                + "  `idframe` int(11) NOT NULL,\n"
                + "  `frame_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idframe`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `frame`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `frame` WRITE;\n"
                + "/*!40000 ALTER TABLE `frame` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `frame` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `grn`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `grn`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `grn` (\n"
                + "  `idgrn` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `grn_date` date NOT NULL,\n"
                + "  `grn_time` time NOT NULL,\n"
                + "  `supplier_idsupplier` int(11) NOT NULL,\n"
                + "  `grn_subtotal` double NOT NULL,\n"
                + "  `grn_discount` double NOT NULL,\n"
                + "  `grn_nettotal` double NOT NULL,\n"
                + "  `grn_status` int(11) NOT NULL,\n"
                + "  `user_iduser` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idgrn`),\n"
                + "  KEY `fk_supplier_has_stock_supplier1_idx` (`supplier_idsupplier`),\n"
                + "  KEY `fk_grn_user1_idx` (`user_iduser`),\n"
                + "  CONSTRAINT `fk_grn_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_supplier_has_stock_supplier1` FOREIGN KEY (`supplier_idsupplier`) REFERENCES `supplier` (`idsupplier`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `grn`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `grn` WRITE;\n"
                + "/*!40000 ALTER TABLE `grn` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `grn` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `order`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `order`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `order` (\n"
                + "  `idorder` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_date` date NOT NULL,\n"
                + "  `order_time` time NOT NULL,\n"
                + "  `order_subtotal` double DEFAULT NULL,\n"
                + "  `order_discount` double NOT NULL,\n"
                + "  `order_nettotal` double NOT NULL,\n"
                + "  `order_type_idorder_type` int(11) NOT NULL,\n"
                + "  `order_payment_type_idorder_payment_type` int(11) NOT NULL,\n"
                + "  `order_status_idorder_status` int(11) NOT NULL,\n"
                + "  `user_iduser` int(11) NOT NULL,\n"
                + "  `customer_idcustomer` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idorder`),\n"
                + "  KEY `fk_order_order_type1_idx` (`order_type_idorder_type`),\n"
                + "  KEY `fk_order_order_payment_type1_idx` (`order_payment_type_idorder_payment_type`),\n"
                + "  KEY `fk_order_order_status1_idx` (`order_status_idorder_status`),\n"
                + "  KEY `fk_order_user1_idx` (`user_iduser`),\n"
                + "  KEY `fk_order_customer1_idx` (`customer_idcustomer`),\n"
                + "  CONSTRAINT `fk_order_customer1` FOREIGN KEY (`customer_idcustomer`) REFERENCES `customer` (`idcustomer`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_order_order_payment_type1` FOREIGN KEY (`order_payment_type_idorder_payment_type`) REFERENCES `order_payment_type` (`idorder_payment_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_order_order_status1` FOREIGN KEY (`order_status_idorder_status`) REFERENCES `order_status` (`idorder_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_order_order_type1` FOREIGN KEY (`order_type_idorder_type`) REFERENCES `order_type` (`idorder_type`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `order`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `order` WRITE;\n"
                + "/*!40000 ALTER TABLE `order` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `order` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `order_items`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `order_items`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `order_items` (\n"
                + "  `idorder_items` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_item_qty` double NOT NULL,\n"
                + "  `order_item_subtotal` double NOT NULL,\n"
                + "  `order_item_discount` double NOT NULL,\n"
                + "  `order_item_nettotal` double NOT NULL,\n"
                + "  `order_idorder` int(11) NOT NULL,\n"
                + "  `stock_idstock` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idorder_items`),\n"
                + "  KEY `fk_order_items_order1_idx` (`order_idorder`),\n"
                + "  KEY `fk_order_items_stock1_idx` (`stock_idstock`),\n"
                + "  CONSTRAINT `fk_order_items_order1` FOREIGN KEY (`order_idorder`) REFERENCES `order` (`idorder`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_order_items_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `order_items`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `order_items` WRITE;\n"
                + "/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `order_payment_type`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `order_payment_type`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `order_payment_type` (\n"
                + "  `idorder_payment_type` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_payment_type_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`idorder_payment_type`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `order_payment_type`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `order_payment_type` WRITE;\n"
                + "/*!40000 ALTER TABLE `order_payment_type` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `order_payment_type` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `order_status`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `order_status`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `order_status` (\n"
                + "  `idorder_status` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_status_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idorder_status`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `order_status`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `order_status` WRITE;\n"
                + "/*!40000 ALTER TABLE `order_status` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `order_status` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `order_type`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `order_type`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `order_type` (\n"
                + "  `idorder_type` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `order_type_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`idorder_type`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `order_type`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `order_type` WRITE;\n"
                + "/*!40000 ALTER TABLE `order_type` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `order_type` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `product`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `product`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `product` (\n"
                + "  `idproduct` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `product_code` varchar(45) NOT NULL,\n"
                + "  `product_name` varchar(70) NOT NULL,\n"
                + "  `product_discount_wholesale` double NOT NULL,\n"
                + "  `product_discount_normal` double NOT NULL,\n"
                + "  `product_description` varchar(500) NOT NULL,\n"
                + "  `product_status` int(11) NOT NULL,\n"
                + "  `category_idcategory` int(11) NOT NULL,\n"
                + "  `unit_idunit` int(11) NOT NULL,\n"
                + "  `brand_idbrand` int(11) NOT NULL,\n"
                + "  `selling_price_change_status_idselling_price_change_status` int(11) NOT NULL,\n"
                + "  `product_stock_code_idproduct_stock_code` int(11) NOT NULL,\n"
                + "  `product_remain_qty` double NOT NULL,\n"
                + "  `product_min_stock_qty` double NOT NULL,\n"
                + "  `product_min_wholesale_qty` double NOT NULL,\n"
                + "  PRIMARY KEY (`idproduct`),\n"
                + "  KEY `fk_category_idx` (`category_idcategory`),\n"
                + "  KEY `fk_brand_idx` (`brand_idbrand`),\n"
                + "  KEY `fk_selliing_price_change_idx` (`selling_price_change_status_idselling_price_change_status`),\n"
                + "  KEY `fk_product_stock_code_idx` (`product_stock_code_idproduct_stock_code`),\n"
                + "  KEY `fk_unit_idx` (`unit_idunit`),\n"
                + "  CONSTRAINT `fk_brand` FOREIGN KEY (`brand_idbrand`) REFERENCES `brand` (`idbrand`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_category` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_product_stock_code` FOREIGN KEY (`product_stock_code_idproduct_stock_code`) REFERENCES `product_stock_code` (`idproduct_stock_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_selliing_price_change` FOREIGN KEY (`selling_price_change_status_idselling_price_change_status`) REFERENCES `selling_price_change_status` (`idselling_price_change_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_unit` FOREIGN KEY (`unit_idunit`) REFERENCES `unit` (`idunit`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `product`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `product` WRITE;\n"
                + "/*!40000 ALTER TABLE `product` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `product` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `product_stock_code`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `product_stock_code`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `product_stock_code` (\n"
                + "  `idproduct_stock_code` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `product_stock_code_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`idproduct_stock_code`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `product_stock_code`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `product_stock_code` WRITE;\n"
                + "/*!40000 ALTER TABLE `product_stock_code` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `product_stock_code` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `return_in_stock`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `return_in_stock`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `return_in_stock` (\n"
                + "  `idreturn_stock` int(11) NOT NULL,\n"
                + "  `return_stock_qty` double NOT NULL,\n"
                + "  `return_stock_description` varchar(500) NOT NULL,\n"
                + "  `return_stock_reason_idreturn_stock_reason` int(11) NOT NULL,\n"
                + "  `stock_idstock` int(11) NOT NULL,\n"
                + "  `return_stock_status_idreturn_stock_status` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idreturn_stock`),\n"
                + "  KEY `fk_return_stock_return_stock_reason1_idx` (`return_stock_reason_idreturn_stock_reason`),\n"
                + "  KEY `fk_return_stock_stock1_idx` (`stock_idstock`),\n"
                + "  KEY `fk_return_stock_return_stock_status1_idx` (`return_stock_status_idreturn_stock_status`),\n"
                + "  CONSTRAINT `fk_return_stock_return_stock_reason1` FOREIGN KEY (`return_stock_reason_idreturn_stock_reason`) REFERENCES `return_stock_reason` (`idreturn_stock_reason`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_return_stock_return_stock_status1` FOREIGN KEY (`return_stock_status_idreturn_stock_status`) REFERENCES `return_stock_status` (`idreturn_stock_status`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_return_stock_stock1` FOREIGN KEY (`stock_idstock`) REFERENCES `stock` (`idstock`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `return_in_stock`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `return_in_stock` WRITE;\n"
                + "/*!40000 ALTER TABLE `return_in_stock` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `return_in_stock` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `return_stock_reason`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `return_stock_reason`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `return_stock_reason` (\n"
                + "  `idreturn_stock_reason` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `return_stock_reason_name` varchar(45) NOT NULL,\n"
                + "  `return_stock_reason_description` varchar(500) NOT NULL,\n"
                + "  PRIMARY KEY (`idreturn_stock_reason`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `return_stock_reason`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `return_stock_reason` WRITE;\n"
                + "/*!40000 ALTER TABLE `return_stock_reason` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `return_stock_reason` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `return_stock_status`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `return_stock_status`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `return_stock_status` (\n"
                + "  `idreturn_stock_status` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `return_stock_status_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idreturn_stock_status`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `return_stock_status`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `return_stock_status` WRITE;\n"
                + "/*!40000 ALTER TABLE `return_stock_status` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `return_stock_status` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `return_type`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `return_type`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `return_type` (\n"
                + "  `idreturn_type` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `return_type_name` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idreturn_type`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `return_type`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `return_type` WRITE;\n"
                + "/*!40000 ALTER TABLE `return_type` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `return_type` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `selling_price_change_status`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `selling_price_change_status`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `selling_price_change_status` (\n"
                + "  `idselling_price_change_status` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `selling_price_change_status_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`idselling_price_change_status`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `selling_price_change_status`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `selling_price_change_status` WRITE;\n"
                + "/*!40000 ALTER TABLE `selling_price_change_status` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `selling_price_change_status` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `stock`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `stock`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `stock` (\n"
                + "  `idstock` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `product_idproduct` int(11) NOT NULL,\n"
                + "  `stock_product_code` varchar(45) NOT NULL,\n"
                + "  `stock_qty` double NOT NULL,\n"
                + "  `stock_buyingprice` double NOT NULL,\n"
                + "  `stock_selling_price` double NOT NULL,\n"
                + "  `grn_idgrn` int(11) NOT NULL,\n"
                + "  `stock_status` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idstock`),\n"
                + "  KEY `fk_stock_product1_idx` (`product_idproduct`),\n"
                + "  KEY `fk_stock_grn1_idx` (`grn_idgrn`),\n"
                + "  CONSTRAINT `fk_stock_grn1` FOREIGN KEY (`grn_idgrn`) REFERENCES `grn` (`idgrn`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_stock_product1` FOREIGN KEY (`product_idproduct`) REFERENCES `product` (`idproduct`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `stock`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `stock` WRITE;\n"
                + "/*!40000 ALTER TABLE `stock` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `stock` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `sub_category`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `sub_category`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `sub_category` (\n"
                + "  `idsub_category` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `sub_category_name` varchar(45) NOT NULL,\n"
                + "  `subcategory_description` varchar(500) NOT NULL,\n"
                + "  `category_idcategory` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`idsub_category`),\n"
                + "  KEY `fk_sub_category_category_idx` (`category_idcategory`),\n"
                + "  CONSTRAINT `fk_sub_category_category` FOREIGN KEY (`category_idcategory`) REFERENCES `category` (`idcategory`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `sub_category`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `sub_category` WRITE;\n"
                + "/*!40000 ALTER TABLE `sub_category` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `sub_category` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `supplier`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `supplier`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `supplier` (\n"
                + "  `idsupplier` int(11) NOT NULL,\n"
                + "  `supplier_name` varchar(45) NOT NULL,\n"
                + "  `supplier_email` varchar(45) NOT NULL,\n"
                + "  `supplier_address_no` varchar(45) NOT NULL,\n"
                + "  `supplier_address_street1` varchar(45) NOT NULL,\n"
                + "  `supplier_address_street2` varchar(45) DEFAULT NULL,\n"
                + "  `supplier_address_city` varchar(45) NOT NULL,\n"
                + "  `supplier_office_tp` varchar(12) NOT NULL,\n"
                + "  `supplier_contact_name` varchar(45) NOT NULL,\n"
                + "  `supplier_contact_tp` varchar(12) NOT NULL,\n"
                + "  `supplier_fax` varchar(45) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`idsupplier`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `supplier`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `supplier` WRITE;\n"
                + "/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `unit`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `unit`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `unit` (\n"
                + "  `idunit` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `unit_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`idunit`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `unit`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `unit` WRITE;\n"
                + "/*!40000 ALTER TABLE `unit` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `unit` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `user`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `user`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `user` (\n"
                + "  `iduser` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `user_username` varchar(45) NOT NULL,\n"
                + "  `user_password` varchar(45) NOT NULL,\n"
                + "  `recovery_password` varchar(45) NOT NULL,\n"
                + "  `user_email` varchar(45) NOT NULL,\n"
                + "  `user_status_iduser_status` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`iduser`),\n"
                + "  KEY `fk_user_user_status1_idx` (`user_status_iduser_status`),\n"
                + "  CONSTRAINT `fk_user_user_status1` FOREIGN KEY (`user_status_iduser_status`) REFERENCES `user_status` (`iduser_status`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `user`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `user` WRITE;\n"
                + "/*!40000 ALTER TABLE `user` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `user` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `user_access_frame`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `user_access_frame`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `user_access_frame` (\n"
                + "  `iduser_access_frame` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `frame_idframe` int(11) NOT NULL,\n"
                + "  `user_iduser` int(11) NOT NULL,\n"
                + "  `status` int(11) NOT NULL,\n"
                + "  PRIMARY KEY (`iduser_access_frame`),\n"
                + "  KEY `fk_frame_has_user_user1_idx` (`user_iduser`),\n"
                + "  KEY `fk_frame_has_user_frame1_idx` (`frame_idframe`),\n"
                + "  CONSTRAINT `fk_frame_has_user_frame1` FOREIGN KEY (`frame_idframe`) REFERENCES `frame` (`idframe`) ON DELETE NO ACTION ON UPDATE NO ACTION,\n"
                + "  CONSTRAINT `fk_frame_has_user_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `user_access_frame`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `user_access_frame` WRITE;\n"
                + "/*!40000 ALTER TABLE `user_access_frame` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `user_access_frame` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Table structure for table `user_status`\n"
                + "--\n"
                + "\n"
                + "DROP TABLE IF EXISTS `user_status`;\n"
                + "/*!40101 SET @saved_cs_client     = @@character_set_client */;\n"
                + "/*!40101 SET character_set_client = utf8 */;\n"
                + "CREATE TABLE `user_status` (\n"
                + "  `iduser_status` int(11) NOT NULL,\n"
                + "  `user_status_name` varchar(45) NOT NULL,\n"
                + "  PRIMARY KEY (`iduser_status`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;\n"
                + "/*!40101 SET character_set_client = @saved_cs_client */;\n"
                + "\n"
                + "--\n"
                + "-- Dumping data for table `user_status`\n"
                + "--\n"
                + "\n"
                + "LOCK TABLES `user_status` WRITE;\n"
                + "/*!40000 ALTER TABLE `user_status` DISABLE KEYS */;\n"
                + "/*!40000 ALTER TABLE `user_status` ENABLE KEYS */;\n"
                + "UNLOCK TABLES;\n"
                + "\n"
                + "--\n"
                + "-- Dumping events for database 'Yashoda_Ent'\n"
                + "--\n"
                + "\n"
                + "--\n"
                + "-- Dumping routines for database 'Yashoda_Ent'\n"
                + "--\n"
                + "/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;\n"
                + "\n"
                + "/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;\n"
                + "/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;\n"
                + "/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;\n"
                + "/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;\n"
                + "/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;\n"
                + "/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;\n"
                + "/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;\n"
                + "\n"
                + "-- Dump completed on 2017-06-11 14:18:40";
        if (!b) {
            fw.createNewFile();
            FileWriter fww = new FileWriter("Database_Table_Only.sql");
            BufferedWriter bwr = new BufferedWriter(fww);
            bwr.write(s);

            bwr.flush();
            bwr.close();

        }
        return fw.getAbsolutePath();
    }

}
