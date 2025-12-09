class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1){
          return true;
        }   
            
        int maxReach = 0;  

        for (int i = 0; i < len; i++) {
            if (i > maxReach){
                return false;   
            }      
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}