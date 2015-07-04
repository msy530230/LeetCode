package com.leetcode.solutiuons;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author zhaoyang
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    int a = lengthOfLongestSubstring("bpfbhmipx");
    System.out.println(a);
  }

  public static int lengthOfLongestSubstring(String s) {
    // if (null == s || "".equals(s)) {
    // throw (new IllegalArgumentException("字符串长度不能为空"));
    // }
    int maxLen = 0;
    // 插入指针
    int frontIndex = 0;
    // 删除指针
    int rearIndex = 0;
    // 存储字符
    Map<String, String> charMap = new HashMap<>();
    char[] chars = s.toCharArray();
    while (frontIndex < chars.length) {
      // 不重复
      if (null != charMap.get(String.valueOf(chars[frontIndex]))) {
        // 重复
        maxLen = Math.max(maxLen, charMap.size());
        // 删除指针找到上一次重复位置
        while (chars[rearIndex] != chars[frontIndex]) {
          charMap.remove(String.valueOf(chars[rearIndex]));
          rearIndex++;
        }
        // 后移一位，删除当前位置
        rearIndex++;
      }
      charMap.put(String.valueOf(chars[frontIndex]), String.valueOf(chars[frontIndex]));
      frontIndex++;
    }

    return Math.max(maxLen, charMap.size());
  }
}
