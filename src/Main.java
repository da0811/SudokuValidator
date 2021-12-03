import data.SudokuBoard;
import validator.SudokuValidator;

public class Main implements Runnable {

    // locally initialized sudoku board
    int[][] arr2D2 = {
            {2, 2, 4, 5, 3, 9, 1, 8, 7},
            {5, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {1, 4, 3, 8, 6, 5, 7, 2, 9},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}
    };

    SudokuValidator validator1 = new SudokuValidator();

    SudokuBoard sudokuBoard1 = new SudokuBoard(arr2D2);

    boolean isTrue2[] = new boolean[11];

    Thread rowsThread2 = new Thread();


    public static void main(String [] SudokuValidator) {

        Main mainThread = new Main();

        // the required 11 threads of HW assignment being initialized - there are 12 total if you include main thread
        Thread rowsThread = new Thread(mainThread, "rows");
        Thread columnsThread = new Thread(mainThread, "columns");

        Thread subgridOne = new Thread(mainThread, "subgridOne");
        Thread subgridTwo = new Thread(mainThread, "subgridTwo");
        Thread subgridThree = new Thread(mainThread, "subgridThree");
        Thread subgridFour = new Thread(mainThread, "subgridFour");
        Thread subgridFive = new Thread(mainThread, "subgridFive");
        Thread subgridSix = new Thread(mainThread, "subgridSix");
        Thread subgridSeven = new Thread(mainThread, "subgridSeven");
        Thread subgridEight = new Thread(mainThread, "subgridEight");
        Thread subgridNine = new Thread(mainThread, "subgridNine");

        try {
            // all the thread individually being started
            rowsThread.start();
            columnsThread.start();
            subgridOne.start();
            subgridTwo.start();
            subgridThree.start();
            subgridFour.start();
            subgridFive.start();
            subgridSix.start();
            subgridSeven.start();
            subgridEight.start();
            subgridNine.start();
        }
        catch(Exception e) {

        }

        try {
           subgridNine.join();
           subgridEight.join();
           subgridSeven.join();
           subgridSix.join();
           subgridFive.join();
           subgridFour.join();
           subgridThree.join();
           subgridTwo.join();
           subgridOne.join();
           columnsThread.join();
           rowsThread.join();

        }
        catch(Exception e) {

        }

        boolean k = true;
//        System.out.println(k);

        for(int i = 0; i < mainThread.isTrue2.length; i++) {
            if(mainThread.isTrue2[i] == false) {
                k = false;
                break;
            }
//            System.out.println(isTrue[i]);
        }
        if(k == true) {
            System.out.println("The solution is correct");
        }
        else {
            System.out.println("The solution is incorrect");
        }
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
//        System.out.println(name);

        if(name.equals("rows")) { // if the thread's name is rows, that thread will handle areRowsValid
            try {
                boolean areRowsValid = validator1.columnValidator(sudokuBoard1.getSudokuBoard());
                isTrue2[0] = areRowsValid;
//            System.out.println("Rows are " + areRowsValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("columns")) {
            try {
                boolean areColumnsValid = validator1.rowValidator(sudokuBoard1.getSudokuBoard());
                isTrue2[1] = areColumnsValid;
//            System.out.println("Columns are " + areColumnsValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("subgridOne")) {
            try {
                boolean isSubgridOneValid = validator1.subgridValidator(1, sudokuBoard1.getSudokuBoard());
                isTrue2[2] = isSubgridOneValid;
//            System.out.println("Grid One is " + isSubgridOneValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("subgridTwo")) {
            try {
                boolean isSubgridTwoValid = validator1.subgridValidator(2, sudokuBoard1.getSudokuBoard());
                isTrue2[3] = isSubgridTwoValid;
//            System.out.println("Grid Two is " + isSubgridTwoValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("subgridThree")) {
            try {
                boolean isSubgridThreeValid = validator1.subgridValidator(3, sudokuBoard1.getSudokuBoard());
                isTrue2[4] = isSubgridThreeValid;
//            System.out.println("Grid Three is " + isSubgridThreeValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("subgridFour")) {
            try {
                boolean isSubgridFourValid = validator1.subgridValidator(4, sudokuBoard1.getSudokuBoard());
                isTrue2[5] = isSubgridFourValid;
//            System.out.println("Grid Four is " + isSubgridFourValid);
            } catch (Exception e) {
            }
        }
        else if(name.equals("subgridFive")) {
            try {
                boolean isSubgridFiveValid = validator1.subgridValidator(5, sudokuBoard1.getSudokuBoard());
                isTrue2[6] = isSubgridFiveValid;
//            System.out.println("Grid Five is " + isSubgridFiveValid);
            } catch (Exception e) {

            }
        }
        else if(name.equals("subgridSix")) {
            try {
                boolean isSubgridSixValid = validator1.subgridValidator(6, sudokuBoard1.getSudokuBoard());
                isTrue2[7] = isSubgridSixValid;
//            System.out.println("Grid Six is " + isSubgridSixValid);
            } catch (Exception e) {

            }
        }
        else if(name.equals("subgridSeven")) {
            try {
                boolean isSubgridSevenValid = validator1.subgridValidator(7, sudokuBoard1.getSudokuBoard());
                isTrue2[8] = isSubgridSevenValid;
//            System.out.println("Grid Six is " + isSubgridSixValid);
            } catch (Exception e) {

            }
        }
        else if(name.equals("subgridEight")) {
            try {
                boolean isSubgridEightValid = validator1.subgridValidator(8, sudokuBoard1.getSudokuBoard());
                isTrue2[9] = isSubgridEightValid;
//            System.out.println("Grid Six is " + isSubgridSixValid);
            } catch (Exception e) {

            }
        }
        else if(name.equals("subgridNine")) {
            try {
                boolean isSubgridNineValid = validator1.subgridValidator(9, sudokuBoard1.getSudokuBoard());
                isTrue2[10] = isSubgridNineValid;
//            System.out.println("Grid Six is " + isSubgridSixValid);
            } catch (Exception e) {

            }
        }


    }
}
