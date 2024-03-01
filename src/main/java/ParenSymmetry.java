package src.main.java;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParenSymmetry {

    private static Boolean isBalanced(String s) {
        int openCount = 0;
        int closedCount = 0;
        boolean startsWithClosed = true;
        // implement this method
        char[] wordToChar = s.toCharArray();

        boolean isTrueOrFalse;
        // count open and closed parenthesis
        for (int i = 0; i < wordToChar.length; i++) {
            if (wordToChar[0] == ')') {
                startsWithClosed = false;
            }
            if (wordToChar[i] == ('(')) {
                openCount++;
            }
            if (wordToChar[i] == (')')) {
                closedCount++;
            }
        }
        // compare the count of open and closed parenthesis
        //  -- if counts are the same, return true, else return false
        if (startsWithClosed == false) {
            return false;
        } else if (openCount == closedCount) {
            return true;
        }
        else {
            return false;
        }
    }

    private static void checkFile(String filename) throws IOException {
        // open file named filename
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(filename));
        // for each line in the file
        // read the line
        String line = reader.readLine();

            // print whether or not the line's parenthesis are balanced
        while (line != null) {
            isBalanced(line);
            line = reader.readLine();

        }
        // CLOSE the file
        reader.close();

    }

    public static void main(String[] args) throws IOException { 
        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        ps.checkFile("TestStrings0.txt");

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
