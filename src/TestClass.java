import data.TreeNode;
import org.junit.jupiter.api.Test;

import java.sql.PreparedStatement;
import java.util.*;

/**
 * Test class to practice any given problem .
 * This class serves as the template class for any coding practices that I do.
 * */


public class TestClass {

    public static class Transaction {
        String company;
        double amount;
        int timestamp;

        public Transaction(String company, double amount, int timestamp) {
            this.company = company;
            this.amount = amount;
            this.timestamp = timestamp;
        }
    }

    public List<String> getCompaniesWithRecurringTransactions(Transaction[] transactions) {
        List<String> companies = new ArrayList<>();
        if(transactions == null || transactions.length == 0) {
            return companies;
        }

        Map<String, List<Transaction>> transactionsMap = new HashMap<>();
        for(Transaction t : transactions) {
            List<Transaction> listOfTransactions = transactionsMap.getOrDefault(t.company, new ArrayList<>());
            listOfTransactions.add(t);
            transactionsMap.put(t.company, listOfTransactions);
        }

        for (Map.Entry<String, List<Transaction>> e : transactionsMap.entrySet()){
            String result = getRecurring(e.getValue() , e.getKey());
            if (result !=null)
                companies.add(result);
        }
        return companies;
    }

    private List<List<Transaction>> getEqualTransactions(List<Transaction> value) {
        Map<Double , List<Transaction>>  tranMap = new HashMap<>();
        List<List<Transaction>> result = new ArrayList<>();

        for (Transaction t : value ){
            if (tranMap.containsKey(t.amount)){
                tranMap.get(t.amount).add(t);
            } else {
                tranMap.put(t.amount , new ArrayList<>());
                tranMap.get(t.amount).add(t);
            }
        }

        for (List<Transaction> list : tranMap.values() ){
            if (list.size() >=3)
                result.add(list);

        }
        return result;
    }

    private String getRecurring(List<Transaction> transactions, String company){
        Map<Integer,Integer> freq  = new HashMap<>();
        for (int i = 0; i < transactions.size() - 1; i++) {
            Transaction current = transactions.get(i);
            for (int j = i + 1; j < transactions.size(); j++) {
                int timeDiff = current.timestamp = transactions.get(j).timestamp;
                freq.put( timeDiff , freq.getOrDefault(timeDiff , 0 ) + 1 );
            }
        }

        for (int v : freq.values())
            if (v >=2)
                return company;
        return null;
    }




    public static void main(String[] args) {
        TestClass obj = new TestClass();

        Transaction[] transactions = new Transaction[] {
                new Transaction("Netflix", 9.99, 1),
                new Transaction("Netflix", 9.99, 6),
                new Transaction("Netflix", 9.99, 11),
                new Transaction("Netflix", 9.99, 13),
                new Transaction("Netflix", 9.99, 27)};


        List<String> result = obj.getCompaniesWithRecurringTransactions(transactions);
        System.out.println("The companies with recurring transactions are: " + result);
    }
}
