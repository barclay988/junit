package com.psybergate.vacwork2021.tax.client;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.credit.Credit;
import com.psybergate.vacwork2021.tax.databaseconnection.DatabaseConnection;
import com.psybergate.vacwork2021.tax.databaseinformation.DatabaseInformation;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxcalculator.TaxCalculator;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client {
  private static Connection connection;
  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    Scanner sc = new Scanner(System.in);
    System.out.println();
    System.out.println("Enter 1 to register.");
    System.out.println("########################");
    System.out.println("Enter 2 to get your tax details. ");
    System.out.println("########################");
    System.out.print("Please enter  (1 or 2): ");
    int number = sc.nextInt();
    Connection connection = DatabaseConnection.connectToDatabase();


    if(number == 1) {


      System.out.print("Please enter your ID: ");
      String ID  = sc.next();
      System.out.print("Please enter your name: ");
      String name  = sc.next();
      System.out.print("Please enter your surname: ");
      String surname  = sc.next();
      System.out.print("Please enter: ");
      System.out.print("Salary: R ");
      BigDecimal salary = BigDecimal.valueOf(sc.nextDouble());
      System.out.print("Bonus: R ");
      BigDecimal bonus = BigDecimal.valueOf(sc.nextDouble());
      System.out.print("Interest Received: R ");
      BigDecimal interestReceived = BigDecimal.valueOf(sc.nextDouble());
      System.out.print("Capital Gains: R ");
      BigDecimal totalCapitalGains = BigDecimal.valueOf(sc.nextDouble());

      System.out.print("Retirement Fund: R ");
      BigDecimal retirementFund = BigDecimal.valueOf(sc.nextDouble());
      System.out.print("Travel Allowance: R ");
      BigDecimal travelAllowanceReceived = BigDecimal.valueOf(sc.nextDouble());

      System.out.print("Medical Credits: R ");
      BigDecimal medicalCredits = BigDecimal.valueOf(sc.nextDouble());
      System.out.print("Primary Rebate: R ");
      BigDecimal primaryRebate = BigDecimal.valueOf(sc.nextDouble());

      Income income = new Income();
      income.setSalary(salary);
      income.setBonus(bonus);
      income.setInterestReceived(interestReceived);
      income.setTotalCapitalGains(totalCapitalGains);

      Expense expense = new Expense();
      expense.setRetirementFund(retirementFund);
      expense.setTravelAllowance(travelAllowanceReceived);

      Credit credit = new Credit();
      credit.setMedicalCredits(medicalCredits);
      credit.setPrimaryRebate(primaryRebate);

      TaxCalculator taxCalculator = new TaxCalculator();

      BigDecimal totalExpense = taxCalculator.calculateTotalExpenses(retirementFund, travelAllowanceReceived);

      BigDecimal totalIncome = taxCalculator.calculateTotalIncome(salary, bonus, interestReceived, totalCapitalGains);

      BigDecimal totalCredits = taxCalculator.calculateTotalCredits(medicalCredits, primaryRebate);

      BigDecimal taxPayable = taxCalculator.payableTax(totalIncome.subtract(totalExpense));
      BigDecimal netPayableTax = taxCalculator.netTaxPayableTax(totalCredits, taxPayable);

      System.out.println("Net tax payable is: R " + netPayableTax);
     // DatabaseInformation.insertToTable(ID,name,surname,salary,bonus,interestReceived,totalCapitalGains,travelAllowanceReceived,retirementFund,medicalCredits,primaryRebate);


      try {

        Statement statement = connection.createStatement();
        //Create table
        DatabaseInformation.createTable(statement);

        DatabaseInformation.insertToTable(statement, ID, name, surname, salary, bonus, interestReceived, totalCapitalGains, travelAllowanceReceived, retirementFund, medicalCredits, primaryRebate,netPayableTax);
        connection.close();
        System.out.println("Information stored in the database");

      } catch (SQLException e){
        //throw new RuntimeException("Connection failure.");
        e.printStackTrace();
      }

    }else{

      Statement statement = connection.createStatement();
      DatabaseInformation.getDetails(statement);
    }


  }



}
