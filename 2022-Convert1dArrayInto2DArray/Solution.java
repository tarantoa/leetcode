class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n) {
            return new int[0][0];
        }
        
        int[][] output = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                output[i][j] = original[k++];
            }
        }
        return output;
    }
}
