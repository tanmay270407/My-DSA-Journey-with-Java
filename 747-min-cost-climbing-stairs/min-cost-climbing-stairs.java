class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = 2; i <= n; i++) {
            int oneStep = prev1 + cost[i - 1];
            int twoStep = prev2 + cost[i - 2];

            int curr = Math.min(oneStep, twoStep);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}