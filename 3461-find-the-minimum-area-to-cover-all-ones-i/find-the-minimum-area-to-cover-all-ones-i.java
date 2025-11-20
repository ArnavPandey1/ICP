class Solution {
    public int minimumArea(int[][] grid) {
        int l1=grid.length-1;
        int l2=0;int b1=grid[0].length-1;int b2=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    l1=Math.min(i,l1);
                    l2=Math.max(i,l2);
                    b1=Math.min(b1,j);
                    b2=Math.max(b2,j);
                }
            }
        }
        return (l2-l1+1)*(b2-b1+1);
    }
}