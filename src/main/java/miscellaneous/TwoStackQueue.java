package miscellaneous;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class TwoStackQueue {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void push(int i){
        s1.push(i);
    }

    public int pop(){
        if(s2.isEmpty()){
            if(s1.isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    @Test
    public void test(){
        TwoStackQueue stackQueue = new TwoStackQueue();
        stackQueue.push(1);
        stackQueue.push(2);
        stackQueue.push(3);

        System.out.println(stackQueue.pop());
        stackQueue.push(4);
        stackQueue.push(5);
        stackQueue.push(6);
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());
        System.out.println(stackQueue.pop());

    }
}
