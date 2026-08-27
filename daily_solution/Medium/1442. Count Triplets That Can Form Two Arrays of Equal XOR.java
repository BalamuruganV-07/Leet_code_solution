class Solution {
    public int countTriplets(int[] arr) {

        int count = 0;
        int xor = 0;

        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> sum = new HashMap<>();

        freq.put(0, 1);
        sum.put(0, 0);

        for (int k = 0; k < arr.length; k++) {

            xor ^= arr[k];

            if (freq.containsKey(xor)) {
                count += freq.get(xor) * k - sum.get(xor);
            }

            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
            sum.put(xor, sum.getOrDefault(xor, 0) + k + 1);
        }

        return count;
    }
}

--------------------------------------(Brute force approach)----------------------------------------

class Solution {
    public int countTriplets(int[] arr) {

        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int a = 0;

                // arr[i] ... arr[j-1]
                for (int x = i; x < j; x++) {
                    a ^= arr[x];
                }

                for (int k = j; k < n; k++) {

                    int b = 0;

                    // arr[j] ... arr[k]
                    for (int x = j; x <= k; x++) {
                        b ^= arr[x];
                    }

                    if (a == b) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
