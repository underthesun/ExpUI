/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author b1106
 */
public class ResultModel extends AbstractTableModel {

    String[] columnNames = {"处理过程", "开始时间", "结束时间"};
    ArrayList<Object[]> data = new ArrayList<Object[]>();

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    public void setData(ArrayList<Object[]> data) {
        this.data = data;
        fireTableDataChanged();
    }
}
