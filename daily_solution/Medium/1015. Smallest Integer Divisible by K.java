class Solution {
    public int smallestRepunitDivByK(int k) {
        int n = 0;
        int div = k,count = 0;
        while(k!=0){
            n = ((n*10)+1)%div;
            count++;
            if(n==0){
                return count;
            }
            
            k--;
        }
        return -1;
    }
}
