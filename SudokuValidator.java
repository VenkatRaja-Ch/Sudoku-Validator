//import java.util.*;
public class SudokuValidator
{

    // Function to check whether Duplicate characters are present or not
    public static boolean isDuplicate(String passedString)
    {
        char[] givenString = passedString.toCharArray();    //converts the given string into array
        int stringLength = givenString.length;      //stores the length of the string

        //counting each character which is present in the string
        //Time: O(n^2)   Space: O(1)
        for(int indexI=0; indexI<stringLength; indexI++)
        {

            //checks for non sudoku row. eg: "------+------+------"
            boolean sudokuRow = givenString[indexI] != '-';

            if (sudokuRow) {

                for(int indexJ=indexI+1; indexJ<stringLength; indexJ++)
                {

                    // checks for the presence of the duplicate string
                    boolean duplicateFound = (givenString[indexI] == givenString[indexJ])
                            && (givenString[indexI]!=' ')
                            && (givenString[indexI]!='0')
                            && (givenString[indexI]!='|');

                    // if found then return true
                    if(duplicateFound)
                        return true;
                }
            }
        }

        // if no duplicate found then return false
        return false;
    }


    // main function
    public static void main(String[] ar)
    {

        //                                    Row:1                    Row:2                      Row:3
        String validIncompleteSudoku = "8 5 0 |0 0 2 |4 0 0 " + "\n" + "7 2 0 |0 0 0 |0 0 9 " + "\n" + "0 0 4 |0 0 0 |0 0 0 " + "\n" +
                              //              Row:4                    Row:5                      Row:6
                                       "------+------+------" + "\n" + "0 0 0 |1 0 7 |0 0 2 " + "\n" + "3 0 5 |0 0 0 |9 0 0 " + "\n" +
                              //              Row:7                    Row:8                      Row:9
                                       "0 4 0 |0 0 0 |0 0 0 " + "\n" + "------+------+------" + "\n" + "0 0 0 |0 8 0 |0 7 0 " + "\n" +
                             //               Row:10                  Row:11
                                       "0 1 7 |0 0 0 |0 0 0 " + "\n" + "0 0 0 |0 3 6 |0 4 0 " + "\n";


        System.out.println("Given Sudoku: \n" + validIncompleteSudoku + "\n");

        //String test = "8 5 0 |0 0 2 |4 0 0 ";
    }
}