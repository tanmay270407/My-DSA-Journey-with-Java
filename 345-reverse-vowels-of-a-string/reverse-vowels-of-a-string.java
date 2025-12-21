class Solution {
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int start=0;
        int end=arr.length-1;
        for(;start<end;){
            for(;start<end;start++){
                if(isVowel(arr[start])){
                    break;
                }
            }
            for(;start<end;end--){
                if(isVowel(arr[end])){
                    break;
                }
            }
            if(start<end){
                char temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
    public boolean isVowel(char c){
        c=Character.toLowerCase(c);
        if(c=='a'||c=='e'||c=='i'||c=='o'||c =='u'){
            return true;
        }
        return false;
    }
}