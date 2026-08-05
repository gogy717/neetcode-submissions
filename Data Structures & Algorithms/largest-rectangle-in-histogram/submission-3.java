class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight =
                    i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > currentHeight) {
                int h = heights[stack.pop()];
                int width = stack.isEmpty()
                        ? i
                        : i - stack.peek() - 1;
                maxArea = Math.max(h*width, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
