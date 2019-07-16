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
    
    public static String[] EMPTY = {};
    public static String[] ALUMNO_VISTAS = {Database.vistas[0], Database.vistas[1], Database.vistas[2]};
    public static String[] PROVIDER_VISTAS = {Database.vistas[17],Database.vistas[18],Database.vistas[19],Database.vistas[20],Database.vistas[21]};
    public static String[] INVERSIONISTA_VISTAS = {Database.vistas[13],Database.vistas[14],Database.vistas[15],Database.vistas[16]};
    public static String[] PUBLICISTA_VISTAS = {Database.vistas[22],Database.vistas[23],Database.vistas[24],Database.vistas[25]};
    public static String[] SECRETARIO_VISTAS = {Database.vistas[26],Database.vistas[27],Database.vistas[28],Database.vistas[29],Database.vistas[30]};
    public static String[] CONTADOR_VISTAS = {Database.vistas[6],Database.vistas[7],Database.vistas[8],Database.vistas[9]};
    public static String[] ADMINISTRADOR_VISTAS = {Database.vistas[3],Database.vistas[4],Database.vistas[5]};
    public static String[] DOCENTE_VISTAS = {Database.vistas[10],Database.vistas[11],Database.vistas[12]};
    

    public static enum UserType{
        
        ADMIN(Database.tables, Database.vistas), 
        ALUMNO(EMPTY, ALUMNO_VISTAS),
        PROVIDER(EMPTY, PROVIDER_VISTAS),
        INVERSIONISTA(EMPTY, INVERSIONISTA_VISTAS),
        PUBLICISTA(EMPTY, PUBLICISTA_VISTAS),
        SECRETARIO(EMPTY, SECRETARIO_VISTAS),
        CONTADOR(EMPTY, CONTADOR_VISTAS),
        ADMINISTRADOR(EMPTY, ADMINISTRADOR_VISTAS),
        DOCENTE(EMPTY, DOCENTE_VISTAS);
        
        public final String[] selectTables;
        public final String[] selectVistas;
        
        UserType(String[] selectTables, String[] vistas){
            this.selectTables = selectTables;
            this.selectVistas = vistas;
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
    
    public static void createTableTables(int index){
        
        int newIndex = Database.getTableIndexByName(user.selectTables[index]);
        
        String[] titles = Database.tablesCNames[newIndex];
        String[][] model = database.getTable(user.selectTables[index], titles);
        
        mainPanel.setTableModelInTables(model, titles);
    }
    
    public static void createTableViews(int index){
        
        int newIndex = Database.getVistaIndexByName(user.selectVistas[index]);
        
        String[] titles = Database.vistasCNames[newIndex];
        String[][] model = database.getTable(user.selectVistas[index], titles);
        
        mainPanel.setTableModelInViews(model, titles);  
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
