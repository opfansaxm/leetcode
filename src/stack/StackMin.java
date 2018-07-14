package stack;

import java.util.Stack;

public class StackMin {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();


    public void push(int node) {
        stack.push(node);
        if (stackMin.isEmpty() || node < stackMin.peek())
            stackMin.push(node);
    }

    public void pop() {
        int val = stack.pop();
        if (val == stackMin.peek())
            stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}

