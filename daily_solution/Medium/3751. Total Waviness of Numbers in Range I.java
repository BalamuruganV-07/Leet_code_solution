class Solution {
    public int totalWaviness(int num1, int num2) {

        int result = 0;

        for (int i = num1; i <= num2; i++) {

            int[] arr = new int[10];
            int len = 0;

            int temp = i;        // Don't modify i

            while (temp != 0) {
                arr[len++] = temp % 10;
                temp /= 10;
            }

            if (len < 3)
                continue;

            for (int j = 1; j < len - 1; j++) {

                if ((arr[j] > arr[j - 1] && arr[j] > arr[j + 1]) ||
                    (arr[j] < arr[j - 1] && arr[j] < arr[j + 1])) {

                    result++;   // Count every peak/valley
                }
            }
        }

        return result;
    }
}
