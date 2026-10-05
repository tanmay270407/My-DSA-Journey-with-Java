class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];

        int ans = 2;

        for(int i=0;i<n;i++){
            for (int j=0;j<i;j++){

                int diff=nums[i]-nums[j];
                int d=diff+500;

                dp[i][d] = dp[j][d] + 1;

                if (dp[i][d] == 1) {
                    dp[i][d] = 2;
                }

                ans = Math.max(ans, dp[i][d]);
            }
        }

        return ans;
    }
}