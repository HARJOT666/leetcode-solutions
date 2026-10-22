
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int minimum = 0;
        //can be idle or allow completion of one task
        //there has to be a gap of atleast n intervals if the label is same
        boolean[] used = new boolean[tasks.length];
        int maxCount = 0;
        int sameMax = 0;
        for(int i=0;i<tasks.length;i++){
            int count = 0;

            if(!used[i]){
                used[i] = true;
                char current = tasks[i];
                count = 1;

                for(int j=i+1;j<tasks.length;j++){
                    char current1 = tasks[j];

                    if(current == current1 && !used[j]){
                        used[j] = true;
                        count++;
                    }
                }

                if(count > maxCount){
                    maxCount = count;
                    sameMax = 1;
                }
                else if(count == maxCount){
                    sameMax++;
                }
            }
        }

        minimum = Math.max(tasks.length,
                  (maxCount - 1) * (n + 1) + sameMax);

        return minimum;
    }
}
