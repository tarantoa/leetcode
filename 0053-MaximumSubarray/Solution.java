class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int localMax = nums[0];
        int globalMax = nums[0];
        
        for (int idx = 1; idx < nums.length; idx++) {
            localMax = Math.max(nums[idx], nums[idx] + localMax);
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
}