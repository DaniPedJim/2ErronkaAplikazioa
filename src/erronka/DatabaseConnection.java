package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/*
	private static final String URL = "jdbc:mysql://172.16.243.168/erronka2";
    private static final String USER = "inigo";
    private static final String PASSWORD = "1MG32025";
    */
	private static final String URL = "jdbc:mysql://192.168.115.154/erronka2";
    private static final String USER = "admin";
    private static final String PASSWORD = "1MG32025";
	
	
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Errorea datu-basearekin konektatzean: " + e.getMessage());
            return null;
        }
    }
}
