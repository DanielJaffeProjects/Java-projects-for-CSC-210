package Program2;

////////
//Daniel Jaffe
// Date made 10/22/24
// This class is used for demonstrating how cache holds the memory
////////

public class Cache {
    private long[] memory;
    // constructor
    public Cache(int blocks) {
        this.memory = new long[blocks];
    }
    //getter for memory
    public long[] getMemory() {
        return memory;
    }
    // setter for memory
    public void setMemory(long[] memory) {
        this.memory = memory;
    }
    // gets the size
    public int getSize(){
        return this.memory.length;
    }
}
