class Solution {
    public String mergeAlternately(String word1, String word2) {
        String add="";
        int i=0;
        while(i<word1.length()||i<word2.length()){
            if(i<word1.length()){
                add=add+word1.charAt(i);
            }
            if(i<word2.length()){
                add=add+word2.charAt(i);
            }
            i++;
        }
        return add;
    }
}