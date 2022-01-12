class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseColumns(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for (int row = 0; row < matrix.length; ++row){
            for (int col = row; col < matrix[row].length; ++col) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
    
    private void reverseColumns(int[][] matrix) {
        for (int row = 0; row < matrix.length; ++row) {
            int leftColumn = 0;
            int rightColumn = matrix.length - 1;
            while (leftColumn < rightColumn) {
                int temp = matrix[row][leftColumn];
                matrix[row][leftColumn] = matrix[row][rightColumn];
                matrix[row][rightColumn] = temp;
                
                ++leftColumn;
                --rightColumn;
            }
        }
    }
}