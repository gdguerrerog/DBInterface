/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseinterface;

import GUI.LogInPanel;
import GUI.MainPanel;
import data_access.Database;

/**
 *
 * @author German le yo
 */
public class DatabaseInterface {

    private static Database database;
    private static LogInPanel panel;
    private static MainPanel mainPanel;
    
    public static UserType user;
    
    public static String[] ALUMNO_VISTAS = {Database.vistas[0], Database.vistas[1], Database.vistas[2]};
    public static String[] PROVIER_VISTAS = {};
    public static String[] INVERSIONISTA_VISTAS = {};
    public static String[] PUBLICISTA_VISTAS = {};
    public static String[] SECRETARIO_VISTAS = {};
    public static String[] CONTADOR_VISTAS = {};
    public static String[] ADMINISTRADOR_VISTAS = {Database.vistas[3]};
    public static String[] DOCENTE_VISTAS = {};
    

    public static enum UserType{
        
        ADMIN(Database.tables, Database.vistas), 
        ALUMNO(new String[]{}, ALUMNO_VISTAS),
        PROVIDER(new String[]{}, PROVIER_VISTAS),
        INVERSIONISTA(new String[]{}, INVERSIONISTA_VISTAS),
        PUBLICISTA(new String[]{}, PUBLICISTA_VISTAS),
        SECRETARIO(new String[]{}, SECRETARIO_VISTAS),
        CONTADOR(new String[]{}, CONTADOR_VISTAS),
        ADMINISTRADOR(new String[]{}, ADMINISTRADOR_VISTAS),
        DOCENTE(new String[]{}, DOCENTE_VISTAS);
        
        
        
        public final String[] selectTables;
        public final String[] vistas;
        
        UserType(String[] selectTables, String[] vistas){
            this.selectTables = selectTables;
            this.vistas = vistas;
        }
    }
    
    
    private static UserType parseUserType(String str){
        switch(str){
            case "AdministradorBDD": return UserType.ADMIN;
            case "Alumno": return UserType.ALUMNO;
            case "Proveedor": return UserType.PROVIDER;
            case "Inversionista": return UserType.INVERSIONISTA;
            case "Publicista": return UserType.PUBLICISTA;
            case "Secretario": return UserType.SECRETARIO;
            case "Contador": return UserType.CONTADOR;
            case "Administrador": return UserType.ADMINISTRADOR;
            case "Docente": return UserType.DOCENTE;
            default: return null; 
        }
    }
    
    public static void makeLogIn(String toLoginUser, String password){
        if(database.connect(toLoginUser, password)){
        //if(true){
            panel.setInfoLabel("Usuario o contraseña correcto");
            user = parseUserType(toLoginUser);
            panel.dispose();
            
            mainPanel = new MainPanel();
            mainPanel.setLocationRelativeTo(null);
            mainPanel.setVisible(true);
            
        }else {
            panel.setInfoLabel("Usuario o contraseña incorrecta");
        }
    }
    
    public static void createTable(int index){
        String[][] model = database.getTable(database.tables[index], Database.columnNames[index]);
        String[] titles = Database.columnNames[index];
        
        mainPanel.setTableModelInTables(model, titles);
        
        
    }
    
    public static void main(String[] args) {
        
        try{//for jdbc
            Class.forName("com.mysql.cj.jdbc.Driver");
            database = new Database();
            panel = new LogInPanel();
            panel.setLocationRelativeTo(null);
            panel.setVisible(true);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
