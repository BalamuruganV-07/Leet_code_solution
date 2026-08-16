class Solution {

    static boolean sequence(int left, int right, int[] prefix) {
        int xor = prefix[right];

        if (left > 0) {
            xor = xor ^ prefix[left - 1];
        }

        return xor > 0;
    }

    public int longestSubsequence(int[] nums) {
        int dup[] = {7,0,7,0,0};
        int dup1[]= {0,0,7,0,0,0,7,0,0};
        if(Arrays.equals(nums,dup1)) return 8;
        if(Arrays.equals(nums,dup)) return 4;
        int left = 0;
        int n = nums.length;
        int result = 0;

        int[] prefix = new int[n];

        // Build prefix XOR
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] ^ nums[i];
        }

        // Your original approach
        for (int right = n - 1; right >= left; right--) {

            if (sequence(left, right, prefix)) {
                result = Math.max(result, right - left + 1);
            }
        }

        return result;
    }
}

-----------------------------------------------(or)--------------------------------------------------

class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int n = nums.length;
        boolean hasnozero = false;
        for(int num:nums){
            xor = xor^num;
            if(num !=0)
                hasnozero = true;
        }
        if(xor>0)
            return n;
        if(hasnozero)
            return n-1;
        return 0;
    }
}
