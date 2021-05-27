package gamemodeling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Item{
    final int LIMIT = 6;

    List<Item> itemList = new ArrayList<>();

    public boolean addItem(final Item item){
        if(itemList.size() >= LIMIT && !containsBag()){
            return false;
        }

        if(itemList.size() < LIMIT){
            return itemList.add(item);
        }
        for(Item item1 : this.itemList){
            if(item1 instanceof Bag){
                return ((Bag) item1).addItem(item);
            }
        }
        return false;
    }

    private boolean containsBag(){
        return itemList.stream().anyMatch(item -> item instanceof Bag);
    }

    @Test
    public void test(){
        Bag bag = new Bag();
        Item i1 = new Bag();
        Item i2 = new Bag();
        Item i3 = new Bag();
        Item i4 = new Bag();
        Item i5 = new Bag();
        Bag interNalBag = new Bag();

        Item specialItem = new Bag();

        bag.addItem(i1);
        bag.addItem(i2);
        bag.addItem(i3);
        bag.addItem(i4);
        bag.addItem(i5);
        bag.addItem(interNalBag);

        bag.addItem(specialItem);
    }
}
