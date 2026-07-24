class Solution {
    static int xor2(int a,int b){
        return a^b;
    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        int max =0;
        for(int i:nums){
            max = Math.max(max,i);
        }
        int limit =1;
        while(limit<=max){
            limit <<=1;
        }
        boolean triplet[]=new boolean[limit];
        boolean result[]=new boolean[limit];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                triplet[xor2(nums[i],nums[j])]=true;
            }
        }
        for(int i=0;i<limit;i++){
            if(triplet[i]){
                for(int num:nums){
                    result[xor2(i,num)]=true;
                }
            }
        }
        int count=0;
        for(boolean found: result){
            if(found){
                count++;
            }
        }
        return count;
        
       
    }
}
