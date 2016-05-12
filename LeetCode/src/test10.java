package net.zwb;

public class test10 {

    public static boolean exist(char[][] board, String word) {
        int row=board.length;
        char[] w=word.toCharArray();
        if(row<1){
            return false;
        }
        int col=board[0].length;
        boolean[][]flag=new boolean[row][col];
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		flag[i][j]=true;
        	}
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==word.charAt(0)){
                	flag[i][j]=false;
                    if(wheExists(board,i,j,word.substring(1),flag)){
                        return true;
                    }
                    flag[i][j]=true; 
                }
            }
        }
        return false;
    }
    public static boolean wheExists(char[][]board,int i,int j,String w,boolean[][]flag){
        if(0==w.length()){
            return true;
        }
        char c=w.charAt(0);
        if(i+1<board.length&&board[i+1][j]==c&&wheExists(board,i+1,j,w.substring(1),flag)&&flag[i+1][j]){
        	flag[i+1][j]=false;
            return true;
        }
        if(i>=1&&board[i-1][j]==c&&wheExists(board,i-1,j,w.substring(1),flag)&&flag[i-1][j]){
        	flag[i-1][j]=false;
        	return true;
        }
        if(j+1<board[0].length&&board[i][j+1]==c&&wheExists(board,i,j+1,w.substring(1),flag)&&flag[i][j+1]){
        	flag[i][j+1]=false;
        	return true;
        }
        if(j>=1&&board[i][j-1]==c&&wheExists(board,i,j-1,w.substring(1),flag)&&flag[i][j-1]){
        	flag[i][j-1]=false;
             return true;
        }
        return false;
    }
	 
	 public static void main(String[]args){
		char[][]a={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String b="ABCESCED";
		long x = System.currentTimeMillis();
		System.out.println(exist(a,b));
		long y = System.currentTimeMillis();
		System.out.println(y-x);
		System.out.println(b.substring(1));
		
	 }
}
