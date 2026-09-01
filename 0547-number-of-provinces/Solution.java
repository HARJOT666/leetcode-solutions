class Solution {
    public int findCircleNum(int[][] isConnected) {
        //convert matrix to arraylist
        int V = isConnected.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // Create ArrayList for every vertex
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        // Convert matrix to ArrayList
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[V+1];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                count++;
                dfs(graph,i,visited);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> graph,int node,boolean[] visited){
        visited[node] = true;
        for(int i=0;i<graph.get(node).size();i++){
            int neighbour = graph.get(node).get(i);
            if(!visited[neighbour]){
                dfs(graph,neighbour,visited);
            }
        }
    }
}