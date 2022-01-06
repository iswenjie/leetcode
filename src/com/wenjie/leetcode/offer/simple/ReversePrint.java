package com.wenjie.leetcode.offer.simple;

import java.util.Deque;
import java.util.LinkedList;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  06. 从尾到头打印链表
 * Tag: 链表
 * Created on 2022/1/6 10:25
 * @author iswenjie.lu
 */
public class ReversePrint {

    /**
     * 常规方法利用队列
     * @param head head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int[] ans = new int[deque.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = deque.pop();
        }
        return ans;

    }

    /**
     * 先计算数组长度，再从尾巴开始设置数组的制
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        int size = 0;
        ListNode tmp = head;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = head.val;
            head = head.next;
        }
        return ans;
    }

}
