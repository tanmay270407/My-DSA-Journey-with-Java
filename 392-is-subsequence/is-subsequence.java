class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=0;
        int count=0;
        int len1=s.length();
        int len2=t.length();

        for(int i=0;i<len1;i++){
            for(int j=n;j<len2;j++){
                if(s.charAt(i)==t.charAt(j)){
                    n=j+1;
                    count++;
                    break;
                }
            }
        }
        if(count==len1){
            return true;
        }
        else{
            return false;
        }
    }
}