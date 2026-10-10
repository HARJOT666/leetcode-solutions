class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] redundant = new int[2];
        if(edges.length == 0){
            return redundant;
        }
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If a path already exists, this edge creates a cycle
                if (bfs(u, v, adj)) {
                    return edge;
                }

                // Otherwise, add the edge
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        
        return new int[0];
    }
    public boolean bfs(int u,int v,ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        q.add(u);
        visited[u] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == v){
                return true;
            }
            for(int neighbour : adj.get(curr)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
}