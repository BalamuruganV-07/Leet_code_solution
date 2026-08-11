class Solution {
    static boolean check(int n,int[] nums){
        for(int i=0;i<nums.length;i++){
            if(n==nums[i])
                return true;
        }
        return false;
    }
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]+1){
                break;
            }
            else{
                sum +=nums[i];
            }
        }
        while(check(sum,nums)){
            sum++;
        }

        return sum;
    }
}
