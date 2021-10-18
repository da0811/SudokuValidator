import data.SudokuBoard;

public class Main {
    public static void main(String [] SudokuValidator) {
        System.out.print("The Sudoku values are ");
        if(validate(SudokuBoard.sudokuVals)) {
            System.out.println("valid.");
        }
        else {
            System.out.println("invalid.");
        }
    }


}
