class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()][p.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return match(s,p,0,0,dp);  
    }
    public static boolean match(String s,String p,int i,int j,int[][] dp){
        if(i>=s.length() && j>=p.length()){
            return true;
        }
        if(j>=p.length()){
            return false;
        }
        if(i>=s.length() && j<p.length()){
            while(j<p.length()){
                if(p.charAt(j)!='*'){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(dp[i][j]!=-1){
           if(dp[i][j]==1)
           return true;
           else
           return false;
        }

        if(s.charAt(i)==p.charAt(j) || (p.charAt(j)=='?')){
             dp[i][j]=match(s,p,i+1,j+1,dp)==false?0:1;
             return dp[i][j]==0?false:true;
        }
        else if(p.charAt(j)=='*'){
            dp[i][j]=(match(s,p,i,j+1,dp) || match(s,p,i+1,j,dp))==false?0:1;
            return dp[i][j]==0?false:true;
        }
        else{
            return false;
        }
        // return dp[i][j]==0?false:true;
    }
}