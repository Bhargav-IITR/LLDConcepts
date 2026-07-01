package org.example.questions.splitwise.group;
import org.example.questions.splitwise.expense.Expense;
import org.example.questions.splitwise.expense.ExpenseController;
import org.example.questions.splitwise.expense.Split.Split;
import org.example.questions.splitwise.expense.SplitType;
import org.example.questions.splitwise.user.User;

import java.util.ArrayList;
import java.util.List;

public class Group {

    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;

    ExpenseController expenseController;

    Group() {
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    //add member to group
    public void addMember(User member) {
        groupMembers.add(member);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount,
                                 List<Split> splitDetails, SplitType splitType, User paidByUser) {

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
        expenseList.add(expense);
        return expense;
    }
}
