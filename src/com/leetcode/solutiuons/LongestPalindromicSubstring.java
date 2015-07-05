package com.leetcode.solutiuons;


/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author zhaoyang
 * 
 */
public class LongestPalindromicSubstring {

  public static void main(String[] args) {
  }

  public String longestPalindrome2(String s) {
    // 回文有两种中心对城以及非对称
    if (null == s || 1 >= s.length())
      return null;
    int maxLen = 0;
    String longestStr = null;
    int length = s.length();
    // 中心对称
    for (int i = 0; i < length; i++) {
      for (int pre = i, rear = i; pre >= 0 && rear < length; pre--, rear++) {
        if (s.charAt(pre) == s.charAt(rear)) {
          if (maxLen < rear - pre + 1) {
            maxLen = rear - pre + 1;
            longestStr = s.substring(pre, rear + 1);
          }
        }
      }
      // 非中心对称
      for (int pre = i, rear = i + 1; pre >= 0 && rear < length; pre--, rear++) {
        if (s.charAt(pre) == s.charAt(rear)) {
          if (maxLen < rear - pre + 1) {
            maxLen = rear - pre + 1;
            longestStr = s.substring(pre, rear + 1);
          }
        }
      }
    }
    return longestStr;
  }

  public String longestPalindrome(String s) {
    // 回文有两种中心对城以及非对称
    if (null == s || 1 >= s.length())
      return null;
    int maxLen = 0;
    String longestStr = null;
    int length = s.length();
    int[][] table = new int[length][length];
    // 所有单个字符本身都是回文
    for (int i = 0; i < length; i++) {
      table[i][i] = 1;
    }
    // 两个相邻字符相同也是回文
    for (int i = 0; i < length - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        table[i][i + 1] = 1;
        longestStr = s.substring(i, i + 2);
      }
    }
    // 动态规划
    for (int i = length - 1; i > 0; i--) {
      for (int j = i + 1; j < length; j++) {
        if (s.charAt(i) == s.charAt(j) && 1 == table[i + 1][j - 1]) {
          table[i][j] = 1;
          if (maxLen < j - 1 + 1) {
            maxLen = j - i + 1;
            longestStr = s.substring(i, i + maxLen);
          }
        }
      }
    }
    return longestStr;
  }
}
