class Solution {
    public int minimumDeletions(int[] nums) {
        System.gc();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < nums.length; i++) {

            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }

            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        int n = nums.length;

        int left = maxIndex + 1;

        int right = n - minIndex;

        int both = (minIndex + 1) + (n - maxIndex);

        return Math.min(left, Math.min(right, both));
    }
}
