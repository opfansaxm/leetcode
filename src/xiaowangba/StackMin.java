package xiaowangba;

import java.util.Stack;

public class StackMin {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else {
            int value = stack2.peek();
            if (value > node) {
                stack2.push(node);
            } else {
                stack2.push(value);
            }
        }

    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        StackMin min = new StackMin();
        min.push(3);
        min.push(1);
        min.push(7);
        min.push(0);
        System.out.println(min.min());

    }
}

