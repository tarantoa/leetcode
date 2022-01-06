import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        
        for (int index = 0; index < nums.length - 2; ++index) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            
            int leftIndex = index + 1;
            int rightIndex = nums.length - 1;
            int target = 0 - nums[index];    
            while (leftIndex < rightIndex) {
                int sum = nums[leftIndex] + nums[rightIndex];
                if (sum == target) {
                    triplets.add(Arrays.asList(nums[index], nums[leftIndex], nums[rightIndex]));
                    
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {
                        leftIndex++;
                    }
                    leftIndex++;
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {
                        rightIndex--;
                    }
                    rightIndex--;
                } else if (sum > target) {
                    while (leftIndex < rightIndex && nums[--rightIndex] == nums[rightIndex + 1]) {}
                } else {
                    while (leftIndex < rightIndex && nums[++leftIndex] == nums[leftIndex - 1]) {}
                }
            }
        }
        
        return triplets;
    }
}