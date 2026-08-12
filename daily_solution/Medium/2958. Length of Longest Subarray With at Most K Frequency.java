import java.util.HashMap;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Give every number a small index
        int index = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, index++);
            }
        }

        int[] freq = new int[index];

        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; right++) {

            int current = map.get(nums[right]);

            freq[current]++;

            while (freq[current] > k) {
                int remove = map.get(nums[left]);

                freq[remove]--;

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
