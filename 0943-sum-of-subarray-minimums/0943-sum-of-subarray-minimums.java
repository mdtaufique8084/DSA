class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1_000_000_007;

        int[] NSL = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            NSL[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        int[] NSR = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            // ✅ Use strict greater for NSR!
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            NSR[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long count = (long) (i - NSL[i]) * (NSR[i] - i);
            sum = (sum + count * arr[i]) % mod;
        }

        return (int) sum;
    }
}
