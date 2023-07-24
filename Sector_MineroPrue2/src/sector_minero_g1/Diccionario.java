/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector_minero_g1;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sector_minero_g1.Conexion.ejecutarConsultaConResultado;
import static sector_minero_g1.Conexion.getConection;

public class Diccionario {
    
      public static List<DictionaryData> obtenerDatosDiccionario() {
     
        List<DictionaryData> dictionaryDataList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;;"
            + "database=G1_Sector_Minero;"
            + "user=sa;"
            + "password=adminadmin;"
            + "encrypt=false;"
            + "trustServerCertificate=true;"
            + "loginTimeout=30;");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ver_diccionario_datos")) {

            while (resultSet.next()) {
                // Mapear los resultados a objetos DictionaryData y agregarlos a la lista
                DictionaryData dictionaryData = new DictionaryData();
                dictionaryData.setObject_id(resultSet.getInt("object_id"));
                dictionaryData.setTabla(resultSet.getString("tabla"));
                dictionaryData.setColumna(resultSet.getString("columna"));
                dictionaryData.setTipo(resultSet.getString("tipo"));
                dictionaryData.setPrecision(resultSet.getInt("Precision"));
                dictionaryData.setMaxLength(resultSet.getInt("max_length"));
                dictionaryData.setPermiteNulls(resultSet.getString("Permite Nulls"));
                dictionaryData.setEsAutonumerico(resultSet.getString("Es Autonumerico"));
                dictionaryData.setDescripcion(resultSet.getString("Descripcion"));
                dictionaryData.setForeignKey(resultSet.getString("ForeignKey"));
                dictionaryData.setReferenceTableName(resultSet.getString("ReferenceTableName"));
                dictionaryData.setReferenceColumnName(resultSet.getString("ReferenceColumnName"));

                   dictionaryDataList.add(dictionaryData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dictionaryDataList;
    }
}