class Solution {
    static boolean check(int n, int[] nums){
        for(int num:nums){
            if(n==num)
                return true;
        }
        return false;
    }
    public List<Integer> findMissingElements(int[] nums) {
        int min = nums[0],max = nums[0];
        for(int num:nums){
            if(min>num){
                min = num;
            }
            else if(max<num){
                max = num;
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!(check(i,nums)))
                result.add(i);
        }
        return result;
    }
}
