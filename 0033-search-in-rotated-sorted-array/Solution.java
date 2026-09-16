class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int n = nums.length;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while(i < n - 1) {
            if(nums[i + 1] > nums[i]) {
                list1.add(nums[i]);
                i++;
            }
            else {
                break;
            }
        }

        list1.add(nums[i]);

        // Number of elements before the rotation
        int rotation = i + 1;

        i++;

        while(i < n) {
            list2.add(nums[i]);
            i++;
        }

        List<Integer> list = new ArrayList<>();

        list.addAll(list2);
        list.addAll(list1);

        int[] ans = new int[n];

        for(int j = 0; j < n; j++) {
            ans[j] = list.get(j);
        }

        int index = binarySearch(ans, target);

        if(index == -1) {
            return -1;
        }

        // Convert sorted-array index to original-array index
        return (index + rotation) % n;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}