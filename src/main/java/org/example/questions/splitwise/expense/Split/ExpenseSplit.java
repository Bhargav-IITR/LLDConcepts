package org.example.questions.splitwise.expense.Split;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
