class Solution {
    public int searchInsert(int[] nums, int target) {
        int a=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                a=i;    
                return a;          
            }
        }
       for(int i=0;i<nums.length;i++){
            if(target<nums[i]){
                return i;          
            }
            
        }  
        return nums.length;
    }
}