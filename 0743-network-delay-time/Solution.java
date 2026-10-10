class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int V = n+1;
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new int[]{v,weight});
        }
        int[] dist = dijkstra(V, adj, k);
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
    public int[] dijkstra(int V,ArrayList<ArrayList<int[]>> adj,int src){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );
        dist[src] = 0;
        pq.add(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];
            if(d > dist[node]) continue;
            for(int[] edge : adj.get(node)){
                int neighbour = edge[0];
                int weight = edge[1];

                int newDist = d + weight;
                if(newDist<dist[neighbour]){
                    dist[neighbour] = newDist;
                    pq.add(new int[]{neighbour,newDist});
                }
            }
        }
        return dist;
    }
}