package org.example.questions.splitwise.balanceSheet;

import org.example.questions.splitwise.expense.Split.Split;
import org.example.questions.splitwise.user.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateBalanceSheet(User paidBy, List<Split> splitDetails, double expenseAmount){
        BalanceSheet paidByUserBalanceSheet = paidBy.getBalanceSheet();
        paidByUserBalanceSheet.setTotalPayment(paidByUserBalanceSheet.getTotalPayment() + expenseAmount);

        for(Split split : splitDetails){
            User userOwe = split.getUser();
            double oweAmount = split.getAmountOwe();
            BalanceSheet userOweBalanceSheet = userOwe.getBalanceSheet();
            
            if(paidBy.getUserId().equals(userOwe.getUserId())){
                paidByUserBalanceSheet.setTotalYourExpense(paidByUserBalanceSheet.getTotalYourExpense() + oweAmount); 
            }else{
                //update balance of paid user
                paidByUserBalanceSheet.setTotalYouGetBack(paidByUserBalanceSheet.getTotalYouGetBack() + oweAmount);
                Balance userOweBalance;
                if(paidByUserBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance = paidByUserBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }else{
                    userOweBalance = new Balance();
                    paidByUserBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);


                //update the balance sheet of owe user
                userOweBalanceSheet.setTotalYouOwe(userOweBalanceSheet.getTotalYouOwe() + oweAmount);
                userOweBalanceSheet.setTotalYourExpense(userOweBalanceSheet.getTotalYourExpense() + oweAmount);

                Balance userPaidBalance;
                if (userOweBalanceSheet.getUserVsBalance().containsKey(paidBy.getUserId())) {
                    userPaidBalance = userOweBalanceSheet.getUserVsBalance().get(paidBy.getUserId());
                } else {
                    userPaidBalance = new Balance();
                    userOweBalanceSheet.getUserVsBalance().put(paidBy.getUserId(), userPaidBalance);
                }
                userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + oweAmount);
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {

        System.out.println("---------------------------------------");

        System.out.println("Balance sheet of user : " + user.getUserId());

        BalanceSheet userExpenseBalanceSheet = user.getBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymnetMade: " + userExpenseBalanceSheet.getTotalPayment());
        for (Map.Entry<String, Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()) {

            String userID = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userID + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("---------------------------------------");

    }
}
