class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int left = 0;
        for (int right = 1; right < nums.length; ++right) {
            if (nums[right] != nums[left]) {
                nums[++left] = nums[right];
            }
        }

        return left + 1;
    }
}