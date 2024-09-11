/////////////////////
//Daniel Jaffe
// Date made 8/27/24
// This program takes a file with a bunch of number and turning them from their base to a new base and saying if there is an overflow
/////////////////////

// imports were found using W3School
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Number{
    //todo what is the point of this
    private final int number;
    private final int currentbase;
    private final int newbase;
    private final int maxnumberofbits;

    // constructor
    public Number(int number, int currentbase, int newbase,int maxnumberofbits){
        this.number = number;
        this.currentbase = currentbase;
        this.newbase=newbase;
        this.maxnumberofbits= maxnumberofbits;
    }

    // Converting to base 10
    public int base10conversion() {

        // use chatgpt to convert an integer back into a string
        String numberStr = String.valueOf(this.number);

        int numtobase10 = 0;

        for ( int i = 0; i < numberStr.length();i++){

            char chardigit = numberStr.charAt(i);

            // look up on chatgpt to find out how to convert character to integer
            int digit = Character.getNumericValue(chardigit);

            // Look this up on chatgpt to find how to do exponential in java
            int exponent = (int) Math.pow(this.currentbase, numberStr.length() - i - 1);
            numtobase10 += digit * exponent;
        }
        return numtobase10;
    }

// converting to newbase
    public  String[] newbase(int base10){
            int quotient = base10;
            int remainder;
            int counter = 0;

            StringBuilder text = new StringBuilder();
            String[] text_counter = {"", ""};

            // changes numbers above 10 to hexadecimal
            while (quotient > 0) {
                remainder = quotient % this.newbase;
                quotient = quotient / this.newbase;
                switch (remainder) {
                    case 10:
                        text.insert(0, "A");
                        counter += 1;
                        break;
                    case 11:
                        text.insert(0, "B");
                        counter += 1;
                        break;
                    case 12:
                        text.insert(0, "C");
                        counter += 1;
                        break;
                    case 13:
                        text.insert(0, "D");
                        counter += 1;
                        break;
                    case 14:
                        text.insert(0, "E");
                        counter += 1;
                        break;
                    case 15:
                        text.insert(0, "F");
                        counter += 1;
                        break;
                    default:
                        text.insert(0, (remainder));
                        counter += 1;
                }
            }
            // making text and counter into an array to be returned
            text_counter[0] = text.toString();
            text_counter[1] = Integer.toString(counter);
            return text_counter;
        }

    // Subroutine to check for overflow
    public String overflow(String[] text_and_counter)
    {

        String text = text_and_counter[0];

        // turn counter into an integer
        int counter = Integer.parseInt((text_and_counter[1]));

        int number_of_digits = maxnumberofbits -counter;
        String Newtext = "";
        //if number of digits is less than 0 then overflow
        if (number_of_digits < 0 ) {
            Newtext = "Overflow";
        }
        // otherwise add 0 times teh amount of digits to the front of the text
        else {
            // Found the repeat function on chatgpt
            Newtext = ("0".repeat(number_of_digits))+text;
        }
        // return newtext
        return(Newtext);
    }

}


// Todo add more comments get rid of other todo's and reformat code
public class Program1 {


    public static void main(String[] args) {
        try {
            String filepath = new File("").getAbsolutePath();
            filepath = filepath.concat("\\input.txt");
            File filename = new File(filepath);
            Scanner myReader = new Scanner(filename);

            // while filename has a next line read it
            while (myReader.hasNextLine()) {

                String line = myReader.nextLine();

                // split each integer into seperate parts
                String[] parts = line.split(" ");
                int number = Integer.parseInt(parts[0]);
                int currentbase = Integer.parseInt(parts[1]);
                int newbase = Integer.parseInt(parts[2]);
                int maxnumberofbits = Integer.parseInt(parts[3]);

                // creating an object for the number class
                Number myNumber = new Number(number,currentbase,newbase,maxnumberofbits);

                // learn how to use objects with chatgpt
                int base10 = myNumber.base10conversion();

                String[] newbase2 = myNumber.newbase(base10);

                String overflow = myNumber.overflow(newbase2);
                // outputs the final base value
                System.out.println(overflow);

            }
            // close the file
            myReader.close();
        }
        // if file not their output file not found
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

