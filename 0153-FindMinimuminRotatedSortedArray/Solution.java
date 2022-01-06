class Solution {
    public int findMin(int[] nums) {
        if (nums == null) return -1;
        
        int left_index = 0;
        int right_index = nums.length - 1;
        
        while (left_index < right_index) {
            int middle_index = left_index + (right_index - left_index) / 2;
            
            if (middle_index > 0 && nums[middle_index] < nums[middle_index - 1]) {
                return nums[middle_index];
            } else if (nums[left_index] <= nums[middle_index] && nums[middle_index] > nums[right_index]) {
                left_index = middle_index + 1;
            } else {
                right_index = middle_index - 1;
            }
        }
        
        return nums[left_index];
    }
}