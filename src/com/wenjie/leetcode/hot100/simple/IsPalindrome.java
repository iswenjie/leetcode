package com.wenjie.leetcode.hot100.simple;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  234. 回文链表
 * Created on 2022/1/11 11:38
 * @author iswenjie.lu
 */
public class IsPalindrome {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = reverseList(slow.next);
        while (fast != null) {
            if (head.val != fast.val) {
                return false;
            }
            fast = fast.next;
            head = head.next;
        }
        return true;

    }


    public ListNode reverseList(ListNode node) {
        ListNode pre = null;
        // 反转后半部分链表
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
