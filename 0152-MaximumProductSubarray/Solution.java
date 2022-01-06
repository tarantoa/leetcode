class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null) return 0;
        
        int localMin, localMax, globalMax;
        localMin = localMax = globalMax= nums[0];
        
        for (int idx = 1; idx < nums.length; idx++) {
            int temp = localMin;
            
            localMin = min(nums[idx], nums[idx] * temp, nums[idx] * localMax);
            localMax = max(nums[idx], nums[idx] * temp, nums[idx] * localMax);
            globalMax = Math.max(globalMax, localMax);
        }
        
        return globalMax;
    }
    
    private int max(int value1, int value2, int value3) {
        return Math.max(value1, Math.max(value2, value3));
    }
    
    private int min(int value1, int value2, int value3) {
        return Math.min(value1, Math.min(value2, value3));
    }
}