class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int count=0;
        int maxL=0;

        for(right=0;right<s.length();right++){
            for (int i=left;i<right;i++){
                if(s.charAt(i)==s.charAt(right)){
                    count=1;
                    break;
                }
            }
            if(count==1){
                left++;
                count=0;
                right--;
                continue;
            }
            maxL=Math.max(maxL, right-left+1);
        }
        return maxL;
    }
}