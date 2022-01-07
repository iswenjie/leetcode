package com.wenjie.leetcode.offer.simple;

import java.util.Stack;

/**
 * Description:  剑指 Offer 09. 用两个栈实现队列
 * Created on 2022/1/6 11:23
 * @author iswenjie.lu
 */
public class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }

}
