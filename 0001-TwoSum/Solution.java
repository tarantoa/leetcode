import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complement_indexes = new HashMap<>();
        
        for (int idx = 0; idx < nums.length; ++idx) {
            int complement = target - nums[idx];
            if (complement_indexes.containsKey(complement)) {
                return new int[] { idx, complement_indexes.get(complement) };
            } else {
                complement_indexes.put(nums[idx], idx);
            }
        }
        
        return new int[] {};
    }
}