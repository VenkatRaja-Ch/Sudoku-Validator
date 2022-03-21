//import java.util.*;
public class SudokuValidator
{

    // Function to check whether sudoku string is valid or not
    // Flag_Status: The body of the function is needed to be written and implemented
    static boolean sudokuIsValid( String sudoku )
    {
        String[] sudokuRowArray = new String[11];
        sudokuRowArray = extractSudokuRows( sudoku );

        return true;
    }

    // Function to extract the rows of a string
    // Flag_Status: The body of the function is needed to be written and implemented
    static String[] extractSudokuRows( String sudoku )
    {
        String[] array = new String[11];

        return array;
    }

    // Function to extract the columns of a string
    // Flag_Status: The body of the function is needed to be written and implemented
    static String[] sudokuColumns( String sudoku )
    {
        String[] array = new String[18];

        return array;
    }

    // Function to check whether Duplicate characters are present or not
    // Flag_Status : checked and working
    public static boolean isDuplicate(String passedString)
    {
        char[] givenString = passedString.toCharArray();    //converts the given string into array
        int stringLength = givenString.length;      //stores the length of the string
        boolean duplicateFound;

        //counting each character which is present in the string
        //Time: O(n^2)   Space: O(1)
        for(int indexI=0; indexI<stringLength; indexI++)
        {

            //checks for non sudoku row. eg: "------+------+------"
            boolean validRow = givenString[indexI] != '-';

            if (validRow) {

                for(int indexJ=indexI+1; indexJ<stringLength; indexJ++)
                {

                    // checks for the presence of the duplicate string
                    duplicateFound = ( (givenString[indexI] == givenString[indexJ])
                            && (givenString[indexI]!=' ')
                            && (givenString[indexI]!='0')
                            && (givenString[indexI]!='|') );

                    // if found then return true
                    if(duplicateFound)
                        return true;
                }
            }
        }

        // if no duplicate found then return false
        return false;
    }

    // Function to check whether sudoku string is complete or not
    static boolean sudokuIsComplete( String sudoku )
    {
        return true;
    }

    // main function
    public static void main(String[] ar)
    {

        /*-------- Sample Strings --------*/
        //                                    Row:1                    Row:2                      Row:3
        String validIncompleteSudoku = "8 5 0 |0 0 2 |4 0 0 " + "\n" + "7 2 0 |0 0 0 |0 0 9 " + "\n" + "0 0 4 |0 0 0 |0 0 0 " + "\n" +
                              //              Row:4                    Row:5                      Row:6
                                       "------+------+------" + "\n" + "0 0 0 |1 0 7 |0 0 2 " + "\n" + "3 0 5 |0 0 0 |9 0 0 " + "\n" +
                              //              Row:7                    Row:8                      Row:9
                                       "0 4 0 |0 0 0 |0 0 0 " + "\n" + "------+------+------" + "\n" + "0 0 0 |0 8 0 |0 7 0 " + "\n" +
                             //               Row:10                  Row:11
                                       "0 1 7 |0 0 0 |0 0 0 " + "\n" + "0 0 0 |0 3 6 |0 4 0 " + "\n";

        String test_Str_duplicateElements = "8 5 0 |0 0 2 |4 4 0 "; // duplicate string test case
        String test_Str_uniqueElements = "8 5 0 |0 0 2 |4 0 0 "; // unique string test case

        System.out.println("String Length: " + validIncompleteSudoku.length());
        /*-------- Sample Strings --------*/

        /*-------- Game workflow --------*/
        /*
        0 Start

        1 receive a sudoku puzzle

        2 check whether the received string is a valid sudoku puzzle or not. [boolean isSudokuValid]
            conditions for valid sudoku puzzle:
            -> No numbers are repeated in any of the rows. [function: isDuplicate( <- extract strings for each row ->)]
            -> No numbers are repeated in any of the column. [function: isDuplicate( <- extract strings for each column ->)]
            -> Every 9x9 square has no repeated numbers. [ if no numbers are repeated in above two functions]

            2.1 IF Step2 isValid:
                2.1.1 check whether the sudoku puzzle is complete or incomplete
                    conditions for complete sudoku puzzle
                    -> Every 9x9 square should not be empty.
                    -> that value should not be repeated in that entire row
                    -> that value should not be repeated in that entire column.

                    2.1.1.1 IF Step2.1.1 isValid:
                        2.1.1.1.1 Display the message: "The Sudoku puzzle is valid and complete
                    2.1.1.2 IF Step2.1.1 is inValid:
                        2.1.1.2.1 Display the message: "The Sudoku puzzle is valid but incomplete

            2.2 IF Step2 is inValid:
                2.2.1 Display the message: "The Sudoku puzzle is Invalid"

        3 Stop
         */
        /*-------- Game workflow --------*/

        /*-------- TESTING --------*/

        System.out.println("Given Sudoku: \n" + validIncompleteSudoku + "\n");

        boolean testForDuplicate = isDuplicate(test_Str_duplicateElements);
        boolean testForUnique = isDuplicate(test_Str_uniqueElements);

        if (( testForUnique )) {
            System.out.println("Duplicate  Found");
        } else {
            System.out.println("All Elements are unique");
        }

        if(testForDuplicate){
            System.out.println("Duplicate  Found");
        } else {
            System.out.println("All Elements are unique");
        }

        /*-------- TESTING --------*/
    }
}