class Solution {
    public int[] countBits(int n) {
        int[] bitCounts = new int[n + 1];
        int offset = 1;

        for (int idx = 1; idx <= n; idx++) {
            if (idx == offset * 2) {
                offset = idx;
            }

            bitCounts[idx] = 1 + bitCounts[idx - offset];
        }

        return bitCounts;
    }
}