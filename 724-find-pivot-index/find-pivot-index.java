class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum=0;
        int total=0;

        for(int t=0;t<nums.length;t++){
            total+=nums[t];
        }

        for(int i=0;i<nums.length;i++){
            if(leftSum==total-leftSum-nums[i]){
                return i;
            }
            leftSum+=nums[i];
        }
    return -1;   
    }
}