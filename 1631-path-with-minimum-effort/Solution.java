class Solution {
    public int minimumEffortPath(int[][] heights) {
        //return the minimum pah where the max abs difference  is less than other patha and reach to path
        int V = heights.length * heights[0].length;
        int m = heights.length;
        int n = heights[0].length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
            for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int u = i * n + j;

                // Up
                if (i > 0) {
                    int v = (i - 1) * n + j;
                    int w = Math.abs(heights[i][j] - heights[i - 1][j]);
                    adj.get(u).add(new int[]{v, w});
                }

                // Down
                if (i + 1 < m) {
                    int v = (i + 1) * n + j;
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    adj.get(u).add(new int[]{v, w});
                }

                // Left
                if (j > 0) {
                    int v = i * n + (j - 1);
                    int w = Math.abs(heights[i][j] - heights[i][j - 1]);
                    adj.get(u).add(new int[]{v, w});
                }

                // Right
                if (j + 1 < n) {
                    int v = i * n + (j + 1);
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    adj.get(u).add(new int[]{v, w});
                }
            }
        }
        return dijkstras(V, adj, 0)[V - 1];
    }
    public int[] dijkstras(int V,ArrayList<ArrayList<int[]>> adj,int src){
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

                int newDist = Math.max(d, weight);
                if(newDist < dist[neighbour]){
                    dist[neighbour] = newDist;
                    pq.add(new int[]{neighbour,newDist});
                }
            }
        }
        return dist;
    }
}