//todo make a header with name data and explanation

// imports were found using W3School

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program1 {
    // Converting to base 10
    public static Integer base10conversion(String n) {
        // split each integer into seperate parts
        String[] parts = n.split(" ");

        // initialize seperate parts
        // parseInt converts a string to a integer
        // Found parseInt on chatgpt
        //Todo determine how to omake these private and wheather you need to make a private as a good sytax in java
        int number = Integer.parseInt(parts[0]);
        int currentbase = Integer.parseInt(parts[1]);
        int basetocovertto = Integer.parseInt(parts[2]);
        int maxnumberofbits = Integer.parseInt(parts[3]);
        int i = 0;
        int numtobase10 = 0;
        // use chatgpt to convert a integer back into a string
        String numberStr = String.valueOf(number);
        //TODo make solve for each base and then return answer

        while (i < parts[0].length() -  1) {
            char chardigit = numberStr.charAt(i);
            // look up on chatgpt to find out how to convert character to integer
            int digit = Character.getNumericValue(chardigit);
            // Look this up on chatgpt to find how to do exponential in java
            int exponent = (int) Math.pow(currentbase,numberStr.length() - i- 1 );
            numtobase10 += digit * exponent;
            System.out.println(numtobase10);
            i += 1;
       }

        return (numtobase10);
    }

//    // converting to newbase
//    public static Integer newbase(Integer b){
//        int quotient = 1;
//        int remainder = 0;
//        while (quotient > 0 ) {
//
//        }
//    }

    public static void main(String[] args) {
        try {
            //Todo
            // ask user for input file
            File filename = new File("C:/Users/drjed/OneDrive/Documents/GitHub/Programs From CSC 210/Java-projects-for-CSC-210/src/input.txt");
            Scanner myReader = new Scanner(filename);
            // while filename has a next line read it
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // todo do you care if the base is 10 and I convert from base 10 to base 10 foes that matter?
                int base10 = base10conversion(line);

                System.out.println(base10);

//                int newbase = newbase(base10);

//                System.out.println(newbase);
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
