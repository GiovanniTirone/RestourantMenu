package tables;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyTables {

    public static JTable concat (JTable t1 ,JTable t2, Object col []) {
        DefaultTableModel tableModel = new DefaultTableModel(col, 0); // The 0 argument is number rows.
        JTable table = new JTable(tableModel);
        for(int i=1; i<t1.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                row[j] = (t1.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        for(int i=1; i<t2.getRowCount(); i++){
            Object row [] = new Object[col.length];
            for(int j=0; j<col.length; j++){
                row[j] = (t2.getValueAt(i,j));
            }
            tableModel.addRow(row);
        }
        return table;
    }

}
