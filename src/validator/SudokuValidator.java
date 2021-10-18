package validator;

import data.SudokuBoard;

public class SudokuValidator {

//    int[][] arr2D = {
//        {6, 2, 4, 5, 3, 9, 1, 8, 7},
//        {5, 1, 9, 7, 2, 8, 6, 3, 4},
//        {8, 3, 7, 6, 1, 4, 2, 9, 5},
//        {1, 4, 3, 8, 6, 5, 7, 2, 9},
//        {9, 5, 8, 2, 4, 7, 3, 6, 1},
//        {7, 6, 2, 3, 9, 1, 4, 5, 8},
//        {3, 7, 1, 9, 5, 6, 8, 4, 2},
//        {4, 9, 6, 1, 8, 2, 5, 7, 3},
//        {2, 8, 5, 4, 7, 3, 9, 1, 6}
//};

    //    // array to store cardinality of elements in a set where element - 1 <==> index;
//    int[]cardinality;

    // comment: the logic seemed counterintuitive; this method's nested for loop that validates
    // sudoku rows iterates through columns and vice versa for the columnValidator(); nested loop will iterate rows
    // to validate columns
    public boolean rowValidator(int[][] arr2D) {
        int[]cardinality = new int[9];  // sudoku values' cardinality will be recorded at
        // indeces of this array. sudoku value 1's cardinality stored at cardinality[0]
        for(int rowIndex = 0; rowIndex < 9; rowIndex++){
            for(int columnIndex = 0; columnIndex < 9; columnIndex++){
                cardinality[arr2D[rowIndex][columnIndex]-1]+=1;
            }
        }
        return isValid(cardinality);
    }

    public boolean columnValidator(int[][] arr2D) {
        int[]cardinality = new int[9];  // sudoku values' cardinality will be recorded at
        // indeces of this array. sudoku value 1's cardinality stored at cardinality[0]
        for(int columnIndex = 0; columnIndex < 9; columnIndex++){
            for(int rowIndex = 0; rowIndex < 9; rowIndex++){
                cardinality[arr2D[rowIndex][columnIndex]-1]+=1;
            }
        }
        return isValid(cardinality);
    }

    public boolean subgridValidator(int subgridNum, int[][] arr2D) {
        int[] cardinality = new int[9];
        int i = 0;
        for(int row = subgridRowNum(subgridNum); row < row+3; row++) {
            for(int column = subgridColumnNum(subgridNum); column < column+3; column++) {
                cardinality[i] = arr2D[row][column];
            }
        }
        return isValid(cardinality);
    }

    public int subgridColumnNum(int subgridNum) {
        int subgridColumnNum;
        switch (subgridNum % 3) {
        case 1:
            subgridColumnNum = 0;
            break;
        case 2:
            subgridColumnNum = 3;
            break;
        case 3:
            subgridColumnNum = 4;
            break;
        default:
            subgridColumnNum = -1;
            break;
        }
        return subgridColumnNum;
    }

    public int subgridRowNum(int subgridNum) {
        int subgridRowNum;
        switch (subgridNum) {
            case 1:
            case 2:
            case 3:
                subgridRowNum = 0;
                break;
            case 4:
            case 5:
            case 6:
                subgridRowNum = 3;
                break;
            case 7:
            case 8:
            case 9:
                subgridRowNum = 6;
                break;
            default:
                subgridRowNum = -1;
                break;
        }
        return subgridRowNum;
    }

    private boolean isValid(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 1 || arr[i] == 0) { // false if there's more than one of same val or if there's no occurrence of a val
                return false;
            }
        }
        return true;
    }
}
