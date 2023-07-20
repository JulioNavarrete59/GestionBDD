/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector_minero_g1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER-PC
 */
public class Conexion {

    public static String connectionUrl
            = "jdbc:sqlserver://localhost:1433;;"
            + "database=G1_Sector_Minero;"
            + "user=sa;"
            + "password=adminadmin;"
            + "encrypt=false;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;";

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }
    

    public static void ejecutarConsultaSinResultado(String queryString) throws SQLException {
        Connection con = getConection();
        Statement st = con.createStatement();
        st.executeUpdate(queryString);
    }

    public static ResultSet ejecutarConsultaConResultado(String queryString) throws SQLException {
        Connection con = getConection();
        Statement st = con.createStatement();
        return st.executeQuery(queryString);
    }

    public static PreparedStatement prepararConsultaSinResultado(String queryString) throws SQLException {
        Connection con = getConection();
        PreparedStatement st = con.prepareStatement(queryString);
        return st;
    }
    
    /*Se esta creando la tabla de manera automática*/
    public static DefaultTableModel verVistas(String Vista) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        ResultSet rs = ejecutarConsultaConResultado("select * from " + Vista);
        ResultSetMetaData rsm = rs.getMetaData();
        int c = rsm.getColumnCount();
        System.out.println(c);
        String[] col = new String[c];
        System.out.println(col.length);
        /*Se establece el nombre de las columnas*/
        for (int i = 0; i < c; i++) {
            col[i] = rsm.getColumnName(i + 1);
            System.out.println(col[i]);
        }
        model.setColumnIdentifiers(col);
        while (rs.next()) {
            Object[] row = new Object[c];
            /*Se registran los datos de la tabla en el dataModel*/
            for (int i = 0; i < c; i++) {
                row[i] = rs.getObject(i + 1);
            }
            model.addRow(row);
        }
        return model;
    }

    public static ArrayList<String> obtenerColumna(String nombreDeTabla, String nombreColumna, String nombrecolumna2) {
        ArrayList<String> columna = new ArrayList<>();
        try {
            ResultSet rs = ejecutarConsultaConResultado("Select " + nombreColumna +", "+ nombrecolumna2 + " from " + nombreDeTabla);
            while (rs.next()) {
                columna.add(String.valueOf(rs.getInt(1))+"-"+ rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columna;
    }

    public static void llenarComboBox(JComboBox comboBox, String nombreDeTabla, String nombreColumna, String nombrecolumna2) {
        comboBox.removeAllItems();
        ArrayList<String> ids_mina = Conexion.obtenerColumna(nombreDeTabla, nombreColumna, nombrecolumna2);
        ids_mina.forEach(e -> comboBox.addItem(e));
    }
    
    
    
    
    public static ArrayList<String> obtenerColumnaRelacionada(String nombreDeTabla, String nombreColumna, String nombreColumna2, String nombreColumnaMostrar, String nombreTablaRelacionada) {
        ArrayList<String> columna = new ArrayList<>();
        try {
            ResultSet rs = ejecutarConsultaConResultado("SELECT Ubicacion." + nombreColumna + ", Ciudad." + nombreColumnaMostrar +
                                                  " FROM " + nombreDeTabla + " Ubicacion " +  " INNER JOIN " + nombreTablaRelacionada + " Ciudad " +
                                                  " ON Ubicacion." + nombreColumna2 + " = Ciudad." + nombreColumna2);
            while (rs.next()) {
                columna.add(String.valueOf(rs.getInt(1))+"-"+ rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return columna;
    }

    public static void llenarComboBoxRelacionado(JComboBox comboBox, String nombreDeTabla, String nombreColumna, String nombreColumna2, String nombreColumnaMostrar, String nombreTablaRelacionada) {
        comboBox.removeAllItems();
        ArrayList<String> ids_mina = Conexion.obtenerColumnaRelacionada(nombreDeTabla, nombreColumna, nombreColumna2, nombreColumnaMostrar, nombreTablaRelacionada);
        ids_mina.forEach(e -> comboBox.addItem(e));
    }
}
