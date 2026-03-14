package trees;

import annotation.Platform;
import annotation.Quality;
import annotation.Site;
import annotation.Stage;

import java.util.Stack;

/**
 * @author g1patil
 * 155. Min Stack
 */
@Quality(Stage.TESTED)
@Platform(Site.LEETCODE)
public class MinStack {

    private Stack<int[]> stack = new Stack();
    int min = Integer.MAX_VALUE;

    public MinStack() {
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new int[]{val , val});
        } else{
            stack.push(new int[]{val , Math.min(val,stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return  stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}
