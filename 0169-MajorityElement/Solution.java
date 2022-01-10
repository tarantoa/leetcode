class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int value = 0;
        for (int cur : nums) {
            if (count == 0) {
                value = cur;
            }
            if (cur == value) {
                ++count;
            } else {
                --count;
            }
        }

        return value;
    }
}