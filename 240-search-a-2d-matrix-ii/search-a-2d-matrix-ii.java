class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix[0].length - 1);
    }

    public boolean search(int[][] matrix, int target, int row, int col) {
        if (row >= matrix.length || col < 0) {
            return false;
        }

        if (matrix[row][col] == target) {
            return true;
        }

        if (matrix[row][col] > target) {
            return search(matrix, target, row, col - 1);
        }

        return search(matrix, target, row + 1, col);
    }
}