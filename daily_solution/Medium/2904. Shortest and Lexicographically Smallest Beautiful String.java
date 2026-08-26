class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int ones = 0;

        String result = "";

        for (int right = 0; right < s.length(); right++) {

            // Add right character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // Window is valid
            while (ones >= k) {

                String temp = s.substring(left, right + 1);

                // Update answer
                if (result.equals("") ||
                    temp.length() < result.length() ||
                    (temp.length() == result.length()
                     && temp.compareTo(result) < 0)) {

                    result = temp;
                }

                // Remove left character
                if (s.charAt(left) == '1') {
                    ones--;
                }

                left++;
            }
        }

        return result;
    }
}
-------------------------------------(or)----------------------------------------------
class Solution {
    static int count1s(String s){
        int count = 0;
        for(char c: s.toCharArray()){
            if(c=='1')
                count +=1;
        }
        return count;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String result = "";

        for(int i = 0;i<n;i++){
            for(int j =i+1;j<=n;j++){
                String temp = s.substring(i,j);
                int one = count1s(temp);
                if (one >= k) {

                    if (result.equals("") ||
                        temp.length() < result.length() ||
                        (temp.length() == result.length()
                         && temp.compareTo(result) < 0)) {

                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}

