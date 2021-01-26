

class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Stack<Integer> stack= new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= length;i++) {
            int h = (i == length ?0:heights[i]);
            if (stack.isEmpty() || h >=heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? i : i-1-stack.peek());
                maxArea = Math.max(maxArea,area);
                i--;
            }
        }
        return maxArea;
    }
}