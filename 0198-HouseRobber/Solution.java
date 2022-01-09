class Solution {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int houses = nums.length;
        if (houses == 1) {
            return nums[0];
        }
        if (houses == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int prevHouseLoot = Math.max(nums[0], nums[1]);
        int twoHousePrevLoot = nums[0];
        int maxLoot = Integer.MIN_VALUE;
        for (int idx = 2; idx < houses; ++idx) {
            int currentLoot = Math.max(nums[idx] + twoHousePrevLoot, prevHouseLoot);
            maxLoot = Math.max(currentLoot, prevHouseLoot);
            
            twoHousePrevLoot = prevHouseLoot;
            prevHouseLoot = currentLoot;
        }
        
        return maxLoot;
    }
}