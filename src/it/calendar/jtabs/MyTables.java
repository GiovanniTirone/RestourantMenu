package it.calendar.jtabs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyTables {

    public static JTable concat (JTable t1 ,JTable t2, Object col []) {
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        for(int i=0; i<t1.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                row[j] = (t1.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        for(int i=0; i<t2.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                row[j] = (t2.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        return table;
    }

    public static JTable concatArray (JTable tabArray [],  Object col []){
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        for(JTable tab : tabArray){
            table = concat(table,tab,col);
        }
        return table;
    }


    public static void visualizeTable (JTable  jt){
        JFrame f=new JFrame();
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(300,400);
        f.setVisible(true);
    }
}
