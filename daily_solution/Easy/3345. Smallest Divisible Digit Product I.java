class Solution {
    static int sum (int n){
        int prod = 1;
        while(n!=0){
            int dig = n%10;
            prod *= dig;
            n /=10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
         while (true) {
            if (sum(n) % t == 0) {
                return n;
            }
            n++;
        }
    }
}
