class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    public MedianFinder() {
       leftMax=new PriorityQueue<>(Collections.reverseOrder());
       rightMin=new PriorityQueue<>(); 
    }
    
    public void addNum(int num) {
        if(leftMax.isEmpty() || num<leftMax.peek()){
            leftMax.offer(num);
        }
        else{
            rightMin.offer(num);
        }

        if(Math.abs(leftMax.size()-rightMin.size())>1){
            rightMin.offer(leftMax.poll());
        }
        else if(leftMax.size()<rightMin.size()){
            leftMax.offer(rightMin.poll());
        }
    }
    
    public double findMedian() {
        if(leftMax.size()==rightMin.size()){
            return (double) (leftMax.peek()+rightMin.peek())/2;
        }
        return (double)leftMax.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */