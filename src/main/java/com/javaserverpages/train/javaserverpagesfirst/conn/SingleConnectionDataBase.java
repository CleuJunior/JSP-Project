package com.javaserverpages.train.javaserverpagesfirst.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDataBase {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/jsp-postgres?autoReconnect=true";
    private static final String USER_DATABASE_NAME = "postgres";
    private static final String PASSWORD_DATABASE = "postgres";
    private static  Connection connection = null;

    static {
        conn();

    }

    public static Connection getConnection() {
        return connection;
    }

    private static void conn() {
        try {

            if(connection == null) {
                Class.forName("org.postgresql.Driver"); /* carrega o drive de conexao do banco */

                connection = DriverManager.getConnection(DATABASE_URL, USER_DATABASE_NAME, PASSWORD_DATABASE);
                connection.setAutoCommit(false); /* Nao efetuar alteracoes no banco sem nosso comando */
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
