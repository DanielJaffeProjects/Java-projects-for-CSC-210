// imports were found using w3school
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program1
{
    public static Integer binarybase(String n)
    {
        // split each integer into seperate parts
        String[] parts = n.split(" ");

        // initialize seperate parts
        // parseInt converts a string to a integer
        // Found parseInt on chatgpt
        int number = Integer.parseInt(parts[0]);
        int currentbase = Integer.parseInt(parts[1]);
        int basetocovertto = Integer.parseInt(parts[2]);
        int maxnumberofbits = Integer.parseInt(parts[3]);

        //TODo make solve for each base and then return answer
        return (1);
    }
    public static void main(String[] args)
    {
        try
        {
            //Todo
            // ask user for input file
            File filename = new File("C:/Users/drjed/OneDrive/Documents/GitHub/Programs From CSC 210/Java-projects-for-CSC-210/src/input.txt");
            Scanner myReader = new Scanner(filename);
            // while filename has a next line read it
            while (myReader.hasNextLine())
            {
                String line = myReader.nextLine();
                int answer= binarybase(line);
                // output the answer for each line
                System.out.println(answer);
            }
            // close the file
            myReader.close();
        }
        // if file not their output file not found
        catch (FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
