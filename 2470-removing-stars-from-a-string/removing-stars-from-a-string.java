class Solution {
    public String removeStars(String s) {
        char[] arr=s.toCharArray();
        char[] res=new char[arr.length];
        int top=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!='*'){
                res[top]=arr[i];
                top++;
            } 
            else{
                top--;
            }
        }
        return new String(res, 0, top);
    }
}