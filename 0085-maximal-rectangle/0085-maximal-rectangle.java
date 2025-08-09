class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int rows=matrix.length;
        int cols=matrix[0].length;
        int[] height=new int[cols+1];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                height[j]=matrix[i][j]=='1' ? height[j]+1 : 0;
            }
            int area=largestRectangleArea(height);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    private int largestRectangleArea(int arr[]) {
        int maxArea = 0;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nsr[] = new int[n];
        int nsl[] = new int[n];
        // next smaller right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        // next smaller left
        st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        // area calculation
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
}