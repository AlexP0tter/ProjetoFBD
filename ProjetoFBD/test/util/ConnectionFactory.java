/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    public static final String TIPO_BASE_DADOS_POSTGRES = "POSTGRESS";
    public static final String TIPO_BASE_DADOS_MY_SQL = "MY_SQL";

    public static final String URL_POSTGRES = "jdbc:postgresql://localhost:5432/fbd";
    public static final String LOGIN_POSTGRES = "postgres";
    public static final String SENHA_POSTGRES = "postgres";

    private static Connection conPost;
    private static Connection conMySql;

    private ConnectionFactory() {

    }

    public static Connection getInstance(String tipoBaseDados) {
        try {
            switch (tipoBaseDados) {

                case TIPO_BASE_DADOS_POSTGRES:
                    if (conPost == null || conPost.isClosed()) {
                        conPost = getConnection(URL_POSTGRES, LOGIN_POSTGRES, SENHA_POSTGRES);
                    }
                    return conPost;

                case TIPO_BASE_DADOS_MY_SQL:
                    if (conMySql == null || conMySql.isClosed()) {
                        //conMySql = getConnection(URL_POSTGRES, LOGIN_POSTGRES, SENHA_POSTGRES);
                    }
                    return conMySql;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private static Connection getConnection(String url, String login, String senha) {
        try {
            return DriverManager.getConnection(url, login, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
