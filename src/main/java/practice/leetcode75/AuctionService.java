package practice.leetcode75;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AuctionService {

    Map<Integer,Container> containerAuctionMap = new HashMap<>();

    public void putForSell(Container container){
        containerAuctionMap.put(container.id , container);
    }

    public void placeBid(Bid bid){
        containerAuctionMap.get(bid.containerId).bidQueue.add(bid);
    }

    public Bid selectTopBidder(int id){
        return containerAuctionMap.get(id).getBidQueue().peek();
    }


    @Test
    public void test(){
        this.putForSell(new Container(1,20, new PriorityQueue<>()));

        Bid bid1 = new Bid(1,1,"test1",21);
        Bid bid2 = new Bid(2,1,"test1",24);
        Bid bid3 = new Bid(3,1,"test1",27);

        placeBid(bid1);
        placeBid(bid2);
        placeBid(bid3);

        System.out.println(selectTopBidder(1));
    }
}

@Data
@AllArgsConstructor
class Container {
    int id;
    double askingPrice;
    Queue<Bid> bidQueue;
}

@Data
@AllArgsConstructor
class Bid implements Comparable {
    int id;
    int containerId;
    String bidderName;
    double offerPrice;


    @Override
    public int compareTo(@NonNull Object  o){
        Bid b = (Bid) o;
        return Double.compare(b.offerPrice , this.offerPrice);
    }
}
