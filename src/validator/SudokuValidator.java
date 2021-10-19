package validator;

public class SudokuValidator {

    int[] cardinality;

    public boolean rowValidator(int[][] arr2D) {
        cardinality = new int[9];  // sudoku values' cardinality will be recorded at
        // indices of this array. sudoku value 1's cardinality stored at cardinality[0]
        for(int rowIndex = 0; rowIndex < 9; rowIndex++){
            for(int columnIndex = 0; columnIndex < 9; columnIndex++){
                cardinality[(arr2D[rowIndex][columnIndex])-1]++;
            }
        }
        return isValid(cardinality);
    }

    public boolean columnValidator(int[][] arr2D) {
        cardinality = new int[9];  // sudoku values' cardinality will be recorded at
        // indices of this array. sudoku value 1's cardinality stored at cardinality[0]
        for(int columnIndex = 0; columnIndex < 9; columnIndex++){
            for(int rowIndex = 0; rowIndex < 9; rowIndex++){
                cardinality[(arr2D[rowIndex][columnIndex])-1]++;
            }
        }
        return isValid(cardinality);
    }

    // this method validates whether a given grid, numbered 1 thru 9 left to right, top to bottom
    // is equal to the sum of a cardinality array whose values are all 1s. this sum should be 9
    public boolean subgridValidator(int subgridNum, int[][] arr2D) {
        cardinality = new int[9];
        int rowUpperBound = getSubgridRowIndex(subgridNum) + 3; // i just need it to work
        int columnUpperBound = getSubgridColumnIndex(subgridNum) + 3; // i would have liked to make this cleaner
        for(int rowIndex = getSubgridRowIndex(subgridNum); rowIndex < rowUpperBound; rowIndex++) {
            for(int columnIndex = getSubgridColumnIndex(subgridNum); columnIndex < columnUpperBound; columnIndex++) {
                cardinality[(arr2D[rowIndex][columnIndex])-1]++;
            }
        }
        return isGridValid(cardinality);
    }

    // terribly inconsistent validation compared to vertical/horizontal validation
    private boolean isGridValid(int[] cardinality) {
        int sum = 0;
        for(int i = 0; i < cardinality.length; i++) {
            sum+=cardinality[i];
        }

        return sum == 9;
    }

    // this method returns the starting index that a foor loop should begin
    public int getSubgridColumnIndex(int subgridNum) {
        int columnIndex;
        switch (subgridNum) {
            case 1:
                columnIndex = 0;
                break;
            case 2:
                columnIndex = 3;
                break;
            case 3:
                columnIndex = 6;
                break;
            case 4:
                columnIndex = 0;
                break;
            case 5:
                columnIndex = 3;
                break;
            case 6:
                columnIndex = 6;
                break;
            case 7:
                columnIndex = 0;
                break;
            case 8:
                columnIndex = 3;
                break;
            case 9:
                columnIndex = 6;
                break;
            default:
                columnIndex = -1;
                break;
        }
        return columnIndex;
    }

    // this method returns one of the 2 indices needed
    public int getSubgridRowIndex(int subgridNum) {
        int rowIndex;
        switch (subgridNum) {
            case 1:
            case 2:
            case 3:
                rowIndex = 0;
                break;
            case 4:
            case 5:
            case 6:
                rowIndex = 3;
                break;
            case 7:
            case 8:
            case 9:
                rowIndex = 6;
                break;
            default:
                rowIndex = -1;
                break;
        }
        return rowIndex;
    }

    // validates whether there are 1 of each value in a given row or column by checking if the sum of
    // the array cardinality values is equal to 9 which also happens to be its length of 9
    private boolean isValid(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
//            if(arr[i] > 1 || arr[i] == 0) { // false if there's more than one of same val or if there's no occurrence of a val
            if(arr[i] != arr.length) { // there's 1 occurrence of a given val per row, there are 9 rows, we need to verify cardinality = 9
                return false;
            }
        }
        return true;
    }
}
