class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            if(visited[i] == 0){
                dfs(graph,visited,i);
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i] == 2){
                list.add(i);
            }
        }
        return list;
    }
    //everyone that is part of the cycle can never be safe node
    public boolean dfs(int[][] graph,int[] visited,int node){
        //if visited 1 means cycle
        if(visited[node] == 1){
            //cycle detected
            return false;
        }
        if(visited[node] == 2){
            return true;
        }
        visited[node] = 1;
        for(int i=0;i<graph[node].length;i++){
            int neighbour = graph[node][i];
            if(visited[neighbour] == 0){
                if(dfs(graph,visited,neighbour) == false){
                    return false;
                }
            }
            else if(visited[neighbour] == 1){
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }
    public void bfs(int[][] graph){

    }
}