package com.wenjie.leetcode.hot100.mid;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  142. 环形链表 II、
 * tag: 快慢指针
 * Created on 2022/1/7 9:57
 * @author iswenjie.lu
 */
public class DetectCycle {


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode tag = head;
                while (tag != slow) {
                    tag = tag.next;
                    slow = slow.next;
                }
                return tag;
            }
        }
        return null;

    }

}
