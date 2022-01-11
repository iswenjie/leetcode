package com.wenjie.leetcode.hot100.simple;

import java.util.Deque;
import java.util.LinkedList;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  206. 反转链表
 * Created on 2022/1/8 17:33
 * @author iswenjie.lu
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        new ReverseList().reverseList2(node);
    }

    /**
     * 一次遍历 最快
     * @param head 原链表
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            // a->b->c-> 将箭头反转方向
            curr.next = pre;
            // 重新赋值进入循环
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseListUseStack(ListNode head) {
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode ans = new ListNode(-1);
        ListNode p = ans;
        while (!stack.isEmpty()) {
            p.next = stack.pop();
            p = p.next;
        }
        p.next = null;
        return ans.next;
    }

}
