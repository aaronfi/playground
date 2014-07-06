package MyKata;

import java.util.Arrays;
import java.util.Collections;

public class CountConnectedNodes {

    public int[][] board;
    public boolean[][] seen;

    public CountConnectedNodes(int[][] board) {
        this.board = board;
        seen = new boolean[board.length][];
        for(int i=0; i<board.length; i++) {
            seen[i] = new boolean[board.length];
        }
    }
    
    public int solve() {
        int count = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if (seen[i][j]) continue;
                if (board[i][j] == 1) {
                    count++;
                    process(i,j);
                }
            }
        }
        return count;
    }
    
    private void process(int i, int j) {
        try {
            if (seen[i][j]) return;
            seen[i][j] = true; 
            if (board[i][j] == 1) {
                process(i+1, j);
                process(i-1, j);
                process(i,   j+1);
                process(i,   j-1);
                process(i-1, j-1);
                process(i-1, j+1);
                process(i+1, j-1);
                process(i+1, j+1);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {}
        
    }
    
    public static void main(String[] args) {
        int b[][] = new int[4][];
        b[0] = new int[] { 0, 0, 0, 1 };
        b[1] = new int[] { 0, 1, 0, 1 };
        b[2] = new int[] { 0, 0, 0, 1 };
        b[3] = new int[] { 1, 1, 0, 1 };
        
        CountConnectedNodes c = new CountConnectedNodes(b);
        System.out.println(c.solve());        
    }
}
