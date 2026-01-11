class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
         int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return helper(0,0,obstacleGrid.length,obstacleGrid[0].length,dp,obstacleGrid);
     }
    public int helper(int i,int j,int m,int n,int dp[][],int obstacleGrid[][]){
        if(i>=m||i<0||j>=n||j<0||obstacleGrid[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(i==m-1 && j==n-1){
            return 1;
        }
        return dp[i][j]=helper(i,j+1,m,n,dp,obstacleGrid)+helper(i+1,j,m,n,dp,obstacleGrid);
    }
}