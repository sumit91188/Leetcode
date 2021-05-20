package interview.amazon.minStack;

import java.util.Stack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium
 * @date 10/4/20
 * @comment: Design a stack that supports push, pop, top, and retrieving the minimum element in
 *     constant time. push(x) — Push element x onto stack. pop() — Removes the element on top of the
 *     stack. top() — Get the top element. getMin() — Retrieve the minimum element in the stack.
 */
public class MinStack {
  int minEle = Integer.MIN_VALUE;
  Stack<Integer> stack = new Stack<>();

  public MinStack() {}

  public void push(int x) {
    if (x <= minEle) {
      stack.push(minEle);
      minEle = x;
    }
    stack.push(x);
  }

  public void pop() {
    if(stack.pop() == minEle) minEle = stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minEle;
  }
}
