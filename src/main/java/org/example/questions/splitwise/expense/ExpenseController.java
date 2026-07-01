package org.example.questions.splitwise.expense;

import org.example.questions.splitwise.balanceSheet.BalanceSheetController;
import org.example.questions.splitwise.expense.Split.Split;
import org.example.questions.splitwise.user.User;
import org.example.questions.splitwise.expense.Split.ExpenseSplit;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        this.balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidBy, SplitType splitType, List<Split> splitDetails){
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);
        Expense expense = new Expense(expenseId, description, expenseAmount, paidBy, splitType, splitDetails);
        balanceSheetController.updateBalanceSheet(paidBy, splitDetails, expenseAmount);
        return expense;
    }
}
