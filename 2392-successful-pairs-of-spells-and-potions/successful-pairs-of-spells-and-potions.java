class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m=potions.length;
        int[] result=new int[spells.length];

        for(int i=0;i<spells.length;i++){
            long need=(success+spells[i]-1)/spells[i]; 
            int idx=lowerBound(potions, need);
            result[i]=m-idx;
        }

        return result;
    }

    private int lowerBound(int[] arr, long target){

        int left=0, right=arr.length;

        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<target)
                left=mid+1;
            else
                right=mid;
        }
        return left; 
    }
}