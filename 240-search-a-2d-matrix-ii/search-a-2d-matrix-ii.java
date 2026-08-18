class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return Searchmat(matrix, target, matrix[0].length-1,0);

    }
    public boolean Searchmat(int[][] matrix, int target, int c, int r){
        if(c<0 || r==matrix.length){
            return false;
        }
        if(matrix[r][c]==target){
            return true;
        }
        if(matrix[r][c]>target){
            return Searchmat(matrix, target, c-1, r);
        }
        return Searchmat(matrix, target, c, r+1);
    }
}