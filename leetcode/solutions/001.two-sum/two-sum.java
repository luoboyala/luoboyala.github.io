import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 *
 * https://leetcode.com/problems/two-sum/description/
 *
 * algorithms
 * Easy (40.69%)
 * Total Accepted:    1.4M
 * Total Submissions: 3.5M
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // // brute force
        // for (int i = 0; i < nums.length; i++) {
        // int start = nums[i];
        // for (int j = i + 1; j < nums.length; j++) {
        // if (nums[j] == target - start) {
        // return new int[] { i, j };
        // }
        // }

        // }

        // // hash map two-pass
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // map.put(nums[i], i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        // int last = target - nums[i];
        // if (map.containsKey(last) && map.get(last) != i) {
        // return new int[] { i, map.get(last) };
        // }
        // }
        // hash map one-pass
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // at the first, the hashmap is empty and do the false if condition
            // then put key and value into hashmap
            // the next circle is the same and if there comes a match answer
            // this answer must be putted into map before.
            int last = target - nums[i];
            if (map.containsKey(last) && map.get(last) != i) {
                return new int[] { i, map.get(last) };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
