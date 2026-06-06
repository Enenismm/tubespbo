package com.mycompany.tubespbo;

import com.mycompany.tubespbo.gui.Utama;
import java.sql.*;

public class TubesPbo {

    // Design Pattern: Singleton untuk koneksi database
    private static Connection instance;

    public static Connection getInstance() {
        try {
            if (instance == null || instance.isClosed()) {
                String url = "jdbc:mysql://localhost:3306/datapark";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                instance = DriverManager.getConnection(url, "root", "");
                System.out.println("Koneksi DB berhasil (Singleton)");
            }
        } catch (SQLException e) {
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
        return instance;
    }

    public static void main(String[] args) {
        new Utama().setVisible(true);
    }
}