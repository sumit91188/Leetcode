package interview.amazon.minStack;

/**
 * @author sumitdeo
 * @projectName AmazonSDEQues
 * @package com.sdeo.medium.minStack
 * @date 10/4/20
 * @comment:
 */
public class TestClient {
  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.top());
    System.out.println(minStack.getMin());
  }
}
