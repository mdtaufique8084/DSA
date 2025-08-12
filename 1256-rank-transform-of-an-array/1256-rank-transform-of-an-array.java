class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int el:arr){
            set.add(el);
        }
        int[] copy=new int[set.size()];
        int idx=0;
        for(int num:set){
            copy[idx++]=num;
        }
        Arrays.sort(copy);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<copy.length;i++){
            map.put(copy[i],i+1);
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            res[i]=map.get(arr[i]);
        }
        return res;
    }
}