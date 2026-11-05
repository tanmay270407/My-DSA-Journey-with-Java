class Solution {
    public long countSubarrays(int[] nums, long k) {
        return aM(nums, k);
    }
    public long aM(int[] nums, long k) {

        int L = 0;
        long S = 0;
        long C = 0;

        for (int R = 0; R < nums.length; R++) {

            S += nums[R];

            while (S * (R - L + 1) >= k) {
                S -= nums[L];
                L++;
            }

            C += R - L + 1;
        }
        return C;
    }
}