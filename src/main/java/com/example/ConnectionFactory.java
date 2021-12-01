package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private ConnectionFactory() {
        throw new UnsupportedOperationException();
    }

    public static Connection getConnection() {
        Connection conn = null;

        try (InputStream input = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream("connection.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            StringBuilder sb = new StringBuilder("jdbc:")
                    .append(driver).append("://")
                    .append(dataBaseAddress).append("/")
                    .append(dataBaseName);

            String connectionUrl = sb.toString();

            try {
                conn = DriverManager.getConnection(connectionUrl, user, password);
                System.out.println("SUCESSO ao criar uma conexao.");
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexao.");
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            System.out.println("FALHA ao tentar carregar arquivo de propriedades.");
            e.printStackTrace();
        }

        return conn;
    }
}
