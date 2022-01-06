class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null) return null;
        
        int[] output = new int[nums.length];
        output[0] = 1;
        
        for (int idx = 1; idx < output.length; ++idx) {
            output[idx] = output[idx - 1] * nums[idx - 1];
        }
        
        int prod = 1;
        for (int idx = nums.length - 2; idx >= 0; --idx) {
            prod *= nums[idx + 1];
            output[idx] *= prod;
        }
        
        return output;
    }
}