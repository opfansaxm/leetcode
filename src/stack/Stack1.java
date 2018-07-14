package stack;

import java.util.Stack;

public class Stack1 {

  public int evalRPN(String[] tokens) {
    int length = tokens.length;
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < length; i++) {
      switch (tokens[i]) {
        case "+":
          stack.push((Integer.valueOf(stack.pop()) + Integer.valueOf(stack.pop())) + "");
          break;
        case "-":
          stack.push(-(Integer.valueOf(stack.pop()) - Integer.valueOf(stack.pop())) + "");
          break;
        case "*":
          stack.push((Integer.valueOf(stack.pop()) * Integer.valueOf(stack.pop())) + "");
          break;
        case "/":
          int arg1 = Integer.valueOf(stack.pop());
          int arg2 = Integer.valueOf(stack.pop());
          stack.push((arg2 / arg1) + "");
          break;
        default:
          stack.push(tokens[i]);
          break;
      }
    }
    return Integer.valueOf(stack.pop());
  }

}