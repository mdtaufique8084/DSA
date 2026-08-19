class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(true){
            int sum=square(n);
            if(sum==1) return true;
            n=sum;
            if(set.contains(n)) return false;
            set.add(n);
        }
        // return true;
    }
    private int square(int val){
        int res=0;
        while(val!=0){
            int last=val%10;
            res+=last*last;
            val=val/10;
        }
        return res;
    }
}