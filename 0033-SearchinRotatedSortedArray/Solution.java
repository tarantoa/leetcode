class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        
        // Find pivot index
        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[middleIndex] > nums[rightIndex]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        
        int startIndex = leftIndex;
        leftIndex = 0;
        rightIndex = nums.length - 1;
        
        // Find what side of the pivot the target is on
        if (target >= nums[startIndex] && target <= nums[rightIndex]) {
            leftIndex = startIndex;
        } else {
            rightIndex = startIndex;
        }
        
        // Search one side of pivot
        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] > target) {
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
            }
        }
        
        return -1;
    }
}