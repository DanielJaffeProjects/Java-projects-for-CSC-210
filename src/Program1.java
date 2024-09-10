/////////////////////
//Daniel Jaffe
// Date made 8/27/24
// This program takes a file with a bunch of number and turning them from their base to a new base and saying if there is a overflow
/////////////////////

// imports were found using W3School
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Todo add more comments get rid of other todo's and reformat code
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
            // todo Remember to get rid of this once done
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
    public static String[] newbase(Integer base10,String[] parts){
        int quotient = base10;
        int remainder = 0;
        int basetocovertto = Integer.parseInt(parts[2]);
        int counter = 0;
        // TOdo same with i i used it in a different subroutine
        String text = "";
        String base10str = String.valueOf(base10);
        String[] text_counter = {"",""};

        while (quotient > 0 ) {
            remainder = quotient % basetocovertto;
            quotient = quotient/basetocovertto;
            switch (remainder){
                case 10:
                    text = "A" + text;
                    counter += 2;
                    break;
                case 11:
                    text = "B" + text;
                    counter += 2;
                    break;
                case 12:
                    text = "C" + text;
                    counter += 2;
                    break;
                case 13:
                    text = "D" + text;
                    counter += 2;
                    break;
                case 14:
                    text = "E" + text;
                    counter += 2;
                    break;
                case 15:
                    text = "F" + text;
                    counter += 2;
                    break;
                default:
                    text = Integer.toString(remainder) + text;
                    counter += 1;
            }
//            todo get rid of this once done
//            System.out.println("newnumber: " + text);
//            System.out.println("base10str: " + base10str);
//            System.out.println("quotient: " + quotient);
//            System.out.println("remainder: " + remainder);
//            System.out.println(text);
//            System.out.println(counter_of_digits);
//            System.out.println("8888888888888888888888888888888");
        }
        // making text and counter into a array to be returned
        text_counter[0] = text;
        text_counter[1] = Integer.toString(counter);
        return text_counter;
    }

// Todo make a subroutine to determine if their is a overflow
    public static String overflow(String[] text_and_counter)
    {

        String text = text_and_counter[0];

        // turn counter into an integer
        int counter = Integer.parseInt((text_and_counter[1]));

        int number_of_digits = 10-counter;
        String Newtext = "";
        if (number_of_digits < 0 ) {
            Newtext = "Overflow";
        }
        else {
            // Found the repeat function on chatgpt
            Newtext = ("0".repeat(number_of_digits))+text;
        }
        return(Newtext);
    }
    //todo if number of digits is less than 0 return text = over flow
    // todo otherwise take text and add 0 * number of digits
    // todo return text
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

                String[] newbase = newbase(base10,parts);

                System.out.println(newbase[0]);
                System.out.println(newbase[1]);

                String overflow = overflow(newbase);

                System.out.println(overflow);
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
