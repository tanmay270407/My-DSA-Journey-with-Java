class Solution {

    public int solve(int[] nums, int i, int n) {

        // Base case
        if (i > n) {
            return 0;
        }

        int left = nums[i] - solve(nums, i + 1, n);
        int right = nums[n] - solve(nums, i, n - 1);

        return Math.max(left, right);
    }

    public boolean predictTheWinner(int[] nums) {

        int n = nums.length - 1;
        return solve(nums, 0, n) >= 0;
    }
}