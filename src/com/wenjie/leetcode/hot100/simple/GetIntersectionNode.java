package com.wenjie.leetcode.hot100.simple;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.wenjie.leetcode.common.ListNode;

/**
 * Description:  160. 相交链表
 * Created on 2022/1/8 15:50
 * @author iswenjie.lu
 */
public class GetIntersectionNode {


    /**
     * 双指针走一样的路
     * 1. 假设headA的长度是a+n，headB的长度是b+n（n是相交的长度,可以是0）
     * 2. 当p1走完headA，再走b步相当于(a+n)+b，
     * 3. (a+n)+b也等于(b+n)+a 就等于p2走完headB，再走a步。
     * 4. 此时刚好站在相交点或者null！
     * @param headA l1
     * @param headB l2
     * @return 相交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 2ms
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }
        return pa;
    }

    public ListNode getIntersectionNodeUseHash(ListNode headA, ListNode headB) {
        // 8ms 计算hash比较慢？
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNodeUseStack(ListNode headA, ListNode headB) {
        // 2ms
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        ListNode tmp = headA;
        while (tmp != null) {
            stackA.push(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            stackB.push(tmp);
            tmp = tmp.next;
        }
        ListNode ans = null;
        while (stackA.peek() != null && stackA.peek() == stackB.peek()) {
            ans = stackA.pop();
            stackB.pop();
        }
        return ans;
    }

}
