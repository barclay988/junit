package com.psybergate.vacwork2021.tax.taxpayer;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.credit.Credit;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxcalculator.TaxCalculator;

import java.math.BigDecimal;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please enter: ");
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
//    System.out.println("total expeses:"+totalExpense);
//    System.out.println("total income:"+totalIncome);
//    System.out.println("total credits:"+totalCredits);

    // System.out.println("number:"+totalIncome.subtract(totalExpense));


    BigDecimal taxPayable = taxCalculator.payableTax(totalIncome.subtract(totalExpense));
    //System.out.println("payable tax:"+taxPayable);

    System.out.println("Net tax payable is: " + taxCalculator.netTaxPayableTax(totalCredits, taxPayable));

  }

}
