class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return bfs(graph,n,source,destination);
    }
    public boolean bfs(ArrayList<ArrayList<Integer>> graph,int n,int source,int destination) {
        Queue<Integer> q  = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.add(source);
        while(!q.isEmpty()){
            int current = q.poll();
            if(current == destination){
                return true;
            }
            ArrayList<Integer> neighbours = graph.get(current);
            for(int i=0;i<neighbours.size();i++){
                int neighbour = neighbours.get(i);
                if(visited[neighbour] == false){
                    visited[neighbour] = true;
                    if(neighbour == destination){
                        return true;
                    }
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
}