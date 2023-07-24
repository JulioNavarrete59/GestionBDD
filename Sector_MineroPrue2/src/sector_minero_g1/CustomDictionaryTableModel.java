/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector_minero_g1;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomDictionaryTableModel extends AbstractTableModel {
    private List<DictionaryData> data;
    private String[] columnNames = {
        "object_id",
        "Tabla",
        "Columna",
        "Tipo",
        "Precision",
        "Max Length",
        "Permite Nulls",
        "Es Autonumerico",
        "Descripcion",
        "ForeignKey",
        "ReferenceTableName",
        "ReferenceColumnName"
    };

    public CustomDictionaryTableModel(List<DictionaryData> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DictionaryData rowData = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowData.getObject_id();
            case 1:
                return rowData.getTabla();
            case 2:
                return rowData.getColumna();
            case 3:
                return rowData.getTipo();
            case 4:
                return rowData.getPrecision();
            case 5:
                return rowData.getMaxLength();
            case 6:
                return rowData.getPermiteNulls();
            case 7:
                return rowData.getEsAutonumerico();
            case 8:
                return rowData.getDescripcion();
            case 9:
                return rowData.getForeignKey();
            case 10:
                return rowData.getReferenceTableName();
            case 11:
                return rowData.getReferenceColumnName();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}