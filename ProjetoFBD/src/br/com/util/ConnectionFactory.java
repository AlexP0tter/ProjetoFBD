/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alexp0tter
 */
public class ConnectionFactory {
    
    public static final String NOME_DATABASE_POSTGRES = "POSTGRES";
    public static final String NOME_DATABASE_MYSQL = "MYSQL";
    public static final String FIREBASE_GOOGLE = "FIREBASE_GOOGLE";

    public static final String URL_POSTGRES = "jdbc:postgresql://localhost:5432/sgac2";
    public static final String LOGIN_POSTGRES = "postgres";
    public static final String SENHA_POSTGRES = "jjdc1992";
    
    //public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/sgac";
    public static final String URL_MYSQL = "jdbc:mysql://localhost:3306/sgac2";
    public static final String LOGIN_MYSQL = "root";
    public static final String SENHA_MYSQL = "";
    
    private static Connection connection;
    
    private ConnectionFactory() {
    }
    
    
    public static Connection getInstance(String dataBase) throws Exception {
        try {
            switch (dataBase) {
                case NOME_DATABASE_POSTGRES:
                    if (connection == null || connection.isClosed()) {
                        connection = DriverManager.
                                getConnection(URL_POSTGRES,
                                        LOGIN_POSTGRES,
                                        SENHA_POSTGRES);    
                    }
                    break;
                case NOME_DATABASE_MYSQL:
                     if (connection == null || connection.isClosed()) {
                        connection = DriverManager.
                                getConnection(URL_MYSQL,
                                        LOGIN_MYSQL,
                                        SENHA_MYSQL);    
                    }
                    break;
                case FIREBASE_GOOGLE:
                    
                    break;
            }
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
        return connection;
    }
    
}
