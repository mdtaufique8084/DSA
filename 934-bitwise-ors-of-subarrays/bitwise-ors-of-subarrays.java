class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> prev=new HashSet<>();// to store prev res
        HashSet<Integer> res=new HashSet<>(); // final ans
        for(int num:arr){
            HashSet<Integer> curr=new HashSet<>(); // to store single el of arr and or with prev res
            curr.add(num);
            for(int p:prev){
                curr.add(p|num);
            }
            res.addAll(curr); // valid unique OR's
            prev=curr;// prev valid res for use in next iteration
        }
        return res.size();
    }
}