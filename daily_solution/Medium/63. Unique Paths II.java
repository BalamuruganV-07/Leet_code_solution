class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length,c=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1)
            return 0;
        int dp[][]=new int[r][c];
        dp[0][0]=1;
        
        for(int i=1;i<r;i++){
            if(obstacleGrid[i][0]==0)
                dp[i][0]=dp[i-1][0];
        }
        for(int j=1;j<c;j++){
            if(obstacleGrid[0][j]==0)
                dp[0][j]=dp[0][j-1];
            
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[r-1][c-1];
    }
}
