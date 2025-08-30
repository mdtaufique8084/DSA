class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r=0;r<9;r++){
            Set<Character> set=new HashSet<>();
            for(int c=0;c<9;c++){
                char ch=board[r][c];
                if(ch=='.') continue;
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }
        
        for(int c=0;c<9;c++){
            Set<Character> set=new HashSet<>();
            for(int r=0;r<9;r++){
                char ch=board[r][c];
                if(ch=='.') continue;
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }

        for(int sr=0;sr<9;sr+=3){
            int er=sr+2;
            for(int sc=0;sc<9;sc+=3){
                int ec=sc+2;
                if(!validate(board,sr,er,sc,ec)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean validate(char[][] board,int sr,int er,int sc,int ec){
        Set<Character> set=new HashSet<>();
        for(int r=sr;r<=er;r++){
            for(int c=sc;c<=ec;c++){
                char ch=board[r][c];
                if(ch=='.') continue;
                if(set.contains(ch)){
                    return false;
                }
                set.add(ch);
            }
        }
        return true;
    }
}