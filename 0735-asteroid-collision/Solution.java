class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            }

            else {

                int neg = asteroids[i];

                while (!stack.isEmpty() && stack.peek() > 0) {

                    int pos = stack.peek();

                    if (Math.abs(neg) > pos) {
                        stack.pop();
                    }

                    else if (Math.abs(neg) == pos) {
                        stack.pop();
                        neg = 0;
                        break;
                    }

                    else {
                        neg = 0;
                        break;
                    }
                }

                if (neg != 0) {
                    stack.push(neg);
                }
            }
        }

        int k = stack.size();
        int[] arr = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }

        return arr;
    }
}