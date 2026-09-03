class Solution {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
        }
        int[] visited = new int[numCourses];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(dfs(visited,graph,i,s) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int[] visited,ArrayList<ArrayList<Integer>> graph,int node,Stack<Integer> s){
        //base condition is if its a cycle then return false
        if(visited[node] == 1){
            return false;
        }
        if(visited[node] == 2){
            return true;
        }
        visited[node] = 1;
        for(int i=0;i<graph.get(node).size();i++){
            int neighbour = graph.get(node).get(i);
            if(visited[neighbour] == 0){
               
                if(dfs(visited,graph,neighbour,s) == false){
                    return false;
                }
            }
            else if(visited[neighbour] == 1){
                return false;
            }
        }
        visited[node] = 2;
        s.push(node);
        return true;
    }
}