/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author vextroidMAC
 */
public class tableload {

    public static void loadtablefromatabase(JXTable jt, String sql) throws Exception {
        DefaultTableModel dtb = (DefaultTableModel) jt.getModel();
        ResultSet tablesql = databaseconnection.search(sql);
        Vector columnNames = new Vector();
        dtb.setRowCount(0);
        dtb.setColumnCount(0);
        if (tablesql.first()) {

            for (int i = 0; i < tablesql.getMetaData().getColumnCount(); i++) {
                columnNames.add(tablesql.getMetaData().getColumnName(i));
            }
            dtb.addColumn(columnNames);

            while (tablesql.next()) {
                Vector columnData = new Vector();
                for (int i = 1; i < tablesql.getMetaData().getColumnCount(); i++) {
                    columnData.add(tablesql.getString(i));

                }
                dtb.addRow(columnData);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Query Issue", "Error in loading", JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void loadtableonlycolumnsfromatabase(JTable jt, String sql) throws Exception {
        DefaultTableModel dtb = (DefaultTableModel) jt.getModel();
        ResultSet tablesql = databaseconnection.search(sql);
        Vector columnNames = new Vector();
        dtb.setRowCount(0);
        dtb.setColumnCount(0);
        if (tablesql.first()) {

            for (int i = 0; i < tablesql.getMetaData().getColumnCount(); i++) {
                columnNames.add(tablesql.getMetaData().getColumnName(i));
            }
            dtb.addColumn(columnNames);

       } else {
            JOptionPane.showMessageDialog(null, "Query Issue", "Error in loading", JOptionPane.ERROR_MESSAGE);
        }

    }
    public static void loadtableonlycolumnsfromatabase(JXTable jt, String sql) throws Exception {
        DefaultTableModel dtb = (DefaultTableModel) jt.getModel();
        ResultSet tablesql = databaseconnection.search(sql);
        Vector columnNames = new Vector();
        dtb.setRowCount(0);
        dtb.setColumnCount(0);
        if (tablesql.first()) {

            for (int i = 0; i < tablesql.getMetaData().getColumnCount(); i++) {
                columnNames.add(tablesql.getMetaData().getColumnName(i));
            }
            dtb.addColumn(columnNames);

        } else {
            JOptionPane.showMessageDialog(null, "Query Issue", "Error in loading", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void loadtablefromatabase(JTable jt, String sql) throws Exception {
        DefaultTableModel dtb = (DefaultTableModel) jt.getModel();
        ResultSet tablesql = databaseconnection.search(sql);
        Vector columnNames = new Vector();
        dtb.setRowCount(0);
        dtb.setColumnCount(0);
        if (tablesql.wasNull()) {
            JOptionPane.showMessageDialog(null, "Query Issue", "Error in loading", JOptionPane.ERROR_MESSAGE);
        } else {

            if (tablesql.getMetaData().getColumnCount() != jt.getColumnCount()) {
                for (int i = 1; i < tablesql.getMetaData().getColumnCount(); i++) {

                    dtb.addColumn(tablesql.getMetaData().getColumnName(i).toString());
                }
            }

            while (tablesql.next()) {
                Vector columnData = new Vector();
                for (int i = 1; i < tablesql.getMetaData().getColumnCount(); i++) {
                    columnData.add(tablesql.getString(i));

                }
                dtb.addRow(columnData);
            }
        }

    }
}
