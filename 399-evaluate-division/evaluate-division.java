class Solution {
    Map<String, Map<String, Double>> graph=new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i=0; i<equations.size();i++){
            String A=equations.get(i).get(0);
            String B=equations.get(i).get(1);
            double value=values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0/value);
        }
        double[] result=new double[queries.size()];

        for(int i=0;i<queries.size();i++){

            String C=queries.get(i).get(0);
            String D=queries.get(i).get(1);

            if(!graph.containsKey(C)||!graph.containsKey(D)){
                result[i]=-1.0;
            } 
            else if(C.equals(D)){
                result[i] = 1.0;
            } 
            else{
                Set<String> visited = new HashSet<>();
                result[i]=dfs(C, D, 1.0, visited);
            }
        }
        return result;
    }
    private double dfs(String current, String target, double product, Set<String> visited){
        if(current.equals(target)){
            return product;
        }
        visited.add(current);
        for(Map.Entry<String, Double> neighbor : graph.get(current).entrySet()){
            if(!visited.contains(neighbor.getKey())){
                double result=dfs(
                        neighbor.getKey(),
                        target,
                        product * neighbor.getValue(),
                        visited
                );
                if (result!=-1.0){
                    return result;
                }
            }
        }
        return -1.0;
    }
}