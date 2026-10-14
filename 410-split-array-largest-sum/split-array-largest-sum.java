
import java.util.Arrays;

class Solution {

    static int solve(int[] nums, int start, int k, int[] prefix, int[][] dp) {
        int n = nums.length;

        // One subarray remains
        if (k == 1) {
            return prefix[n] - prefix[start];
        }

        // Not enough elements to make k non-empty subarrays
        if (n - start < k) {
            return Integer.MAX_VALUE;
        }

        if (dp[start][k] != -1) {
            return dp[start][k];
        }

        int ans = Integer.MAX_VALUE;

        // Leave at least k - 1 elements for the remaining parts
        for (int i = start + 1; i <= n - k + 1; i++) {
            int leftSum = prefix[i] - prefix[start];

            int rightMax = solve(nums, i, k - 1, prefix, dp);

            int largestSum = Math.max(leftSum, rightMax);
            ans = Math.min(ans, largestSum);

            // Further splits only increase leftSum (positive numbers)
            if (leftSum >= ans) {
                break;
            }
        }

        return dp[start][k] = ans;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, k, prefix, dp);
    }
}
