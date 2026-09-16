class Solution {
    public int maxArea(int[] height) {
       int left = 0;
       int right = height.length -1;
       int answer = 0;
       while(left < right){
        int smaller = Math.min(height[left],height[right]);
        int area = smaller * (right - left);
        if(area > answer){
            answer = area;
        }
        if(height[left] > height[right]){
            right--;
        }
        else{
            left++;
        }
       }
       return answer;
    }
}