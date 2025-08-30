class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bill : bills) {
            if (bill == 5) {
                // just take the 5
                map.put(5, map.getOrDefault(5, 0) + 1);
            } 
            else if (bill == 10) {
                int freq5 = map.getOrDefault(5, 0);
                if (freq5 == 0) return false;
                // give back one 5
                map.put(5, freq5 - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } 
            else { // bill == 20
                int freq5 = map.getOrDefault(5, 0);
                int freq10 = map.getOrDefault(10, 0);

                if (freq10 > 0 && freq5 > 0) {
                    // use one 10 and one 5
                    map.put(10, freq10 - 1);
                    map.put(5, freq5 - 1);
                } else if (freq5 >= 3) {
                    // use three 5s
                    map.put(5, freq5 - 3);
                } else {
                    return false;
                }
                // we don't need to track 20s
            }
        }
        return true;
    }
}
