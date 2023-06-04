package easy_questions;

import java.util.Stack;

public class MinStack {
    private Stack<Integer[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int minElem = val;
        if (!this.stack.isEmpty() && this.stack.peek()[1] < minElem) {
            minElem = this.stack.peek()[1];
        }
        this.stack.push(new Integer[]{val, minElem});
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}
