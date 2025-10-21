class Solution {
    public int maximalRectangle(char[][] matrix) {
        int prefix[][]=new int [matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++){
            int c=0;
            for(int i=0;i<matrix.length;i++){
                if(matrix[i][j]=='1'){
                    prefix[i][j]=c+1;
                    c=c+1;
                }
                else{
                    c=0;
                }
            }
        }
        int maximum=0;
        for(int i=0;i<prefix.length;i++){
            maximum=Math.max(maximum, largestRectangleArea(prefix[i]));
        }
        return maximum;
    }
    public int largestRectangleArea(int[] heights) {
        int n[]=new int[heights.length];
        int p[]=new int[heights.length];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                n[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            n[st.pop()]=heights.length;
        }
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                p[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            p[st.pop()]=-1;
        }
        int max=0;
        for(int i=0;i<heights.length;i++){
            int ht=heights[i];
            int wt=n[i]-p[i]-1;
            max=Math.max(max,ht*wt);
        }
        return max;
    }
}