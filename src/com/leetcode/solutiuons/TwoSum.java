package com.leetcode.solutiuons;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author zhaoyang
 * 
 */

public class TwoSum {

  public static void main(String[] args) {

  }

  public int[] twoSum(int[] nums, int target) {
    // 输入长度小于2时抛出异常
    if (null == nums || 2 > nums.length) {
      throw (new IllegalArgumentException());
    }
    // 存储每一位
    Map<Integer, Integer> indexMap = new HashMap<>();
    // IntStream.range(0,nums.length).forEach(i->{indexMap.put(Integer.valueOf(nums[i]),
    // Integer.valueOf(i))});
    for (int i = 0; i < nums.length; i++) {
      indexMap.put(Integer.valueOf(nums[i]), Integer.valueOf(i));

    }
    // 查找和当前位置能够加和target的数字是否存在
    for (int i = 0; i < nums.length; i++) {
      if (null != indexMap.get(Integer.valueOf(target - nums[i]))) {
        // 两个数相同时且作为解，只有一种，是target的1/2,并且其出现两次才可
        // 存在的场合
        int position = indexMap.get(Integer.valueOf(target - nums[i])).intValue();
        if (i == position) {
          continue;
        }
        if (i > position) {
          // 交换位置
          int temp = i;
          i = position;
          position = temp;
        }
        // 位置是索引加1
        nums = new int[] { i + 1, position + 1 };
        return nums;
      }
    }
    return null;
  }
}
