//todo make a header with name data and explanation

// imports were found using W3School

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program1 {
    // Converting to base 10
    public static Integer base10conversion(String[] parts) {
        // initialize seperate parts
        // parseInt converts a string to a integer
        // Found parseInt on chatgpt
        //Todo determine how to omake these private and wheather you need to make a private as a good sytax in java
        int number = Integer.parseInt(parts[0]);
        int currentbase = Integer.parseInt(parts[1]);
        int maxnumberofbits = Integer.parseInt(parts[3]);
        int i = 0;
        int numtobase10 = 0;
        // use chatgpt to convert a integer back into a string
        String numberStr = String.valueOf(number);
        //TODo make solve for each base and then return answer

        while (i < parts[0].length()) {
            char chardigit = numberStr.charAt(i);
            // look up on chatgpt to find out how to convert character to integer
            int digit = Character.getNumericValue(chardigit);
            // Look this up on chatgpt to find how to do exponential in java
            int exponent = (int) Math.pow(currentbase,numberStr.length() - i- 1 );
            numtobase10 += digit * exponent;
//            System.out.println("numtobase10: " + numtobase10);
//            System.out.println("currentbase: " + currentbase);
//            System.out.println("chardigit: " + chardigit);
//            System.out.println("digit * exponent: " + digit * exponent);
//            System.out.println("////////////////////////////////////////");
            i += 1;
       }

        return (numtobase10);
    }

    // converting to newbase
    //TOdo is it a bad thing to consistly use base10? here and in the main and in the other subroutine
    //Todo Why am I getting such a weird number for the second one?
    public static Integer newbase(Integer base10,String[] parts){
        int quotient = base10;
        int remainder = 0;
        int newnumber = 0;
        int basetocovertto = Integer.parseInt(parts[2]);
        // TOdo same with i i used it in a different subroutine
        int i = 0;
        String base10str = String.valueOf(base10);

        while (quotient > 0 ) {
            remainder = quotient % basetocovertto;
            quotient = quotient/basetocovertto;
            //Todo add if statement here for 10 through 15 values hexadecimal
            newnumber += remainder * (int) Math.pow(10, i);
            System.out.println("newnumber: " + newnumber);
            System.out.println("base10str: " + base10str);
            System.out.println("quotient: " + quotient);
            System.out.println("remainder: " + remainder);
            System.out.println("8888888888888888888888888888888");
            i += 1;
        }
        return newnumber;
    }

    public static void main(String[] args) {
        try {
            //Todo
            // ask user for input file
            File filename = new File("C:/Users/drjed/OneDrive/Documents/GitHub/Programs From CSC 210/Java-projects-for-CSC-210/src/inputMine.txt");
            Scanner myReader = new Scanner(filename);
            // while filename has a next line read it
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // split each integer into seperate parts
                String[] parts = line.split(" ");
                // todo do you care if the base is 10 and I convert from base 10 to base 10 foes that matter?
                int base10 = base10conversion(parts);

                System.out.println(base10);

                int newbase = newbase(base10,parts);

                System.out.println(newbase);
            }
            // close the file
            myReader.close();
        }
        // if file not their output file not found
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
