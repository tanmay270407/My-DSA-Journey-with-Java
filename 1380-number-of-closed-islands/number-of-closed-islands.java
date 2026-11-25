class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int[] dr={-1, 0, 1, 0};
        int[] dc={0, 1, 0, -1};
        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                q.offer(new int[]{i, 0});
                grid[i][0]=1;
            }
            if(grid[i][n-1]==0){
                q.offer(new int[]{i, n-1});
                grid[i][n-1]=1;
            }
        }
        for(int j=0;j<n;j++){
            if(grid[0][j]==0) {
                q.offer(new int[]{0, j});
                grid[0][j]=1;
            }
            if(grid[m -1][j]==0){
                q.offer(new int[]{m-1, j});
                grid[m-1][j]=1;
            }
        }
        bfs(grid, q, dr, dc);

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    count++;
                    q.offer(new int[]{i, j});
                    grid[i][j]=1;
                    bfs(grid, q, dr, dc);
                }
            }
        }

        return count;
    }

    public void bfs(int[][] grid, Queue<int[]> q,
                    int[] dr, int[] dc){
        int m=grid.length;
        int n=grid[0].length;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int k=0;k<4;k++){
                int nr=r+dr[k];
                int nc=c+dc[k];
                if(nr>=0&&nr<m&&nc>=0&&nc<n&&grid[nr][nc]==0){
                    grid[nr][nc]=1;
                    q.offer(new int[]{nr, nc});
                }
        }
        }
    }
}