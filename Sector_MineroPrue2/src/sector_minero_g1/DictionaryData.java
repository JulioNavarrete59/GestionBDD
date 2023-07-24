/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sector_minero_g1;

/**
 *
 * @author EQUIPO
 */
public class DictionaryData {
    private int object_id;
    private String tabla;
    private String columna;
    private String tipo;
    private int precision;
    private int maxLength;
    private String permiteNulls;
    private String esAutonumerico;
    private String descripcion = "NULL";
    private String foreignKey;
    private String referenceTableName;
    private String referenceColumnName;

    // Constructor
    public DictionaryData() {
    }

    // Setters
     public void setObject_id(int object_id) {
        this.object_id = object_id;
    }
    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void setPermiteNulls(String permiteNulls) {
        this.permiteNulls = permiteNulls;
    }

    public void setEsAutonumerico(String esAutonumerico) {
        this.esAutonumerico = esAutonumerico;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public void setReferenceTableName(String referenceTableName) {
        this.referenceTableName = referenceTableName;
    }

    public void setReferenceColumnName(String referenceColumnName) {
        this.referenceColumnName = referenceColumnName;
    }

    // Getters
    public String getTabla() {
        return tabla;
    }

    public String getColumna() {
        return columna;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPrecision() {
        return precision;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public String getPermiteNulls() {
        return permiteNulls;
    }

    public String getEsAutonumerico() {
        return esAutonumerico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public String getReferenceTableName() {
        return referenceTableName;
    }

    public String getReferenceColumnName() {
        return referenceColumnName;
    }

    public int getObject_id() {
        return object_id;
    }

}