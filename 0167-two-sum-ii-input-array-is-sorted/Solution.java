class Solution {
    public int[] twoSum(int[] numbers, int target) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[2];
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        for(int i=0;i<numbers.length -1;i++){
            int j = target - numbers[i];
            int index = find(list,j,i+1);
            if(index != -1){
                arr[0] = i+1;
                arr[1] = index+1;
                break;
            }    
        }
        return arr;
    }
    public int find(List<Integer> list, int target, int start) {

    int left = start;
    int right = list.size() - 1;

    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (list.get(mid) == target) {
            return mid;
        }

        if (list.get(mid) < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1;
}
}