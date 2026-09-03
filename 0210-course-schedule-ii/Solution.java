class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
             for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph.get(u).add(v);
        }
        int[] visited = new int[numCourses];
        Stack<Integer> s = new Stack<>();
        boolean answer = true;
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(!dfs(i,visited,s,graph)){
                    answer = false;
                }
            }
        }
        if(answer == false){
            return new int[0];
        }
       int[] arr = new int[s.size()];
        if(answer == true){
            int i=0;
            while(!s.isEmpty()){
                arr[i] = s.pop();
                i++;
            }
        }
        return arr;
     }
    public boolean dfs(int node,int[] visited,Stack<Integer> s,ArrayList<ArrayList<Integer>> graph){
        //already visited means cycle
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
                if(dfs(neighbour,visited,s,graph) == false){
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