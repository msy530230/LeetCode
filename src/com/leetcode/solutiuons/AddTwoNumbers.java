package com.leetcode.solutiuons;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * 
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode five = new ListNode(5);
    addTwoNumbers(five, five);
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode rear = new ListNode(0);
    ListNode point = rear;
    int sum = 0;
    // 非空判断
    if (null == l1 && null == l2) {
      throw (new IllegalArgumentException("长度不能为0"));
    }
    while (null != l1 || null != l2) {
      if (null != l1) {
        sum += l1.val;
        l1 = l1.next;
      }
      if (null != l2) {
        sum += l2.val;
        l2 = l2.next;
      }
      point.next = new ListNode(sum % 10);
      point = point.next;
      sum /= 10;
    }
    if (sum != 0) {
      point.next = new ListNode(sum % 10);
    }
    return rear.next;
  }

}
