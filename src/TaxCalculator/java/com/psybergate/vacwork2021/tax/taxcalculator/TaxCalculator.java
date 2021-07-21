package com.psybergate.vacwork2021.tax.taxcalculator;

import com.psybergate.vacwork2021.tax.Expense.Expense;
import com.psybergate.vacwork2021.tax.income.Income;
import com.psybergate.vacwork2021.tax.taxtable.TaxTable;
import com.psybergate.vacwork2021.tax.credit.Credit;

public class TaxCalculator {

  private final Income income;

  private final Expense expense;

  private final TaxTable taxTable;

  private final Credit credit;

  public TaxCalculator(Income income, Expense expense, Credit credit, TaxTable taxTable) {
    this.income = income;
    this.expense = expense;
    this.taxTable = taxTable;
    this.credit = credit;
  }
//  public TaxCalculator(){
//
//  }

  public double netTaxPayableTax(Income income, Expense expense, Credit credit, TaxTable taxTable) {
    double totalIncome = Income
        .calculateTotalIncome(income.getSalary(), income.getBonus(), income.getInterestReceived(),
            income.getTotalCapitalGains());
    double totalExpenses = expense.calculateTotalExpenses(expense.getRetirementFund(), expense.getTravelAllowance());
    double taxPayable = taxTable.payableTax((totalIncome - totalExpenses));
    return taxPayable - credit.totalCredits(credit.getMedicalCredits(), credit.getPrimaryRebate());
  }

}
