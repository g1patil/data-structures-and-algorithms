import lombok.NonNull;

import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author g1patil
 */
public class SomeTestClass {
    private static final int MIN_TRANSACTIONS = 3 ;
    private static final double VARIATION_PERCENTAGE = 0.2 ;

    @Override
    public List<String> getCompaniesWithRecurringTransactions(Transaction[] transactions) {
        Preconditions.checkArgument(transactions!=null && transactions.length > 0 , "Invalid Input");

        List<String> companies = new ArrayList<>();
        Map<String, List<Transaction>> transactionsMap = buildTransactionMap(transactions);

        for(String company : transactionsMap.keySet()) {
            List<Transaction> listOfTransactions = transactionsMap.get(company);
            if(listOfTransactions.size() < MIN_TRANSACTIONS) {
                continue;
            }

            if(hasRecurringTransactionsVariation(listOfTransactions)) {
                companies.add(company);
            }
        }
        return companies;
    }

    @Override
    public Set<Transaction> getConcurrentTransactions(@NonNull final List<Transaction> transactions){
        if (transactions.isEmpty())
            return new HashSet<>();

        Set<Transaction> result = new HashSet<>();
        Collections.sort(transactions , Comparator.comparing(Transaction::getTimestamp));
        for (int i = 0; i < transactions.size() - 1; i++) {
            if (transactions.get(i).getTimestamp().equals(transactions.get(i+1).getTimestamp())){
                result.add(transactions.get(i));
                result.add(transactions.get(i+1));
            }
        }
        return result;
    }

    private Map<String, List<Transaction>> buildTransactionMap(final Transaction[] transactions){
        Map<String, List<Transaction>> transactionsMap = new HashMap<>();
        for(Transaction t : transactions) {
            List<Transaction> listOfTransactions = transactionsMap.getOrDefault(t.getName().toLowerCase(), new ArrayList<>());
            listOfTransactions.add(t);
            transactionsMap.put(t.getName(), listOfTransactions);
        }
        transactionsMap.keySet().stream().forEach(t->{
            transactionsMap.get(t).sort(Comparator.comparing(o -> o.getTimestamp()));
        });
        return transactionsMap;
    }


    public boolean hasRecurringTransactionsNoVariation(List<Transaction> transactions){
        Long previousDifference = 0L ;
        Transaction previousTransaction = transactions.get(0);

        for (int i = 1; i < transactions.size(); i++) {
            Transaction currentTransaction = transactions.get(i);
            Long currentDiff = ChronoUnit.DAYS.between(previousTransaction.getTimestamp() , currentTransaction.getTimestamp());

            if (currentDiff.equals(previousDifference) && currentTransaction.getAmount() == previousTransaction.getAmount()){
                return true;
            } else {
                previousTransaction = currentTransaction;
                previousDifference = currentDiff;
            }
        }
        return false;
    }
    public boolean hasRecurringTransactionsVariation(List<Transaction> transactions) {
        double amountVariation = 0 ;
        Queue<Transaction> transactionQueue = new PriorityQueue<>(Comparator.comparingDouble(o->o.getAmount()));

        for (Transaction transaction : transactions){
            if (transactionQueue.isEmpty() || (transaction.getAmount() <= amountVariation)){
                transactionQueue.add(transaction);
            } else {
                transactionQueue.poll();
                transactionQueue.add(transaction);
            }
            amountVariation = transactionQueue.peek().getAmount() + transactionQueue.peek().getAmount() * VARIATION_PERCENTAGE;

            if (transactionQueue.size() >= 3){
                System.out.println(transactionQueue);
            }
        }
        return false;
    }
}
