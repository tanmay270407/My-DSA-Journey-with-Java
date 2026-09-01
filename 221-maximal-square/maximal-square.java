class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[][] dp = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    ans = Math.max(ans, solve(i, j, m, n, matrix, dp));
                }
            }
        }
        return ans * ans;
    }

    public int solve(int i, int j, int m, int n, char[][] matrix, Integer[][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (matrix[i][j] == '0') {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int down = solve(i + 1, j, m, n, matrix, dp);
        int right = solve(i, j + 1, m, n, matrix, dp);
        int diagonal = solve(i + 1, j + 1, m, n, matrix, dp);
        dp[i][j] = 1 + Math.min(down, Math.min(right, diagonal));
        return dp[i][j];
    }
}