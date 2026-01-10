class Solution {
    public int removeDuplicates(int[] nums) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        // count occurrences
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int index = 0;

        // rebuild nums in-place
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = Math.min(entry.getValue(), 2);

            for (int i = 0; i < count; i++) {
                nums[index++] = key;
            }
        }

        return index;
    }
}
