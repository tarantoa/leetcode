class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int prevStep = 2;
        int twoPrevStep = 1;
        int totalSteps = 0;
        for (int i = 3; i <= n; ++i) {
            totalSteps = prevStep + twoPrevStep;
            twoPrevStep = prevStep;
            prevStep = total;
        }

        return totalSteps;
    }
}