class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int k = groupSize;
        int n = hand.length;

        if (n % k != 0) {
            return false;
        }

        Arrays.sort(hand);
        boolean change = true;
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<>();
        int count = 0;

        while (change) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }

                int current = hand[i];
                temp.add(hand[i]);
                visited[i] = true;
                count++;

                for (int j = i + 1; j < n; j++) {
                    if (temp.size() == k) {
                        break;
                    }

                    if ((hand[j] - current) == 1 && visited[j] == false) {
                        temp.add(hand[j]);
                        visited[j] = true;
                        current = hand[j];
                        count++;
                    }
                }

                if (temp.size() == k) {
                    list.add(temp);
                    break;
                } else {
                    return false;
                }
            }

            if (count == n) {
                change = false;
            }
        }

        int cou = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == k) {
                cou++;
            }
        }

        if (cou == list.size()) {
            return true;
        }
        return false;
    }
}