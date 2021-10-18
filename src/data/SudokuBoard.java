package data;

public class SudokuBoard {
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

    // array to store cardinality of elements in a set where element - 1 <==> index;
    int[]cardinality;

    // comment: the logic seemed counterintuitive; this method's nested for loop that validates
    // sudoku rows iterates through columns and vice versa for the columnValidator(); nested loop will iterate rows
    // to validate columns
    public boolean rowValidator() {
        int[]cardinality = new int[9];  // sudoku values' cardinality will be recorded at
                                        // indeces of this array. sudoku value 1's cardinality stored at cardinality[0]
        for(int rowIndex = 0; rowIndex < 9; rowIndex++){
            for(int columnIndex = 0; columnIndex < 9; columnIndex++){
                cardinality[arr2D[rowIndex][columnIndex]-1]+=1;
            }
        }
        return isValid(cardinality);
    }

    private boolean isValid(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 1) {
                return false;
            }
        }
        return true;
    }

//    public void sudokuBoard(int[][] arr) {
//        arr2D = arr;
//    }

}
