class StockSpanner {
    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int days = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            days += stack.pop()[1];
        }

        stack.push(new int[]{price, days});
        return days;
    }
}