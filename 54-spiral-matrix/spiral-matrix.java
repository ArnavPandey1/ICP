class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int rl=0,cl=0;
        int rh=mat.length-1,ch=mat[0].length-1;
        int c=0;
        int m=mat.length;int n=mat[0].length;
        List<Integer>l1=new ArrayList<>();
        while(c<m*n){
             for(int i=cl;i<=ch&&c<m*n;i++){
                l1.add(mat[rl][i]);
                c++;
             }
             rl++;
             for(int i=rl;i<=rh&&c<m*n;i++){
                l1.add(mat[i][ch]);
                c++;
             }
             ch--;
             for(int i=ch;i>=cl&&c<m*n;i--){
                l1.add(mat[rh][i]);
                c++;
             }
             rh--;
             for(int i=rh;i>=rl&&c<m*n;i--){
                l1.add(mat[i][cl]);
                c++;
             }
             cl++;
        }
        return l1;
    }
}