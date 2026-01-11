class Solution {
    public String removeStars(String s) {
        StringBuilder s2=new StringBuilder();

        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                s2.deleteCharAt(s2.length()-1);
            } 
            else{
                s2.append(ch);
            }
        }
        return s2.toString();
    }
}