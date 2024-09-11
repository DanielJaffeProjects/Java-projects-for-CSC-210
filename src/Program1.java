/////////////////////
//Daniel Jaffe
// Date made 8/27/24
// This program takes a file with a bunch of number and turning them from their base to a new base and saying if there is a overflow
/////////////////////

// imports were found using W3School
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Number{
    //todo what is the point of this
    private int number;
    private int currentbase;
    private int newbase;
    private int maxnumberofbits;
}
    // constructor
    public Number(int number, int currentbase, int newBase,int maxnumberofbits){
        this.number = number;
        this.currentbase = currentbase;
        this.newBase=newBase;
        this.maxnumberofbits= maxnumberofbits;
    }

//    // Converting to base 10
//    public int base10conversions(){
//
//        // use chatgpt to convert a integer back into a string
//        String numberStr = String.valueOf(this.number);
//        //TODo make solve for each base and then return answer
//
//            for ((int i = 0); numberStr.length();i++) {
//                char chardigit = numberStr.charAt(i);
//                // look up on chatgpt to find out how to convert character to integer
//                int digit = Character.getNumericValue(chardigit);
//                // Look this up on chatgpt to find how to do exponential in java
//                int exponent = (int) Math.pow(this.currentbase,numberStr.length() - i- 1 );
//                numtobase10 += digit * exponent;
//                // todo Remember to get rid of this once done
//        //            System.out.println("numtobase10: " + numtobase10);
//        //            System.out.println("currentbase: " + currentbase);
//        //            System.out.println("chardigit: " + chardigit);
//        //            System.out.println("digit * exponent: " + digit * exponent);
//        //            System.out.println("////////////////////////////////////////");
//            }
//        return numtobase10;

//// converting to newbase
//    public  String[] newbase(Integer base10,String[] parts){
//            int quotient = base10;
//            int remainder = 0;
//            int basetocovertto = Integer.parseInt(parts[2]);
//            int counter = 0;
//            // TOdo same with i i used it in a different subroutine
//            StringBuilder text = new StringBuilder();
//            String base10str = String.valueOf(base10);
//            String[] text_counter = {"", ""};
//
//            while (quotient > 0) {
//                remainder = quotient % basetocovertto;
//                quotient = quotient / basetocovertto;
//                switch (remainder) {
//                    case 10:
//                        text.insert(0, "A");
//                        counter += 1;
//                        break;
//                    case 11:
//                        text.insert(0, "B");
//                        counter += 1;
//                        break;
//                    case 12:
//                        text.insert(0, "C");
//                        counter += 1;
//                        break;
//                    case 13:
//                        text.insert(0, "D");
//                        counter += 1;
//                        break;
//                    case 14:
//                        text.insert(0, "E");
//                        counter += 1;
//                        break;
//                    case 15:
//                        text.insert(0, "F");
//                        counter += 1;
//                        break;
//                    default:
//                        text.insert(0, Integer.toString(remainder));
//                        counter += 1;
//                }
////            todo get rid of this once done
////            System.out.println("newnumber: " + text);
////            System.out.println("base10str: " + base10str);
////            System.out.println("quotient: " + quotient);
////            System.out.println("remainder: " + remainder);
////            System.out.println(text);
////            System.out.println(counter_of_digits);
////            System.out.println("8888888888888888888888888888888");
//            }
//            // making text and counter into a array to be returned
//            text_counter[0] = text.toString();
//            text_counter[1] = Integer.toString(counter);
//            return text_counter;
//        }
//            // Subroutine to check for overflow
//    public String overflow(String[] text_and_counter,String[] parts)
//    {
//
//        String text = text_and_counter[0];
//        int maxnumberofbits = Integer.parseInt(parts[3]);
//
//        // turn counter into an integer
//        int counter = Integer.parseInt((text_and_counter[1]));
//
//        int number_of_digits = maxnumberofbits -counter;
//        String Newtext = "";
//        //if number of digits is less than 0 then overflow
//        if (number_of_digits < 0 ) {
//            Newtext = "Overflow";
//        }
//        // otherwise add 0 times teh amount of digits to the front of the text
//        else {
//            // Found the repeat function on chatgpt
//            Newtext = ("0".repeat(number_of_digits))+text;
//        }
//        // return newtext
//        return(Newtext);
//    }
//
//}


// Todo add more comments get rid of other todo's and reformat code
public class Program1 {

// Todo make a subroutine to determine if their is a overflow


    public static void main(String[] args) {
        try {
            //Todo
            // ask user for input file
            String filepath = new File("").getAbsolutePath();
            filepath = filepath.concat("\\inputMine.txt");
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
                int base10 = myNumber.base10conversion;
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
