class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> rem1=new ArrayList<>();
        List<Integer> rem2=new ArrayList<>();
        int sum=0;
        for(int num:nums){
            sum+=num;
            if(num%3==1){
                rem1.add(num);
            }
            else if(num%3==2){
                rem2.add(num);
            }
        }
        if(sum%3==0) return sum;
        Collections.sort(rem1);
        Collections.sort(rem2);
        int res=0;
        if(sum%3==1){
            int remove1=rem1.size()>=1 ? rem1.get(0) : Integer.MAX_VALUE;
            int remove2=rem2.size()>=2 ? rem2.get(0)+rem2.get(1):Integer.MAX_VALUE;
            res=sum-Math.min(remove1,remove2); 
        }
        else{
            int remove2=rem2.size()>=1 ? rem2.get(0) : Integer.MAX_VALUE;
            int remove1=rem1.size()>=2 ? rem1.get(0) +rem1.get(1):Integer.MAX_VALUE;
            res=sum-Math.min(remove2,remove1);
        }
        return Math.max(res,0);
    }

}