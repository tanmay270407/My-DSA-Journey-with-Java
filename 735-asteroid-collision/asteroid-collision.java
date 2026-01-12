class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack=new int[asteroids.length];
        int top=-1;

        for(int i=0;i<asteroids.length;i++){
            int curr=asteroids[i];

            while(top>=0&&stack[top]>0&&curr<0){
                int a=Math.abs(stack[top]);
                int b=Math.abs(curr);

                if(a>b){
                    curr=0;
                    break;
                }
                else if(a<b){
                    top--;
                }
                else{
                    top--;
                    curr=0;
                    break;
                }
            }
            if(curr!=0){
                stack[++top]=curr;
            }
        }
        int[] res=new int[top+1];
        for(int i=0;i<=top;i++){
            res[i]=stack[i];
        }
        return res;
    }
}