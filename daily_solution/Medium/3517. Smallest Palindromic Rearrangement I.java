class Solution {
    public String smallestPalindrome(String s) {
        //we can create the frequency array for the given string

        int freq[]=new int[127];
        for(char c:s.toCharArray())
            freq[c]++;
        
        //character with odd frequency
        int oddcount=0;
        char oddchar = 0;
        for(int i=0;i<127;i++){
            if(freq[i]%2!=0){
                oddcount++;
                oddchar = (char) i;
            }
        }

        //oddcount less than 1 return not palindrome or ""
        if(oddcount>1)
            return "";

        //Build the first half
        StringBuilder half = new StringBuilder();
        for(int i=0;i<127;i++){
            for(int j=0;j<freq[i]/2;j++){
                half.append((char)i);
            }
        }
        String first = half.toString();
        String second = new StringBuilder(first).reverse().toString();
        if(oddcount==1)
            return first+oddchar+second;
        else
            return first+second;
    }
}
