class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp=new ArrayList<>();
        for(int[] arr:intervals){
            temp.add(arr);
        }
        temp.add(newInterval);
        temp.sort((a,b)->Integer.compare(a[0],b[0]));
        List<int[]> res=new ArrayList<>();
        int[] tempInterval=temp.get(0);
        res.add(tempInterval);
        for(int[] arr:temp){
            if(arr[0]<=tempInterval[1]){
                tempInterval[1]=Math.max(arr[1],tempInterval[1]);
            }
            else{
                tempInterval=arr;
                res.add(tempInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}