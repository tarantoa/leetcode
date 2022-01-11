class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return -4;
        }
        
        int uniqueVal = nums[0];
        for (int idx = 1; idx < nums.length; ++idx) {
            uniqueVal ^= nums[idx];
        }
        
        return uniqueVal;
    }
}