class TicTacToe {
    int[] rowCount;
    int[] colCount;
    int diagonalCount;
    int antiDiagonalCount;
    int N;

    public TicTacToe(int n) {
        rowCount = new int[n];
        colCount = new int[n];
        Arrays.fill(rowCount,0);
        Arrays.fill(colCount,0);
        diagonalCount = 0;
        antiDiagonalCount = 0;
        N = n;
    }

    public int move(int row, int col, int player) {
        if (player == 1) {
            rowCount[row]++;
            colCount[col]++;
            if (row == col)
                diagonalCount++;
            if (col == N - row - 1)
                antiDiagonalCount++;

            if (rowCount[row] == N || colCount[col] == N || diagonalCount == N || antiDiagonalCount == N) {
                return player;
            }
        } else if (player == 2) {
            rowCount[row]--;
            colCount[col]--;
            if (row == col)
                diagonalCount--;
            if (col == N - row - 1) //important observation
                antiDiagonalCount--;

            if (rowCount[row] == -N || colCount[col] == -N || diagonalCount == -N || antiDiagonalCount == -N) {
                return player;
            }
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */