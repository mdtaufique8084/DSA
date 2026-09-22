class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        if (s.length() < 10) {
            return new ArrayList<>();
        }

        int k = 10;
        Set<Integer> seen = new HashSet<>();
        Set<String> res = new HashSet<>();

        int currSum = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        for(int i=0;i<k;i++){
            int pow=k-1-i;
            currSum=currSum+(int)Math.pow(4,pow)*map.get(s.charAt(i));
        }
        seen.add(currSum);

        for(int i=k;i<s.length();i++){
            currSum=currSum-(int)(Math.pow(4,k-1)*map.get(s.charAt(i-k)));
            currSum=currSum*4;
            currSum+=map.get(s.charAt(i));

            if(seen.contains(currSum)){
                res.add(s.substring(i-k+1,i+1));
            }
            seen.add(currSum);
        }
        return new ArrayList<String>(res);
    }
}