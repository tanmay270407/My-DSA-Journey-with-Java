class Solution {
    public int[] searchRange(int[] nums, int target) {
        int srt=-1;
        int end=-1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==target){
                if(srt==-1){
                    srt=i;
                }
                end=i;
            }
        }
        return new int[]{srt,end};
    }
}