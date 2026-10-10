class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //return whether uj is a prerequisit of vourse vj or not
        //its a directed graph where a edge from one vertex is the prerequisit
        //base case is if prerequists array is empty return false
        List<Boolean> list = new ArrayList<>();
        if(prerequisites.length == 0){
            for(int i=0;i>queries.length;i++){
                list.add(false);
            }
        }
        //can i construct a graph and use bfs or dfs on it to travere and identifi if a direct or indirect edge exists ?
        //but how to construct a graph is the question? lets use bfs
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        for(int i= 0;i<queries.length;i++){
            boolean ans = (bfs(queries[i][0],queries[i][1],adj));
            list.add(ans);
        }
        return list;
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
                visited[neighbour] = true;
                q.add(neighbour);
            }
        }
        return false;
    }
}