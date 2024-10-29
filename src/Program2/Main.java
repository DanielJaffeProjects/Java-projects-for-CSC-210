package Program2;

/////////
// Daniel Jaffe
// Date made 10/22/24
// This program simulates how CPU and cache work together
/////////

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class CPU {
    private int hits;
    private int misses;
    private final Cache myCache;
    private int instructionCount;

    // constructor
    public CPU(int blocks) {
        this.myCache = new Cache(blocks);
        this.misses = 0;
        this.hits = 0;
        this.instructionCount = 0;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getMisses() {
        return misses;
    }

    public void setMisses(int misses) {
        this.misses = misses;
    }

    public Cache getMyCache() {
        return myCache;
    }

    public int getInstructionCount() {
        return instructionCount;
    }

    public void setInstructionCount(int instructionCount) {
        this.instructionCount = instructionCount;
    }

    public void runCPU(String Line, int words) {
        this.instructionCount++;

        // if Del is found delete that block
        if (Line.startsWith("DEL")) {
            // Parse the block number to delete
            String[] deleteBlockNum = Line.split(" ");
            int blockNum = Integer.parseInt(deleteBlockNum[1], 16);
            if (blockNum < myCache.getSize()) {
                myCache.getMemory()[blockNum] = 0;
            }
            // Clear the entire cache memory
        } else if (Line.equalsIgnoreCase("CLEAR")) {
            for (int i = 0; i < myCache.getSize(); i++) {
                myCache.getMemory()[i] = 0;
            }
        } else {
            // Convert HEX to decimal and calculates block index
            long decimal = Long.parseLong(Line, 16);
            long blocknum =  decimal / words;
            long blockindex = ( blocknum % myCache.getMemory().length);
            // if cache contains block add 1 to hits
            int i = 0;
            boolean j = true;
            while (j)
                if (myCache.getMemory()[i] == blocknum) {
                    hits++;
                    j = false;
                }
                // if I am greater than or equal to myCache size
                else if (i + 1 >= myCache.getSize()) {
                    myCache.getMemory()[(int) blockindex] = blocknum;
                    misses++;
                    j = false;
                } else {
                    i++;
                }

            // every 100 instructions output the result
            if (instructionCount % 100 == 0) {
                printCacheAndHitRatio();
            }
        }
    }

    // outputs the result
    private void printCacheAndHitRatio() {
        // calculates hit ratio
        double total = hits + misses;
        double hitRatio = (double) hits / total;

        System.out.println("Instruction# - " + instructionCount);
        // look up how to make hit ratio to 3 decimal places on geeks for geeks
        System.out.printf("H- %.3f%n", hitRatio);
        for (long block : myCache.getMemory()) {
            if (block == 0) {
                System.out.print(" --- ");
            } else {
                System.out.print( block + " ");
            }
        }
        System.out.println();
    }
}

// reads file
public class Main {
    public static void main(String[] args) {
        try {
            // I learned a better way to make it easy for the user to a read a file on tutorial points
            String filepath = System.getProperty("user.dir") + ("\\Samples\\sample0.txt");
            File filename = new File(filepath);
            Scanner myReader = new Scanner(filename);
            String firstLine = myReader.nextLine();

            // used chatgpt to learn how to split by a space in java
            String[] wordandblocks = (firstLine.split(" "));
            int words = Integer.parseInt(wordandblocks[0], 16);
            int blocks = Integer.parseInt(wordandblocks[1], 16);

            // creating a cpu instance
            CPU myCPU = new CPU(blocks);

            while (myReader.hasNextLine()) {
                String Line = myReader.nextLine();
                myCPU.runCPU(Line, words);

            }
            // if file not their output file not found
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}



