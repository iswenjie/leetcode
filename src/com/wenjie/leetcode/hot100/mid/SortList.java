package com.wenjie.leetcode.hot100.mid;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  148. 排序链表
 * tag: 归并排序
 * Created on 2022/1/8 9:45
 * @author iswenjie.lu
 */
public class SortList {

    /**
     * 自顶而下归并排序
     * @param head l
     * @return sorted
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // slow.next = null 所以尾巴一定是null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        // 截断链表
        slow.next = null;
        return merge(sortList(head), sortList(head2));
    }

    /**
     * 自底向上归并排序
     * @param head l
     * @return sorted
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 统计链表长度
        int length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        ListNode headTag = new ListNode(0, head);
        // 每次将链表分割成长度为subLen的链表在两两合并
        // 一轮后将subLen乘以2，就是合并上一步完成排序的两个链表
        for (int subLen = 1; subLen < length; subLen <<= 1) {
            //要排序的链表前面的指针，为了赋值next
            ListNode pre = headTag;
            // 当前要处理链表的起点，即将要分割成两份长度为subLen的链表
            ListNode curr = headTag.next;
            while (curr != null) {
                // 长度为subLen的链表1
                ListNode head1 = curr;
                for (int i = 1; i < subLen && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 长度为subLen的链表1
                ListNode head2 = curr.next;
                // 截断 head1
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLen && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 将剩余的交给left,并截断head2
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                // 合并两个list
                ListNode sorted = merge(head1, head2);
                pre.next = sorted;
                // 移到指针到已排序的末尾（也就是下一次排序的前面一个，首尾呼应）
                while (pre.next != null) {
                    pre = pre.next;
                }
                // 指明下次处理的开始
                curr = next;
            }
        }
        return headTag.next;
    }

    /**
     * 21. 合并两个有序链表
     * @param list1 已经有序的l1
     * @param list2 已经有序的l2
     * @return sorted
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        // 复制移动的指针v
        ListNode p = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list1 == null ? list2 : list1;
        return head.next;
    }

}
