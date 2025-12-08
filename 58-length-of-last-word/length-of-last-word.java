class Solution {
    public int lengthOfLastWord(String s) {
        int len=s.length();
        int result=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i)!=' '){
                result++;
            }
            else{
                if(result>0){
                    break;
                }
            }
        }
    return result;    
    }
}