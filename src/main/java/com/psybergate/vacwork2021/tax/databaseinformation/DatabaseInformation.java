package com.psybergate.vacwork2021.tax.databaseinformation;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInformation {
  private static Connection connection;
  private static Statement statement;

  public static void createTable(Statement statement) throws SQLException{

    String createTable = "CREATE TABLE taxdetail (taxpayerid TEXT PRIMARY KEY,name TEXT NOT NULL,"
                        + "surname TEXT NOT NULL,salary float8 NOT NULL,bonus float8 NOT NULL"
                        + ",interest float8 NOT NULL,capitalgains float8 NOT NULL,medicalcredits float8 NOT NULL ," +
                        "primaryrebate float8 NOT NULL,retirementfund float8 NOT NULL,travelallowance float8 NOT NULL,taxpayable float8 NOT NULL);";
    statement.execute(createTable);
  }
  public static void insertToTable(Statement statement, String id, String name, String surname, BigDecimal salary, BigDecimal bonus, BigDecimal interestReceived,
                                   BigDecimal capitalGains, BigDecimal travelAllowance, BigDecimal retirementFund,BigDecimal medicalCredits,
                                   BigDecimal primaryRebate,BigDecimal netTaxPayable) throws SQLException {

//     statement = connection.createStatement();

    String insertStatement = "INSERT INTO taxdetail" +
        " (taxpayerid,name,surname,salary,bonus,interest, capitalgains,travelallowance,retirementfund,medicalcredits,primaryrebate,taxpayable) " +
        "VALUES ('"+id +"','" + name + "','" + surname + "'," + salary.doubleValue() + ","+ bonus.doubleValue() + "," + interestReceived.doubleValue()
        + "," + capitalGains.doubleValue() + "," + travelAllowance.doubleValue() + "," + retirementFund.doubleValue() + "," +
        medicalCredits.doubleValue() + "," + primaryRebate.doubleValue()+ "," + netTaxPayable.doubleValue() + ")";

    statement.executeUpdate(insertStatement);

  }

  public static void  getDetails( Statement statement)throws SQLException{

    //Statement statement = connection.createStatement();
    ResultSet details = statement.executeQuery("SELECT * FROM taxdetail;");

  while(details.next()) {
    System.out.printf(
        "taxpayerid: %s" + "\n" + "name: %s" + "\n" + "surname: %s" + "\n" + "salary: R%f" + "\n" + "bouns: R%f"+
            "\n" + "interest: R %f" + "\n" + "capitalgains: R %f" + "\n" + "travelallowance:  R %f" + "\n" +
            "retirementfund: R %f" + "\n" + "medicalcredits: R %f" + "\n" + "primaryrebate: R %f" + " \n" +
            "taxpayable: R %f" + "\n",
        details.getString("taxpayerid"),
        details.getString("name"),
        details.getString("surname"),
        details.getBigDecimal("salary"),
        details.getBigDecimal("bonus"),
        details.getBigDecimal("interest"),
        details.getBigDecimal("capitalgains"),
        details.getBigDecimal("travelallowance"),
        details.getBigDecimal("retirementfund"),
        details.getBigDecimal("medicalcredits"),
        details.getBigDecimal("primaryrebate"),
        details.getBigDecimal("taxpayable"));
  }


    }
  }

