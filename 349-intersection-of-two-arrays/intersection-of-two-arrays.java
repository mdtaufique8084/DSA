class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int num1:nums1){
            set1.add(num1);
        }
        for(int num2:nums2){
           set2.add(num2);
        }
        List<Integer> common=new ArrayList<>();
        for(Integer el:set1){
            if(set2.contains(el)){
                common.add(el);
            }
        }
        int n=common.size();
        int[] res=new int[n];
        int i=0;
        for(Integer num:common){
            res[i++]=num;
        }
        return res;
    }
}