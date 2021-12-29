package com.wenjie.leetcode.hot100.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:  155. 最小栈
 * Created on 2021/12/29 10:49
 * @author iswenjie.lu
 */
public class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> min;

    public MinStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        data.push(val);
        min.push(Math.min(min.peek(), val));
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

}
