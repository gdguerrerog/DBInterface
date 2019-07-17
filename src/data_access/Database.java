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
    public static final String[][] tablesCNames
            = {{"Per_cedula"},
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
        new Procedimiento("PAs_1", new String[]{"Porcentaje Aumento","Nivel de Estudio"},false),
        new Procedimiento("PAs_2", new String[]{"Porcentaje Aumento","Nombre Personal"},false),
        new Procedimiento("PAs_3", new String[]{"Cedula Contador"},true),
        new Procedimiento("PAs_4", new String[]{"Porcentaje Aumento","Cedula Contador"},false),
        new Procedimiento("PAs_5", new String[]{"NIT","Porcentaje Tarifa"},true),
        new Procedimiento("PAs_6", new String[]{"Cedula del Docente","Campo de Trabajo","Nivel Educativo"},false),
        new Procedimiento("PAs_7", new String[]{"Cedula de la Persona"},true),
        new Procedimiento("PAs_8", new String[]{"Sueldo"},true),
        new Procedimiento("PAs_9", new String[]{"Número"},false),
        new Procedimiento("PAs_10", new String[]{"Tema Clase"},false)
    };
    public static Funcion[] funciones = new Funcion[]{
        new Funcion("funcion_1",  new String[]{"Cedula","Aumento"}),
        new Funcion("funcion_2",  new String[]{"Personal"}),
        new Funcion("func_3",  new String[]{"Nombre Publicista"}),
        new Funcion("func_4",  new String[]{"Nombre Docente"}),
        new Funcion("func_5",  new String[]{"Nombre Estudiante"}),
        new Funcion("funct_6",  new String[]{"Tipo de Movimiento"}),
        new Funcion("funcion_7",  new String[]{"Nombre Publicista"}),
        new Funcion("func_8",  new String[]{"Cedula Administrador"}),
        new Funcion("func_9",  new String[]{"Id Ingresos"}),
        new Funcion("func_10",  new String[]{"Entidad","Operador"}),



    };
   
    
    public static class Procedimiento{
        public final String nombre;
        public final String[] parametros;
        public final boolean hasOutput;
        public Procedimiento(String nom, String[] param, boolean output ){
            nombre = nom;
            parametros = param;
            hasOutput = output;
        }
        
        @Override
        public String toString(){ return nombre; }
    }
    
    public static class Funcion{
        public final String nombre;
        public final String[] parametros;
        public Funcion(String nom, String[] params){
            nombre = nom;
            parametros = params;
        }
    }
    
    
   
    public Database (){}
   
    
    public static Procedimiento getProcByName(String name){
        for (int i = 0; i < procedure.length ; i++) {
            if (procedure[i].nombre.compareTo(name)==0) return procedure[i];
        }
        return null;
    }
    public static Funcion getFunByName(String name){
        for (int i = 0; i < funciones.length ; i++) {
            if (funciones[i].nombre.compareTo(name)==0) return funciones[i];
        }
        return null;
    }
    public static int getTableIndexByName(String name){
        for (int i = 0; i < tables.length; i++) {
            if (tables[i].compareTo(name) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int getVistaIndexByName(String name) {
        for (int i = 0; i < vistas.length; i++) {
            if (vistas[i].compareTo(name) == 0) {
                return i;
            }
        }

        return -1;
    }

    public boolean connect(String user, String password) {
        try {
            connection = DriverManager.getConnection(URL, user, password);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String[][] getTable(String tableName, String[] columnNames) {
        LinkedList<String[]> values = new LinkedList();
        String[] tmp;
        try {
            String query = "SELECT * FROM " + tableName;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tmp = new String[columnNames.length];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = rs.getString(columnNames[i]);
                }
                values.add(tmp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return values.toArray(new String[values.size()][]);
    }
    
    public String executeProcedure(Procedimiento procedure, String[] params){
        String queryString = String.format("{call %s(",procedure.nombre) ;
        for (int i = 0; i < procedure.parametros.length; i++) {
            queryString+="?,";
        }
        queryString = queryString.substring(0, queryString.length()-1);
        queryString +=")}";
        
        try{
            CallableStatement stmt = connection.prepareCall(queryString);        
            for (int i = 0; i < procedure.parametros.length; i++) {
                stmt.setString(i+1, params[i]);
            }
            stmt.executeQuery();
            return null;
        }catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
     public String[] executeProcedureWithReturn(Procedimiento procedure, String[] params){
        String queryString = String.format("{call %s(",procedure.nombre) ;
        for (int i = 0; i < procedure.parametros.length; i++) {
            queryString+="?,";
            
        }
        if (procedure.nombre=="PAs_8") {
            queryString = queryString.substring(0, queryString.length()-1);
            queryString +=")}";
        }
        else queryString +="?)}";;
        
        String[] sout = new String[2];
        try{
            CallableStatement stmt = connection.prepareCall(queryString);    
            
            for (int i = 0; i < procedure.parametros.length; i++){ 
           
                stmt.setString(i+1, params[i]);
            }
            if (procedure.nombre=="PAs_8") stmt.registerOutParameter(procedure.parametros.length, Types.VARCHAR);
            else stmt.registerOutParameter(procedure.parametros.length+1, Types.VARCHAR);
            stmt.execute();
            if (procedure.nombre=="PAs_8") sout[0]=stmt.getString(procedure.parametros.length);
            else sout[0]=stmt.getString(procedure.parametros.length+1);
            return sout;
        }catch (Exception ex) {
            ex.printStackTrace();
            sout[0]=null;
            sout[1]=ex.getMessage();
            return sout;
        }
    }
     
    public String[] executeFunc(Funcion fun, String[] params){
        String queryString = "{? = call " + fun.nombre + "(";
        for (int i = 0; i < fun.parametros.length; i++) {
            queryString+="?,";
        }
        queryString = queryString.substring(0, queryString.length()-1);
        queryString +=")}";
        String[] sout = new String[2];

        try{
            CallableStatement stmt = connection.prepareCall(queryString);    
            stmt.registerOutParameter(1, Types.VARCHAR);
            for (int i = 0; i < fun.parametros.length; i++){ 
                stmt.setString(i+2, params[i]);
            }
            
            stmt.execute();
            sout[0]=stmt.getString(1);
            sout[1]="";
            return sout;
        }catch (Exception ex) {
            ex.printStackTrace();
            sout[0]=ex.getMessage();
            sout[1]=null;
            return sout;
        }
    }

    
    
    
    public String insert(String tableName, String[] columnNames, String[] value) {

        String queryString = String.format("INSERT INTO %s (", tableName);

        for (int i = 0; i < columnNames.length; i++) {
            queryString += columnNames[i];
            if (i + 1 < columnNames.length) {
                queryString += ", ";
            }
        }

        queryString += ") VALUES ( ";

        for (int i = 0; i < value.length; i++) {
            queryString += "'" + value[i] + "'";
            if (i + 1 < value.length) {
                queryString += ", ";
            }
        }
        
        queryString += ") ";
        
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(queryString);
            
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getMessage();
        }
    }
}
