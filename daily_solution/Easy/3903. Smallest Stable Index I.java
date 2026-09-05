class Solution {
    static int min(int index,int[] nums){
        int small = nums[index];
        for(int i=index;i<nums.length;i++){
            if(small>nums[i])
                small = nums[i];
        }
        return small;
    }
    static int max(int index,int[] nums){
        int large = nums[0];
        for(int i=0;i<index;i++){
            if(large<nums[i])
                large = nums[i];
        }
        return large;
    }
    public int firstStableIndex(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int m = max(i,nums);
            int s=min(i,nums);
            int instability = m-s;
            if(instability <= k){
                return i;
            }
        }
        return -1;
    }
}
