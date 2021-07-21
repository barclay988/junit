package com.psybergate.vacwork2021.tax.taxpayer;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.credit.Credit;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxcalculator.TaxCalculator;
import com.psybergate.vacwork2021.tax.taxtable.TaxTable;

import java.util.Scanner;

public class TaxPayer {
  //private static DecimalFormat df = new DecimalFormat("0.00");

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter: ");
    System.out.print("Salary: R ");
    double salary = sc.nextDouble();
    System.out.print("Bonus: R ");
    double bonus = sc.nextDouble();
    System.out.print("Interest Received: R ");
    double interestReceived = sc.nextDouble();
    System.out.print("Capital Gains: R ");
    double capitalGains = sc.nextDouble();

    System.out.print("Retirement Fund: R ");
    double retirementFund = sc.nextDouble();
    System.out.print("Travel Allowance: R ");
    double travelAllowanceReceived = sc.nextDouble();

    System.out.print("Medical Credits: R ");
    double medicalCredits = sc.nextDouble();
    System.out.print("Primary Rebate: R ");
    double primaryRebate = sc.nextDouble();

    Income income = new Income(salary, bonus, interestReceived, capitalGains);
    Expense expense = new Expense(retirementFund, travelAllowanceReceived);
    Credit credit = new Credit(medicalCredits, primaryRebate);
    TaxTable taxTable = new TaxTable();
    TaxCalculator taxCalculator = new TaxCalculator(income, expense, credit, taxTable);
    System.out.println("Net tax payable is: " + taxCalculator.netTaxPayableTax(income, expense, credit, taxTable));


  }

}
