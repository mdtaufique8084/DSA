class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<n;i++){
            // remove the element from dq who is out of window
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            // remove the element from dq who is smaller then coming no to maintain increasing order for max
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);// add the current element
            if(i>=k-1){
                res[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return res;
    }
}