package MyKata;

// Author: aaronfi@ 2010.06.10
//
// Given an n-by-m array of booleans, write code that returns the number of adjacent neighbors set
// to true for a given point x, y.  i.e. count only the up/down/left/right neighbors, not the point
// itself.
//
// I apply the Factory pattern here so I can try out multiple solutions.

public class NeighborCount {
    public enum Solutions {
        TryCatch,
        BoundaryCheck1,
        BoundaryCheck2,
    }

    private Boolean board[][];
    private Solutions solutionType;

    public NeighborCount(Boolean initBoard[][]) {
        this.board = initBoard;
        this.solutionType = Solutions.TryCatch;
    }

    public NeighborCount(Boolean initBoard[][], Solutions initSolutionType) {
        this.board = initBoard;
        this.solutionType = initSolutionType;
    }

    public int count(int x, int y) {
        int count = 0;
        switch(this.solutionType) {
            case TryCatch:
                count = count_TryCatch(x,y);
                break;
            case BoundaryCheck1:
                count = count_BoundaryCheck1(x,y);
                break;
            case BoundaryCheck2:
                count = count_BoundaryCheck2(x,y);
                break;
            default:
                throw new RuntimeException("Programming error, default case should never occur.");
        }
        return count;
    }

    private int count_TryCatch(int x, int y) {
        int count = 0;

        try { if (this.board[x-1][y]) count++; } catch (ArrayIndexOutOfBoundsException e) {}
        try { if (this.board[x+1][y]) count++; } catch (ArrayIndexOutOfBoundsException e) {}
        try { if (this.board[x][y-1]) count++; } catch (ArrayIndexOutOfBoundsException e) {}
        try { if (this.board[x][y+1]) count++; } catch (ArrayIndexOutOfBoundsException e) {}

        return count;
    }

    private int count_BoundaryCheck1(int x, int y) {
        int count = 0;

        if (x >= 0 && x < this.board.length) {
            if (y-1 >= 0 && y-1 < this.board[x].length && this.board[x][y-1]) count++;
            if (y+1 < this.board[x].length && this.board[x][y+1]) count++;
        }

        if (x-1 >= 0 && x-1 < this.board.length) {
            if (y >= 0 && y < this.board[x-1].length && this.board[x-1][y]) count++;
        }

        if (x+1 >= 0 && x+1 < this.board.length) {
            if (y >= 0 && y < this.board[x+1].length && this.board[x+1][y]) count++;
        }

        return count;
    }

    private boolean isInArrayBounds(int index, Object[] arr) {
        return (index >= 0 && index < arr.length);
    }

    private int count_BoundaryCheck2(int x, int y) {
        int count = 0;

        if (isInArrayBounds(x, this.board)) {
            if (isInArrayBounds(y-1, this.board[x]) && this.board[x][y-1]) count++;
            if (isInArrayBounds(y+1, this.board[x]) && this.board[x][y+1]) count++;
        }

        if (isInArrayBounds(x-1, this.board)) {
            if (isInArrayBounds(y, this.board[x-1]) && this.board[x-1][y]) count++;
        }

        if (isInArrayBounds(x+1, this.board)) {
            if (isInArrayBounds(y, this.board[x+1]) && this.board[x+1][y]) count++;
        }

        return count;
    }

    public static void main(String[] args) {
    }

}
