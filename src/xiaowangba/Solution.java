package xiaowangba;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {

        if (stack1.empty() && stack2.empty()) {
            stack1.push(node);
            return;
        }
        //只能有一个是空的
        if (stack1.empty()) {
            stack2.push(node);
        } else {
            stack1.push(node);
        }

    }

    public int pop() {
        Stack<Integer> stack;
        //stack1:不空，stack2:空
        if (stack1.empty() && !stack2.empty()) {
            stack = stack2;
            stack2 = stack1;
            stack1 = stack;
        }
        if (!stack1.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            int result = stack2.pop();
            while (!stack1.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
        return stack2.pop();
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length > 0) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return array[i+1];
                }
            }
        }
        return 0;
    }
}
