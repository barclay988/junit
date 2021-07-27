package com.psybergate.vacwork2021.tax.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  public static Connection connectToDatabase() throws SQLException, ClassNotFoundException {
    Class.forName("org.postgresql.Driver");

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/vacation_work", "postgres",
        "admin");
  }
}

