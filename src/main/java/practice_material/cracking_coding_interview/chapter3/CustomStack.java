package practice_material.cracking_coding_interview.chapter3;

/**
 * @author g1patil
 */
public class CustomStack {
    static final int CAPACITY = 10;
    private int HEAD = -1 ;
    private int SIZE = 0 ;
    private int[] elements;

    public CustomStack(){
        elements = new int[CAPACITY];
    }

    private void increaseCapacity(){
        int[] newElements = new int[SIZE + CAPACITY];
        for (int i = 0; i < SIZE; i++) {
            newElements[i] = elements[i];
        }
    }

    public void push(int e_){
        if (!hasCapacity())
            increaseCapacity();
        int newPosition = HEAD + 1 ;
        elements[newPosition] = e_ ;
        HEAD++;
        SIZE++;
    }

    private boolean hasCapacity(){
        return SIZE == CAPACITY;
    }

    public boolean isEmpty(){
        return SIZE == 0 ;
    }

    public int getSize(){
        return SIZE;
    }

    public int peek(){
        return elements[HEAD];
    }

    public int pop(){
        if (SIZE == 0)
            throw new StackError("CustomStack is empty");
        SIZE -- ;
        return elements[HEAD--];
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);

    }
}

class StackError extends RuntimeException{
    public StackError(String message){
        super(message);
    }
}
