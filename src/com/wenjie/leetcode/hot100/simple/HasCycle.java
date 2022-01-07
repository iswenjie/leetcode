package com.wenjie.leetcode.hot100.simple;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  141. 环形链表
 * tag: 快慢指针
 * Created on 2022/1/7 10:12
 * @author iswenjie.lu
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        if (slow == null) {
            return false;
        }
        ListNode quick = head.next;
        while (true) {
            if (slow == null || quick == null || quick.next == null) {
                return false;
            }
            if (slow == quick) {
                return true;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
    }

}
