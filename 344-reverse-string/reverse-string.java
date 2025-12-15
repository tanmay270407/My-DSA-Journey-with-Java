class Solution {
    public void reverseString(char[] s) {
        int n=s.length;
        char[] s2=new char[s.length]; 
        for(int i=0;i<n;i++){
            s2[i]=s[n-1-i];
        } 
        for(int i = 0;i<n;i++){
            s[i]=s2[i];
        }   
    }
}