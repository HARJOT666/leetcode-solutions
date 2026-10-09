
class Solution {
    public int findJudge(int n, int[][] trust) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < trust.length; i++) {
            list.add(trust[i][0]);
        }

        if (list.containsAll(ans)) {
            return -1;
        } else {
            for (int i = 0; i < ans.size(); i++) {
                int candidate = ans.get(i);

                if (!list.contains(candidate)) {
                    int count = 0;

                    for (int j = 0; j < trust.length; j++) {
                        if (trust[j][1] == candidate) {
                            count++;
                        }
                    }

                    if (count == n - 1) {
                        return candidate;
                    }
                }
            }
        }

        return -1;
    }
}
