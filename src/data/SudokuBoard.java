package data;

public class SudokuBoard {

    int[][] sudokuBoard;

    public SudokuBoard() {
        // default board with zeros
        sudokuBoard = new int[9][9];
    }

    // takes in a new board (or the one assigned in the HW) and assigns the reference & class attribute sudokuBoard to that passed in array
    public SudokuBoard(int[][] arr) {
        sudokuBoard = arr;
    }

    // this method is never used in this version
    public int getSudokuBoardVal(int row, int column) {
        return sudokuBoard[row][column];
    }

    // returns address referring to game board
    public int[][] getSudokuBoard() {
        return sudokuBoard;
    }

    /*
    {6, 2, 4, 5, 3, 9, 1, 8, 7},
                {5, 1, 9, 7, 2, 8, 6, 3, 4},
                {8, 3, 7, 6, 1, 4, 2, 9, 5},
                {1, 4, 3, 8, 6, 5, 7, 2, 9},
                {9, 5, 8, 2, 4, 7, 3, 6, 1},
                {7, 6, 2, 3, 9, 1, 4, 5, 8},
                {3, 7, 1, 9, 5, 6, 8, 4, 2},
                {4, 9, 6, 1, 8, 2, 5, 7, 3},
                {2, 8, 5, 4, 7, 3, 9, 1, 6}
     */
}
