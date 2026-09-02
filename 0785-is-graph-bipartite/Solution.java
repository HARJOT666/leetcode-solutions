class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<graph.length;i++){
            if(color[i] == -1){
                if(bfs(graph,color,i) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph,int[] color,int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int currentNode = q.poll();
            int[] neighbours = graph[currentNode];
            for(int i=0;i<neighbours.length;i++){
                if(color[neighbours[i]] == -1){
                    color[neighbours[i]] = 1 - color[currentNode];
                    q.add(neighbours[i]);
                }
                else if(color[neighbours[i]] == color[currentNode]){
                    return false;
                }
            }
        }
        return true;
    }
}