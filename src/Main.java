import data.SudokuBoard;
import validator.SudokuValidator;

// Professor Fulakeza I want to admit I think this program may not work for certain cases - I can explain in class if you want to check 

public class Main implements Runnable {
    public static void main(String [] SudokuValidator) {

        // locally initialized & customizable sudoku board
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

        // instance of sudoku board with local board passed in
        SudokuBoard sudokuBoard = new SudokuBoard(arr2D);

        // instance of sudoku validator to invoke the methods from that class
        SudokuValidator validator = new SudokuValidator();

        // the required 11 threads of HW assignment being initialized
        Thread rowsThread = new Thread();
        Thread columnsThread = new Thread();

        Thread subgridOne = new Thread();
        Thread subgridTwo = new Thread();
        Thread subgridThree = new Thread();
        Thread subgridFour = new Thread();
        Thread subgridFive = new Thread();
        Thread subgridSix = new Thread();
        Thread subgridSeven = new Thread();
        Thread subgridEight = new Thread();
        Thread subgridNine = new Thread();

        // all the thread individually being started
        rowsThread.start();
        try {
            boolean areRowsValid = validator.columnValidator(sudokuBoard.getSudokuBoard());
            System.out.println("Rows are " + areRowsValid);
        } catch (Exception e) {
        }

        columnsThread.start();
        try {
            boolean areColumnsValid = validator.rowValidator(sudokuBoard.getSudokuBoard());
            System.out.println("Columns are " + areColumnsValid);
        } catch (Exception e) {
        }

        subgridOne.start();
        try {
            boolean isSubgridOneValid = validator.subgridValidator(1, sudokuBoard.getSudokuBoard());
            System.out.println("Grid One is " + isSubgridOneValid);
        } catch (Exception e) {
        }

        subgridTwo.start();
        try {
            boolean isSubgridTwoValid = validator.subgridValidator(2, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Two is " + isSubgridTwoValid);
        } catch (Exception e) {
        }

        subgridThree.start();
        try {
            boolean isSubgridThreeValid = validator.subgridValidator(3, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Three is " + isSubgridThreeValid);
        } catch (Exception e) {
        }

        subgridFour.start();
        try {
            boolean isSubgridFourValid = validator.subgridValidator(5, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Four is " + isSubgridFourValid);
        } catch (Exception e) {
        }

        subgridFive.start();
        try {
            boolean isSubgridFiveValid = validator.subgridValidator(5, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Five is " + isSubgridFiveValid);
        } catch (Exception e) {

        }

        subgridSix.start();
        try {
            boolean isSubgridSixValid = validator.subgridValidator(6, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Six is " + isSubgridSixValid);
        } catch (Exception e) {

        }

        subgridSeven.start();
        try {
            boolean isSubgridSevenValid = validator.subgridValidator(7, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Seven is " + isSubgridSevenValid);
        } catch (Exception e) {

        }

        subgridEight.start();
        try {
            boolean isSubgridEightValid = validator.subgridValidator(8, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Eight is " + isSubgridEightValid);
        } catch (Exception e) {

        }

        subgridNine.start();
        try {
            boolean isSubgridNineValid = validator.subgridValidator(9, sudokuBoard.getSudokuBoard());
            System.out.println("Grid Nine is " + isSubgridNineValid);
        } catch (Exception e) {

        }
    }

    @Override
    public void run() {
    }
}
