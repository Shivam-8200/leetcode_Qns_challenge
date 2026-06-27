class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge((long) num, 1, Integer::sum);
        }

        int maxLen = 1;

        for (long x : freq.keySet()) {
            if (x == 1) {
                int ones = freq.get(1L);
                int len = (ones % 2 == 1) ? ones : ones - 1;
                maxLen = Math.max(maxLen, len);
                continue;
            }

            // ✅ FIXED: freq[sqrt] >= 2 hona chahiye tabhi skip karo
            long sqrtX = (long) Math.round(Math.sqrt(x));
            if (sqrtX * sqrtX == x && freq.getOrDefault(sqrtX, 0) >= 2) {
                continue;
            }

            int len = 0;
            long cur = x;

            while (true) {
                long next = cur * cur;

                if (next != cur
                        && next <= 1_000_000_000L
                        && freq.getOrDefault(cur, 0) >= 2
                        && freq.getOrDefault(next, 0) >= 1) {
                    len += 2;
                    cur = next;
                } else {
                    if (freq.getOrDefault(cur, 0) >= 1) {
                        len += 1;
                    }
                    break;
                }
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}