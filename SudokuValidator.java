public class SudokuValidator
{

    // Function to check whether sudoku string is valid or not
    // Flag_Status: working
    static boolean isValid( String sudoku )
    {
        String[] sudokuRowArray = extractSudokuRows( sudoku );   // length:11
        String[] sudokuColumnArray = extractSudokuColumns( sudoku ); // length: 18

        boolean rowIsNotUnique = true;
        boolean columnIsNotUnique = true;

        for(int index=0; index<11; index++)
        {
            rowIsNotUnique =  isDuplicate( sudokuRowArray[index] );

            if(rowIsNotUnique)
                return false;
        }

        for(int index=0; index<18; index++)
        {
            columnIsNotUnique = isDuplicate( sudokuColumnArray[index] );

            if(columnIsNotUnique)
                return false;
        }

        return true;
    }

    // Function to extract the rows of a string
    // Flag_Status: working
    static String[] extractSudokuRows( String sudoku )
    {
        String[] rowsExtracted = new String[11];
        String row = null;
        int startIndex = 0;
        int endIndex = 19;

        for( int index=0; index<11; index++ )
        {
            row = sudoku.substring(startIndex, endIndex);
            startIndex += 21;
            endIndex += 21;
            rowsExtracted[index] = row;
        }

        return rowsExtracted;
    }

    // Function to extract the columns of a string
    // Flag_Status: working
    static String[] extractSudokuColumns( String sudoku )
    {
        String[] columnsExtracted = new String[18];
        char[] columnPieces = sudoku.toCharArray();
        int totalColumns = 18;

        // to store each extracted column in the array
        for( int currentColumnNumber=0; currentColumnNumber<totalColumns; currentColumnNumber++)
        {
            int index = currentColumnNumber;
            String column = null;

            // concatenate the pieces extracted from each row of that column
            for( int indexJ=0; indexJ<11; indexJ++)
            {
                column += columnPieces[index];
                index += 21;
            }

            // extract "null" from the string and store it in column
            columnsExtracted[currentColumnNumber] = column.substring(4);
        }

        return columnsExtracted;
    }

    // Function to check whether Duplicate characters are present or not
    // Flag_Status : working
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
            boolean validRow = (givenString[indexI] != '-') &&  (givenString[indexI] != '|');

            if (validRow) {

                for(int indexJ=indexI+1; indexJ<stringLength; indexJ++)
                {

                    // checks for the presence of the duplicate string
                    duplicateFound = ( (givenString[indexI] == givenString[indexJ])
                            && (givenString[indexI]!=' ')
                            && (givenString[indexI]!='0')
                            && (givenString[indexI]!='|')
                            && (givenString[indexI]!='-')
                            && (givenString[indexI]!='+') );

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
    // Flag_Status : working
    static boolean isComplete( String sudoku )
    {
        char[] sudokuCharacters = sudoku.toCharArray();
        int length = sudokuCharacters.length;

        for(int index=0; index<length; index++)
        {
            if(sudokuCharacters[index] == '0')
                return false;
        }

        return true;
    }

    // main function
    public static void main(String[] ar)
    {

        /*-------- Sample Strings --------*/
        //                                    Row:1                       Row:2                      Row:3
        String validIncompleteSudoku = "8 5 0 |0 0 2 |4 0 0 " + "\n" + "7 2 0 |0 0 0 |0 0 9 " + "\n" + "0 0 4 |0 0 0 |0 0 0 " + "\n" +
                              //              Row:4                      Row:5                      Row:6
                                       "------+------+------" + "\n" + "0 0 0 |1 0 7 |0 0 2 " + "\n" + "3 0 5 |0 0 0 |9 0 0 " + "\n" +
                              //              Row:7                      Row:8                      Row:9
                                       "0 4 0 |0 0 0 |0 0 0 " + "\n" + "------+------+------" + "\n" + "0 0 0 |0 8 0 |0 7 0 " + "\n" +
                             //               Row:10                     Row:11
                                       "0 1 7 |0 0 0 |0 0 0 " + "\n" + "0 0 0 |0 3 6 |0 4 0 " + "\n";



        //                                    Row:1                     Row:2                      Row:3
        String validCompleteSudoku = "6 3 9 |5 7 4 |1 8 2 " + "\n" + "5 4 1 |8 2 9 |3 7 6 " + "\n" + "7 8 2 |6 1 3 |9 5 4 " + "\n" +
                              //              Row:4                    Row:5                      Row:6
                                     "------+------+------" + "\n" + "1 9 8 |4 6 7 |5 2 3 " + "\n" + "3 6 5 |9 8 2 |4 1 7 " + "\n" +
                              //              Row:7                    Row:8                      Row:9
                                     "4 2 7 |1 3 5 |8 6 9 " + "\n" + "------+------+------" + "\n" + "9 5 6 |7 4 8 |2 3 1 " + "\n" +
                             //               Row:10                  Row:11
                                     "8 1 3 |2 9 6 |7 4 5 " + "\n" + "2 7 4 |3 5 1 |6 9 8 " + "\n";

        //                                    Row:1                     Row:2                      Row:3
        String invalidSudoku = "6 3 9 |5 7 7 |1 8 2 " + "\n" + "5 4 1 |8 2 9 |3 7 6 " + "\n" + "7 8 2 |6 1 3 |9 5 4 " + "\n" +
                            //              Row:4                    Row:5                      Row:6
                            "------+------+------" + "\n" + "1 9 8 |4 6 7 |5 2 3 " + "\n" + "3 6 5 |9 8 2 |4 1 7 " + "\n" +
                            //              Row:7                    Row:8                      Row:9
                            "4 2 7 |1 3 5 |8 6 9 " + "\n" + "------+------+------" + "\n" + "9 5 6 |7 4 8 |2 3 1 " + "\n" +
                            //               Row:10                  Row:11
                            "8 1 3 |2 9 6 |7 4 5 " + "\n" + "2 7 4 |3 5 1 |6 9 8 " + "\n";

        String test_Str_duplicateElements = "8 5 0 |0 0 2 |4 4 0 "; // duplicate string test case
        String test_Str_uniqueElements = "8 5 0 |0 0 2 |4 0 0 "; // unique string test case

        /*-------- Sample Strings --------*/

        /*-------- Workflow --------*/

        // check if the given sudoku string is valid or not
        boolean sudokuIsValid = isValid( validCompleteSudoku );
        if( sudokuIsValid )
        {
            // checking whether the sudoku string is completed or not
            boolean sudokuIsComplete = isComplete( validCompleteSudoku );
            if (sudokuIsComplete)
            {
                System.out.println("The given sudoku string is valid and complete.");
            }
            else
            {
                System.out.println("The given sudoku string is valid and incomplete.");
            }
        } else
        {
            System.out.println("The Given Sudoku string is not a valid.");
        }


        /*-------- Workflow --------*/

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


        /*-------- TEST CASES --------*/

        /*          Test code for testing duplicate elements in the strings  */

//        boolean testForDuplicate = isDuplicate(test_Str_duplicateElements);
//        boolean testForUnique = isDuplicate(test_Str_uniqueElements);
//
//        if (( testForUnique )) {
//            System.out.println("Duplicate  Found");
//        } else {
//            System.out.println("All Elements are unique");
//        }
//
//        if(testForDuplicate){
//            System.out.println("Duplicate  Found");
//        } else {
//            System.out.println("All Elements are unique");
//        }


        /*          Test code for testing Row Extractor  */

//        String[] sudokuRowArray = new String[11];
//        sudokuRowArray = extractSudokuRows( validIncompleteSudoku );
//        int length = 11;
//        for(int index=0; index<length; index++)
//            System.out.println(sudokuRowArray[index]);


        /*          Test code for testing Column Extractor  */
//        String[] sudokuColumnArray = extractSudokuColumns( validIncompleteSudoku );
//        int length = 18;
//        for(int index=0; index<length; index++)
//            System.out.println(sudokuColumnArray[index]);

        /*-------- TEST CASES --------*/
    }
}