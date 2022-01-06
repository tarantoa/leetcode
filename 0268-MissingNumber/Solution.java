import java.util.Arrays;

class Solution {
    public inc missingNumber(int[] nums) {
        int sum = Arrays.stream(nums)
            .reduce(0, (acc, curr) -> acc + curr);
        int expectedSum = nums.length * (nums.length + 1) / 2;

        return expectedSum - sum;
    }
}