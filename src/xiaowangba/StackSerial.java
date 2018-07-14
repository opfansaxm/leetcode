package xiaowangba;

import java.util.Stack;

public class StackSerial {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int size = pushA.length;
        int i = 0;
        int j = 0;
        while (i < size) {
            while (i< size && popA[j] != pushA[i]) {
                stack.push(pushA[i]);
                i++;
            }
            i++;
            j++;
            if (!stack.empty() && j< size && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        while (j < size) {
            if (stack.peek() != popA[j])
                return false;
            stack.pop();
            j++;
        }
        if (stack.empty())
            return true;
        else
            return false;
    }

    public static boolean IsPopOrder2(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int length = pushA.length;
        int pushIndex = 0;
        int popIndex = 0;
        while (pushIndex < length) {
            if (popA[popIndex] == stack.peek() && !stack.isEmpty()) {
                stack.pop();
                popIndex++;
            } else {
                stack.push(pushA[pushIndex]);
                pushIndex++;
            }
        }

        while (popIndex < length) {
            if (stack.peek() != popA[pushIndex]) {
                return false;
            } else {
                popIndex++;
                stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(StackSerial.IsPopOrder(new int[]{1,2,3,}, new int[]{2}));
    }
}
