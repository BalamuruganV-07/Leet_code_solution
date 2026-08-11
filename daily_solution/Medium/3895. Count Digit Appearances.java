class Solution {
    static int validnumber(int n, int num){
        int count = 0;
        while(n>0){
            if(n%10==num){
                count++;
            }
            n =n/10;
        }
        return count;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        int result = 0;
        for(int num: nums){
            result += validnumber(num,digit);
        }
        return result;
    }
}
