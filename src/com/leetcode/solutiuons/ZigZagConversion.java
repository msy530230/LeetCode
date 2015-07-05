package com.leetcode.solutiuons;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this: (you may want to display this pattern in a fixed font for
 * better legibility)
 * 
 * P A H N A P L S I I G Y I R And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 * 
 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3) should
 * return "PAHNAPLSIIGYIR".
 * 
 * @author zhaoyang
 * 
 */
public class ZigZagConversion {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public String convert(String s, int numRows) {
    if (null == s) {
      return s;
    }
    int strLen = s.length();
    String forReturn = "";
    // 添加每一行的内容
    for (int i = 0; i <= numRows; i++) {
      // 第一行只包括
      // 当前行的内容包括两部分
      // 下行部分数据 循环次数*一次循环大小 + i
      // 上行部分数据 (循环次数 +1)*一次循环大小 -(i-1)
      if (0 == i || numRows - 1 == i) {

      }
    }
    return s;
  }
}
