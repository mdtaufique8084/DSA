class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            boolean isPos = nums[i] > 0;
            int curr = i;
            while (true) {
                int next = calculateNext(nums, curr);
                if (isPos) {
                    if (nums[next] < 0) {
                        break;
                    } else {
                        if (set.contains(next)) {
                            if (curr != next) {
                                return true;
                            } else {
                                break;
                            }
                        }
                        set.add(next);
                    }
                } else {
                    if (nums[next] > 0) {
                        break;
                    } else {
                        if (set.contains(next)) {
                            if (curr != next) {
                                return true;
                            } else {
                                break;
                            }
                        }
                        set.add(next);
                    }
                }
                curr = next;
            }

        }
        return false;
    }

    private int calculateNext(int[] nums, int curr) {
        int n = nums.length;
        int next = curr + nums[curr];
        next = next % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }
}