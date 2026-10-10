class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")) {
            return -1;
        }

        return bfs("0000", target, dead);

    }
    public int bfs(String start,String target,HashSet<String> dead){
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(curr.equals(target)) return moves;
                for(int j=0;j<4;j++){
                    for(int dir : new int[]{-1,1}){
                        char[] arr = curr.toCharArray();
                        arr[j] = (char)((arr[j] - '0' +dir+ 10) % 10 + '0');
                        String next = new String(arr);
                        if (!dead.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}