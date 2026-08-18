class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, 0);
    }

    public boolean search(int[][] matrix, int target, int i, int j) {
        if (i == matrix.length) {
            return false;
        }

        if (j == matrix[0].length) {
            return search(matrix, target, i + 1, 0);
        }

        if (matrix[i][j] == target) {
            return true;
        }

        return search(matrix, target, i, j + 1);
    }
}