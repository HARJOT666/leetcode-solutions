class Solution {
    public int maxArea(int[] height) {
        int ans = height[0];
        int n  = height.length;
        int count = 0;
        int maxArea = 0;
        int left = 0;
        int right= n-1;
        while(count < height.length){
            count++;
            int hei = Math.min(height[left],height[right]);
            int width = right - left;
            int area = width * hei;
            if(area > maxArea){
                maxArea = area;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}