class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] digits = numToArray(n); // helper to convert num to arr[] digit such as 617=[6,1,7]
        int len = digits.length;
        // map to store the digit and its freq
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int digit : digits) {
            map1.put(digit, map1.getOrDefault(digit, 0) + 1);
        }
        // only checking valid power of 2 who is obtained from reorder of n
        for (int i = 0; i <31; i++) {
            int power=1<<i;
            int[] newDigits = numToArray(power);
            HashMap<Integer, Integer> map2 = new HashMap<>();
            for (int digit : newDigits) {
                map2.put(digit, map2.getOrDefault(digit, 0) + 1);
            }
            if(map1.equals(map2)){
                return true;
            }
        }
        return false;
    }

    private int[] numToArray(int num) {
        int temp = num;
        int length = length(temp);
        int[] digits = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    private int length(int temp){
        int length=0;
        while(temp>0){
            length++;
            temp=temp/10;
        }
        return length;
    }
}