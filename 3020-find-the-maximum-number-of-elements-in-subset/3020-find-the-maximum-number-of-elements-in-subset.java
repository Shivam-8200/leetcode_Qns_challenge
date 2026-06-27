class Solution {
    public int maximumLength(int[] nums) {
        // Step 1: frequency map banao
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }

        // Step 2: x=1 special case
        // 1² = 1 same rehta hai, toh chain = [1,1,1,1,1...]
        int ans = 1; // minimum answer hamesha 1
        if (freq.containsKey(1)) {
            int ones = freq.get(1);
            // odd length hi valid: [1], [1,1,1], [1,1,1,1,1]...
            ans = (ones % 2 == 1) ? ones : ones - 1;
        }

        // Step 3: har x ke liye chain try karo
        for (int x : freq.keySet()) {
            if (x == 1) continue; // already handled

            // x se chain sirf tab bane
            // jab x ke PAIR hain (left + right dono sides)
            if (freq.get(x) < 2) continue;

            // Chain build karo: x → x² → x⁴ → ...
            int pairs = 0;      // kitne pairs bane (left+right)
            long cur = x;       // long use karo overflow ke liye

            while (cur < Integer.MAX_VALUE
                    && freq.getOrDefault((int) cur, 0) >= 2) {
                pairs++;        // ek pair mila!
                cur = cur * cur; // agla = cur ka square
            }

            // Last element — middle mein rakh sakte hain?
            boolean hasMiddle = (cur < Integer.MAX_VALUE
                    && freq.getOrDefault((int) cur, 0) >= 1);

            // Total length = pairs on left + middle + pairs on right
            // = pairs + 1 + pairs = 2*pairs + 1
            // Agar middle nahi toh = 2*pairs - 1
            int len = hasMiddle ? 2 * pairs + 1 : 2 * pairs - 1;

            ans = Math.max(ans, len);
        }

        return ans;
    }
}