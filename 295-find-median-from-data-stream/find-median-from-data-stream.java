class MedianFinder {
    int[] temp;
    int i;
    public MedianFinder() {
        temp=new int[5*10000+1];
        i=0;
    }
    
    public void addNum(int num) {
        if(i==0){
            temp[i++]=num;
            return;
        }
        int j=i-1;
        while(j>=0 && temp[j]>num){
            temp[j+1]=temp[j];
            j--;
        }
        temp[j+1]=num;
        i++;
    }
    
    public double findMedian() {
        int n=i;
        if(n%2==0){
            int l=n/2 -1;
            int r=n/2;
            return (double)(temp[l]+temp[r])/2;
        }
        return (double) temp[n/2];
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */