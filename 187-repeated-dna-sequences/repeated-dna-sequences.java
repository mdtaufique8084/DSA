class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen =new HashSet<>();
        Set<String> res =new HashSet<>();
        for(int i=0;i<=s.length()-10;i++){
            String part=s.substring(i,i+10);
            if(seen.contains(part)){
                res.add(part);
            }
            seen.add(part);
        }
        return new ArrayList<String>(res);
    }
}