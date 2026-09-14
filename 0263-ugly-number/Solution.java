class Solution {
    public boolean isUgly(int n) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        if(n<=0){
            return false;
        }
        while(n%2==0){
            n/=2;
        }
        while(n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }

        return n==1;
    }
}