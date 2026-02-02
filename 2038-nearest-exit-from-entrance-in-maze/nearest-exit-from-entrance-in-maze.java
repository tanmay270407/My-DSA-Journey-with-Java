class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1]});

        maze[entrance[0]][entrance[1]]='+';

        int steps=0;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()){
            int size=q.size();
            steps++;
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int r=cur[0];
                int c=cur[1];

                for(int[] d : dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0&&nr<m&&nc>=0&&nc<n&&maze[nr][nc] == '.'){
                        if (nr==0||nr==m-1||nc==0||nc==n-1){
                            return steps;
                        }
                        maze[nr][nc]='+'; 
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}