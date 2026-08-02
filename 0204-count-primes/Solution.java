class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        //make all true first
        for(int i=2;i<n;i++){
            prime[i] = true;
        }
        
        //now make the multiples false
        for(int p = 2; p*p<=n;p++){
            if(prime[p] == true){
                for(int i=p*p;i<n;i+=p){
                    prime[i] = false;
                }
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(prime[i] == true){
                count++;

            }
        }
        return count;
    }
}