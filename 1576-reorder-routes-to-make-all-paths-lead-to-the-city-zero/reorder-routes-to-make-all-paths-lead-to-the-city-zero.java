class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] c : connections){
            graph[c[0]].add(new int[]{c[1], 1});
            graph[c[1]].add(new int[]{c[0], 0});
        }

        boolean[] visited=new boolean[n];
        return dfs(0, graph, visited);
    }
    private int dfs(int node, List<int[]>[] graph, boolean[] visited){
        visited[node]=true;
        int count=0;

        for(int[] next : graph[node]){
            if(!visited[next[0]]){
                count+=next[1];
                count+=dfs(next[0], graph, visited);
            }
        }
        return count;
    }
}