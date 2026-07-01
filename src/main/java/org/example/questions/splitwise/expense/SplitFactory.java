package org.example.questions.splitwise.expense;

import org.example.questions.splitwise.expense.Split.EqualExpenseSplit;
import org.example.questions.splitwise.expense.Split.ExpenseSplit;
import org.example.questions.splitwise.expense.Split.PercentageExpenseSplit;
import org.example.questions.splitwise.expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public static ExpenseSplit getSplitObject(SplitType splitType) {

        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new PercentageExpenseSplit();
            default:
                return null;
        }
    }
}
