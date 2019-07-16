/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_access;

import java.awt.List;
import java.sql.*;
import java.util.LinkedList;
/**
 *
 * @author German le yo
 */
public class Database {
    
    
    private static String URL = "jdbc:mysql://localhost:3306/scrip_proy?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    private Connection connection;
    
    public static final String[] tables = {"administrador", "alumno", "contador", "docente", "egreso", "imprenta", "ingreso", "inversionista", "movimiento_financiero", "personal", "produccion", "proveedor", "publicista", "secretario", "telefono", "tutoria"};
    public static final String[][] tablesCNames = 
        {   {"Per_cedula"}, 
            {"Id_alumno", "Nombre", "Apellido", "Ciudad", "Direccion", "Nivel_escolaridad", "Frecuencia"},
            {"Per_cedula"},
            {"Id_docente", "Campo_trabajo", "Nivel_educativo", "Per_cedula"},
            {"Id_egreso", "Tipo", "Pro_NIT", "Mov_Recibo"},
            {"Pro_NIT", "Calidad", "Pub_cedula"},
            {"Id_ingreso", "Tipo", "Mov_Recibo"},
            {"Id_inversionista", "Nombre", "Interes", "Correo", "Representante"}, 
            {"Recibo", "Fecha", "Cantidad", "Remitente", "Receptor", "Tipo", "Cedula_contador"},
            {"Cedula", "Ciudad", "Direccion", "Antiguedad", "Nombre", "Apellido", "Horario", "Edad", "Experiencia_laboral", "Sueldo"},
            {"Id_Produccion", "Porc_inversion", "Id_Inversion", "Id_ingreso", "Id_egreso"},
            {"NIT_proveedor", "Nombre", "Tarifa", "Direccion", "Ciudad", "Enfoque", "Correo", "Representante", "Adm_cedula"},
            {"Per_cedula"},
            {"Per_cedula"},
            {"Entidad", "id_entidad", "Numero", "Operador", "Tipo"},
            {"Fecha", "Ced_docente", "Id_alumno", "Materiales", "Tema", "Horario", "Lugar", "Sec_cedula"}
        };
    
    
    public static final String[] vistas = {"a_alumno", "a_docente", "a_personal", "admin_egreso", "admin_movimiento_financiero", "admin_proveedor", "c_inversionista", "c_movimiento_financiero", "c_produccion", "c_proveedor", "d_alumno", "d_docente", "d_tutoria", "i_egreso", "i_ingreso", "i_movimiento_financiero", "i_produccion", "p_administrador", "p_personal", "p_publicista", "p_telefono", "p_tutoria", "pub_alumno", "pub_docente", "pub_personal", "pub_tutoria", "s_alumno", "s_docente", "s_personal", "s_telefono", "s_tutoria"};
    public static final String[][] vistasCNames = 
    {   {"Id_alumno", "Nombre", "Apellido", "Ciudad", "Direccion", "Nivel_escolaridad", "Frecuencia"},
        {"Campo_trabajo", "Nivel_educativo", "Per_cedula"},
        {"Nombre", "Apellido", "Cedula", "Antiguedad", "Experiencia_laboral"},
        {"Id_egreso", "Tipo", "Pro_NIT", "Mov_Recibo"},
        {"Cantidad", "Remitente", "Receptor", "Fecha", "Recibo", "Tipo"},
        {"NIT_proveedor", "Nombre", "Tarifa", "Direccion", "Ciudad", "Enfoque", "Correo", "Representante", "Adm_cedula"},
        {"Id_inversionista", "Nombre", "Interes", "Correo", "Representante"},
        {"Recibo", "Fecha", "Cantidad", "Remitente", "Receptor", "Tipo", "Cedula_contador"},
        {"Id_Produccion", "Porc_inversion", "Id_Inversion", "Id_ingreso", "Id_egreso"},
        {"NIT_proveedor", "Nombre", "Tarifa", "Direccion", "Ciudad", "Enfoque", "Correo", "Representante", "Adm_cedula"},
        {"Id_alumno", "Nombre", "Apellido", "Ciudad", "Direccion", "Nivel_escolaridad", "frecuencia"},
        {"id_docente", "nombre", "apellido", "Campo_trabajo", "Nivel_educativo", "Per_cedula"},
        {"Fecha", "Ced_docente", "Id_alumno", "Materiales", "Tema", "Horario", "Lugar"},
        {"Tipo", "Mov_recibo"},
        {"Tipo", "Mov_recibo", "id_ingreso"},
        {"Recibo", "Cantidad"},
        {"Id_ingreso", "porc_inversion"},
        {"Per_cedula"},
        {"Cedula", "Nombre", "Apellido", "Correo", "Ciudad", "Horario"},
        {"Per_cedula"},
        {"Numero", "Tipo", "id_entidad"},
        {"materiales"},
        {"Id_alumno", "Nivel_escolaridad", "Frecuencia"},
        {"Per_cedula", "Campo_Trabajo", "Nivel_educativo"},
        {"Cedula", "Experiencia_laboral"},
        {"Id_alumno", "tema"},
        {"Nombre", "Apellido", "Id_alumno", "Direccion"},
        {"Per_cedula", "Nivel_educativo", "Campo_trabajo"},
        {"Nombre", "Apellido", "Cedula"},
        {"id_entidad", "Numero"},
        {"Fecha", "Ced_docente", "Id_alumno", "Materiales", "Tema", "Horario", "Lugar", "Sec_cedula"}
        
    };
    public static Procedimiento[] procedure = new Procedimiento[]{
        new Procedimiento("PAs_1", new String[]{"Porcentaje Aumento","Nivel de Estudio"}),
        new Procedimiento("PAs_2", new String[]{"Porcentaje Aumento","Nombre Personal"}),
        new Procedimiento("PAs_3", new String[]{"Cedula Contador"}),
        new Procedimiento("PAs_4", new String[]{"Porcentaje Aumento","Cedula Contador"}),
        new Procedimiento("PAs_5", new String[]{"NIT","Porcentaje Tarifa"}),
        new Procedimiento("PAs_6", new String[]{"Cedula del Docente","Campo de Trabajo","Nivel Educativo"}),
        new Procedimiento("PAs_7", new String[]{"Cedula de la Persona"}),
        new Procedimiento("PAs_8", new String[]{"Sueldo"}),
        new Procedimiento("PAs_9", new String[]{"Número"}),
        new Procedimiento("PAs_10", new String[]{"Tema Clase"})
    };
    
   
    
    public static class Procedimiento{
        public final String nombre;
        public final String[] parametros;
        public Procedimiento(String nom, String[] param ){
            nombre = nom;
            parametros = param;
        }
    }
    
    
   
    public Database (){}
   
    
    public static Procedimiento getProcByName(String name){
        for (int i = 0; i < procedure.length ; i++) {
            if (procedure[i].nombre.compareTo(name)==0) return procedure[i];
        }
        return null;
    }
    public static int getTableIndexByName(String name){
        for (int i = 0; i < tables.length; i++) {
            if(tables[i].compareTo(name) == 0) return i;
        }
        
        return -1;
    }
    
    public static int getVistaIndexByName(String name){
        for (int i = 0; i < vistas.length; i++) {
            if(vistas[i].compareTo(name) == 0)return i;
        }
        
        return -1;
    }
    
    public boolean connect(String user, String password){
        try{          
            connection = DriverManager.getConnection(URL, user, password);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }  
    }
    
    
    
    public String[][] getTable(String tableName, String[] columnNames){
        String table [][];
        LinkedList<String[]> values = new LinkedList();
        String[] tmp;
        try{
            String query = "SELECT * FROM " +  tableName;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                tmp = new String[columnNames.length];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = rs.getString(columnNames[i]);
                }
                values.add(tmp);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return values.toArray(new String[values.size()][]);
    }
}
    

