import java.util.HashSet;

class WordSearch {
  static int[] rowDir = {-1,0,1,0};
  static int[] colDir = {0,1,0,-1};
  public boolean exist(char[][] board, String word) {
    HashSet<String> hset = new HashSet<>();
    if(board.length ==0. || board[0].length ==0) return false;
    int numRows = board.length;
    int numCols = board[0].length;

    boolean found = false;
    for(int i=0; i<numRows; i++){
      for(int j=0; j< numCols; j++){
        if(existUtil(board, i,j, 0, word, hset)){
          found = true;
          break;
        }
      }
    }

    return found;
  }

  boolean existUtil(char[][] board, int r, int c, int strIdx, String word, HashSet<String> hset){
    String pos = r+"_"+c;
    //if(strIdx == word.length) return true;
    if(hset.contains(pos) || board[r][c] != word.charAt(strIdx)) return false;
    if(strIdx == word.length()-1 && board[r][c] == word.charAt(strIdx)) return true;
    hset.add(pos);
    boolean found = false;
    for(int i=0; i< rowDir.length; i++){
      int newRowIdx = r+rowDir[i];
      int newColIdx = c+colDir[i];
//      if(isSafe(newRowIdx, newColIdx, board)){
//        if(existUtil(board, newRowIdx, newColIdx, strIdx+1, word, hset)){
//          found = true;
//          break;
//        }
//      }
    }
    hset.remove(pos);
    return found;
  }
}