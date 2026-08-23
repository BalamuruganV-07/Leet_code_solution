class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        if(n%2!=0) return false;

        int half = n/2;
        int lsum = 0, rsum=0, lq=0,rq=0;
        char a[]=num.toCharArray();
        for(int i=0;i<half;i++){
            if(a[i]=='?')
                lq+=1;
            else
                lsum += a[i]-'0';
        }
        for(int i=half;i<n;i++){
            if(a[i]=='?')
                rq+=1;
            else
                rsum += a[i]-'0'; 
        }

        if((lq+rq)%2==1)
            return true;
        
        return (lsum-rsum)!=(rq-lq)*9/2;
        
    }
}
