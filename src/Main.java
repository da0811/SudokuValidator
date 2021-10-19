import data.SudokuBoard;
import validator.SudokuValidator;

public class Main implements Runnable {
    public static void main(String [] SudokuValidator) {

        int[][] arr2D = {
                {6, 2, 4, 5, 3, 9, 1, 8, 7},
                {5, 1, 9, 7, 2, 8, 6, 3, 4},
                {8, 3, 7, 6, 1, 4, 2, 9, 5},
                {1, 4, 3, 8, 6, 5, 7, 2, 9},
                {9, 5, 8, 2, 4, 7, 3, 6, 1},
                {7, 6, 2, 3, 9, 1, 4, 5, 8},
                {3, 7, 1, 9, 5, 6, 8, 4, 2},
                {4, 9, 6, 1, 8, 2, 5, 7, 3},
                {2, 8, 5, 4, 7, 3, 9, 1, 6}
        };
        SudokuBoard sudokuBoard = new SudokuBoard(arr2D);

        SudokuValidator validator = new SudokuValidator();

        boolean areRowsValid = validator.columnValidator(sudokuBoard.getSudokuBoard());
        boolean areColumnsValid = validator.rowValidator(sudokuBoard.getSudokuBoard());

        boolean isSubgridOneValid = validator.subgridValidator(1, sudokuBoard.getSudokuBoard());
        boolean isSubgridTwoValid = validator.subgridValidator(2, sudokuBoard.getSudokuBoard());
        boolean isSubgridThreeValid = validator.subgridValidator(3, sudokuBoard.getSudokuBoard());
        boolean isSubgridFourValid = validator.subgridValidator(4, sudokuBoard.getSudokuBoard());
        boolean isSubgridFiveValid = validator.subgridValidator(5, sudokuBoard.getSudokuBoard());
        boolean isSubgridSixValid = validator.subgridValidator(6, sudokuBoard.getSudokuBoard());
        boolean isSubgridSevenValid = validator.subgridValidator(7, sudokuBoard.getSudokuBoard());
        boolean isSubgridEightValid = validator.subgridValidator(8, sudokuBoard.getSudokuBoard());
        boolean isSubgridNineValid = validator.subgridValidator(9, sudokuBoard.getSudokuBoard());

        System.out.println("Rows are " + areRowsValid);
        System.out.println("Columns are " + areColumnsValid);
        boolean areGridsValid = false;
        if(     isSubgridOneValid &&
                isSubgridTwoValid &&
                isSubgridThreeValid &&
                isSubgridFourValid &&
                isSubgridFiveValid &&
                isSubgridSixValid &&
                isSubgridSevenValid &&
                isSubgridEightValid &&
                isSubgridNineValid) {
            areGridsValid = true;
        }

        System.out.println("Grids are " + areGridsValid);



    }

    @Override
    public void run() {
    }

    /*
    System.out.print("The Sudoku values are ");
            if(validate(SudokuBoard.sudokuVals)) {
                System.out.println("valid.");
            }
            else {
                System.out.println("invalid.");
            }
        }
     */
}
