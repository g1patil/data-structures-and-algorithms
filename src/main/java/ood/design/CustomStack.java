package ood.design;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

/**
 * 1381. Design a Stack With Increment Operation
 * Learning : go one by one. Test it early.
 * Start with small inputs, and then fail it.
 * */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE
)
public class CustomStack {

    private int pointer;
    private int[] stack;

    public CustomStack(int maxSize) {
        stack = new int[maxSize+1];
        pointer = 1;
    }

    public void push(int x) {
        if(pointer >= stack.length)
            return;
        stack[pointer++] = x;
    }

    public int pop() {
        if(pointer==1)
            return -1;
        int val = stack[--pointer];
        stack[pointer]=0;
        return val;
    }

    public void increment(int k, int val) {
        for(int i = 1; i <= Math.min(pointer-1,k) ; i++) {
            stack[i]+=val;
        }
    }

    public static void main(String[] args){
        CustomStack stack1 = new CustomStack(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);

        stack1.increment(1,1);

        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
    }
}
