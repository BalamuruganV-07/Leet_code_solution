class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;

        while (n != 0) {
            int digit = n % 10;

            if (digit >= max1) {
                max2 = max1;
                max1 = digit;
            } 
            else if (digit > max2) {
                max2 = digit;
            }

            n /= 10;
        }

        return max1 * max2;
    }
}

-----------------------------------------------------------(or)-------------------------------------------------------------------------------------

class Solution {
    public int maxProduct(int n) {
        System.gc();
        ArrayList<Integer> dig = new ArrayList<>();
        int count = 0;
        while(n!=0){
            int a = n%10;
            dig.add(a);
            count++;
            n=n/10;
        } 
        Collections.sort(dig);
        int left = count-2;
        int right = count-1 ;
        return dig.get(left)*dig.get(right);
    }
}
