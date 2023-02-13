package ood.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Transactions {

    private static class Transaction {
        Map<String, Integer> store;
        Map<String, Integer> originalStore;

        Transaction(Map<String, Integer> store, Map<String, Integer> originalStore) {
            this.store = store;
            this.originalStore = originalStore;
        }
    }

    private Map<String, Integer> store = new HashMap<>();
    private Map<String, Integer> originalStore;
    private Stack<Transaction> transactions = new Stack<>();

    public void set(String key, int value) {
        if (!transactions.empty()) {
            transactions.peek().store.put(key, value);
        } else {
            store.put(key, value);
        }
    }

    public int get(String key) {
        if (!transactions.empty()) {
            Map<String, Integer> transaction = transactions.peek().store;
            if (transaction.containsKey(key)) {
                return transaction.get(key);
            }
        }
        return store.get(key);
    }

    public void delete(String key) {
        if (!transactions.empty()) {
            transactions.peek().store.remove(key);
        } else {
            store.remove(key);
        }
    }

    public void begin() {
        Map<String, Integer> storeCopy;
        if(!transactions.isEmpty()){
            storeCopy = new HashMap<>(transactions.peek().store);
            transactions.peek().originalStore = new HashMap<>(transactions.peek().store);
        } else {
            this.originalStore = new HashMap<>(store);
            storeCopy = new HashMap<>(store);
        }
        transactions.push(new Transaction(new HashMap<>(storeCopy), new HashMap<>(storeCopy)));
    }

    public void commit() {
        if (transactions.empty()) {
            System.out.println("No transaction to commit");
            return;
        }
        Transaction currentTransaction = transactions.pop();
        if (!transactions.empty()) {
            transactions.peek().store = currentTransaction.store;
        } else this.store = currentTransaction.store;
    }

    public void rollback() {
        if (transactions.empty()) {
            this.store = this.originalStore;
            return;
        } else {
            transactions.peek().store = transactions.peek().originalStore;
        }
    }

    public static void main(String[] args){
        Transactions transactions = new Transactions();
        transactions.set("jivan",1);
        transactions.set("jivan",2);

        transactions.begin();
        transactions.set("jivan",3);
            System.out.println("starting n2");
            transactions.begin();
            transactions.set("jivan",4);
                    transactions.begin();
                    transactions.set("jivan",5);
                    transactions.commit();
                    transactions.rollback();
            transactions.set("jivan",6);
            transactions.commit();
            transactions.rollback();
        transactions.commit();
        System.out.println(transactions.get("jivan"));

    }
}
