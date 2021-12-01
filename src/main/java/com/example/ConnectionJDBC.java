package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {
        String urlConnection = "jdbc:mysql://localhost/digital_innovation_one";

        try (Connection conn = DriverManager.getConnection(urlConnection, "root", "password")) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM aluno");
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                
            }
            System.out.println("SUCESS");
        } catch (Exception e) {
            System.out.println("FAIL");
            e.printStackTrace();
        }
    }
}
