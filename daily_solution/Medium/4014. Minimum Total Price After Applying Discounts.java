class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        System.gc();
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int p = prices.length - 1;
        int d = discounts.length - 1;
        double result = 0;
        while (p >= 0 && d >= 0) {
            result += prices[p] * (100 - discounts[d]) / 100.0;
            p--;
            d--;
        }
        while (p >= 0) {
            result += prices[p];
            p--;
        }
        return result;
    }
}

---------------------------------------------(Brute force)------------------------------------------

  class Solution {

    static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public double minPrice(int[] prices, int[] discounts) {

        sort(prices);
        sort(discounts);

        int n = discounts.length;
        double result = 0;

        // Apply highest discounts to highest prices
        for (int i = 0; i < n; i++) {
            result += prices[i] * (100 - discounts[i]) / 100.0;
        }

        // Add remaining prices
        for (int i = n; i < prices.length; i++) {
            result += prices[i];
        }

        return result;
    }
}
