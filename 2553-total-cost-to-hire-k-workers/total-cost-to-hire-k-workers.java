class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> left = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        PriorityQueue<int[]> right = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );

        int n=costs.length;

        for(int i=0; i<candidates;i++){
            left.offer(new int[]{costs[i], i});
        }

        for (int i=n-1;i>=Math.max(candidates, n-candidates);i--){
            right.offer(new int[]{costs[i], i});
        }

        int l=candidates;
        int r=n-candidates-1;
        long total=0;

        for(int i=0;i<k;i++){
            if(right.isEmpty()||(!left.isEmpty()&&left.peek()[0]<=right.peek()[0])){
                int[] pick=left.poll();
                total+=pick[0];

                if(l<=r){
                    left.offer(new int[]{costs[l], l});
                    l++;
                }

            } 
            else{
                int[] pick=right.poll();
                total+=pick[0];
                if(l<=r){
                    right.offer(new int[]{costs[r], r});
                    r--;
                }
            }
        }
        return total; 
    }
}