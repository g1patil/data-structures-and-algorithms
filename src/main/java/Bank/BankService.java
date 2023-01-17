package Bank;

import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    Map<String,Integer> bankToInternalStore = new HashMap<>();
    Map<String,List<String>> bankToAccountMStore = new HashMap<>();

    int accountToProcess = 20;

    /**
     * init banks
     * */
    public void initializeBanks(@NonNull String bankName , @NonNull List<String> account , int interval){
        bankToInternalStore.put(bankName , interval);
        bankToAccountMStore.put(bankName,account);
    }

    public Map<String,List<String>> getAccountToUpdate( int interval){
        if (interval < 0)
            return new HashMap<>();
        Map<String,List<String>> accountToUpdate = new HashMap<>();

        for (Map.Entry<String,Integer> entry : bankToInternalStore.entrySet()){
            int numberOfAccount = bankToAccountMStore.get(entry.getKey()).size();
            int bucketSize = numberOfAccount/bankToInternalStore.get(entry.getKey());
            System.out.println(bucketSize);

            int startingIndex = interval % entry.getValue() * bucketSize ;
            List<String> accounts = bankToAccountMStore.get(entry.getKey())
                    .subList(startingIndex ,  Math.min(startingIndex + bucketSize , bankToAccountMStore.get(entry.getKey()).size() ));
                bankToAccountMStore.get(entry.getKey());
                accountToUpdate.put( entry.getKey() , accounts);

        }
        return accountToUpdate;
    }

    @Test
    public void test(){
        String bank1 = "Chase";
        List<String> account1 = new ArrayList<>();
        account1.add("c12");
        account1.add("c13");
        account1.add("c14");
        account1.add("c15");
        account1.add("c16");
        account1.add("c17");

        String bank2 = "BoFa";
        List<String> account2 = new ArrayList<>();
        account2.add("b12");
        account2.add("b12");

        BankService bankService = new BankService();
        bankService.initializeBanks(bank1 , account1 , 2);
        bankService.initializeBanks(bank2 , account2 , 20);

        System.out.println(bankService.getAccountToUpdate(1));


    }
}
