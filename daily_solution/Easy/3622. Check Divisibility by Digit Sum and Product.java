class Solution {
    public boolean checkDivisibility(int n) {
        int m = n;
        int sum = 0, mul = 1;
        while(m!=0){
            int temp = m%10;
            sum += temp;
            mul *= temp;
            m/=10;
        }

        return n%(sum+mul)== 0;

    }
}
