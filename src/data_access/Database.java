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
    public static final String[][] columnNames = 
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
    
    
    public static final String[] vistas = {"a_alumno", "a_docente", "a_personal", "admin_egreso"};
    public static final String[][] vistasCNames = 
    {   {"Id_alumno", "Nombre", "Apellido", "Ciudad", "Dirección", "Nivel_escolaridad", "Frecuencia"},
        {"Campo_trabajo", "Nivel_educativo", "Per_cedula"},
        {"Nombre", "Apellido", "Cedula", "Antiguedad", "Experiencia_laboral"},
        {"Id_egreso", "Tipo", "Pro_NIT", "Mov_Recibo"},
    };
    
    public Database (){}
    
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
    

