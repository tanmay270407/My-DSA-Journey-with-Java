class Solution {
    public int singleNumber(int[] nums) {
        int res = 0; 
        if (nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                res = nums[i];
                break;
            }
        }
        return res;    
    }
}