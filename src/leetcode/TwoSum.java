/*
 Author:     Veronica Kumar
 Date:       Feb 11, 2024
 Problem:    Two Sum
 Difficulty: Medium
 Source:     https://oj.leetcode.com/problems/two-sum/
 Notes:
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, 
 where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 Solution: 1. Hash Map. O(n)
 */

public class Solution {

    //Brute Force
    public int[] twoSum(int[] nums, int target) {
       int result[] = new int[2];
       for(int i =0; i< nums.length; i++) {
           for(int j = i+1; j < nums.length; j++) {
               int newSum = target - nums[i];

               if(nums[j] == newSum) {
                   result[0] = i;
                   result[1] = j;
                   return result;
               }
           }
       }
       return result;
    }

    //HashMap Solution with O(n) complexity.
     public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        //corner cases
        if(nums == null || nums.length == 0 )
            return result;

        HashMap<Integer, Integer> visited = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(visited.containsKey(target - nums[i])) {
                result[0] = visited.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            visited.put(nums[i], i);
        }
        return result;
    }
}
