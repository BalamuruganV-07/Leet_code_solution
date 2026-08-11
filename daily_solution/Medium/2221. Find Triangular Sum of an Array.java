class Solution {
    static int sumtriangle(int n,int[] nums){
        if(n==1){
            return nums[0];
        }
        int []ans = new int[n-1];
        for(int i=0;i<n-1;i++){
            int temp=nums[i]+nums[i+1];
            ans[i]=temp%10;
        }
        return sumtriangle(n-1,ans);
        
    }
    public int triangularSum(int[] nums) {
        int n = nums.length;
        int result = sumtriangle(n,nums);
        return result;
    }
}
