class Solution {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                ones++;
            }
            n >>>= 1;
        }

        return ones;
    }
}