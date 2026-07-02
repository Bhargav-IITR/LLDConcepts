package org.example.questions.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimplifyDebtAlgo {
    /*
        function to compute the minimum number of transactions for a given list of transactions
        input is a 2d array of transactions [[fron , to, amount]]
     */
    public int minTransfer(int[][] transactions){
        // first compute the balance for each user : inflow - outflow
        Map<Integer, Integer> userVsBalance = new HashMap<>();
        for(int [] txn : transactions){
            int from = txn[0];
            int to = txn[1];
            int amount = txn[2];
            userVsBalance.put(from, userVsBalance.getOrDefault(from, 0) - amount);
            userVsBalance.put(to, userVsBalance.getOrDefault(to, 0) + amount);
        }
        List<Integer> balances = new ArrayList<>();
        for(int amount : userVsBalance.values()){
            if(amount != 0) {
                balances.add(amount);
            }
        }

        return dfs(balances, 0);
    }

    private int dfs(List< Integer> balances, int currentIdx){
        if(balances.size() == 0 || currentIdx >= balances.size()) return 0;

        int currentVal = balances.get(currentIdx);
        int minTxns = Integer.MAX_VALUE;

        for(int nextIdx = currentIdx + 1 ; nextIdx < balances.size() ; nextIdx++){
            int nextVal = balances.get(nextIdx);
            if(currentVal*nextVal < 0){
                balances.set(nextIdx , currentVal + nextVal);
                minTxns = Math.min(minTxns, 1 + dfs(balances, currentIdx+1));
                balances.set(nextIdx, nextVal);
                if(currentVal + nextVal == 0) break;
            }
        }
        return minTxns;
    }
}
