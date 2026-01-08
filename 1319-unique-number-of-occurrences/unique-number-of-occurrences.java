class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[arr.length];
        boolean[] visited = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]){
                continue;
            }
            int c = 1;
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    c++;
                    visited[j]=true;
                }
            }
            count[i]=c;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==0){
                continue;
            }
            for(int j=i+1;j<count.length;j++){
                if(count[i]==count[j]&&count[j]!=0){
                    return false;
                }
            }
        }
        return true;
    }
}