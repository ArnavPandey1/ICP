class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans=search(board,i,j,word,0);
                    if(ans==true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean search(char[][] board,int i,int j,String word,int idx){
        if (idx == word.length()) {
        return true;
    }
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(idx)) {
        return false;
    }

    char temp = board[i][j]; 
    board[i][j] = '*'; 
    boolean found =
        search(board, i + 1, j, word, idx + 1) ||  
        search(board, i - 1, j, word, idx + 1) ||  
        search(board, i, j + 1, word, idx + 1) ||  
        search(board, i, j - 1, word, idx + 1);    

    board[i][j] = temp; 

    return found;
    }
}