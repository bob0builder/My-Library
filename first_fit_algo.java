import java.util.List;
import java.util.ArrayList;


public class first_fit_algo {
    public static void main(String[] args){
        //initializing the memory
        List<MemoryBlock> memory = new ArrayList<>();
        memory.add(new MemoryBlock(10, false)); //false means 10kb block is already utlized
        memory.add(new MemoryBlock(20, true)); //20kb block of memory is free
        memory.add(new MemoryBlock(15, true)); // 15kb block of memory if free
        memory.add(new MemoryBlock(30, true)); // 30kb block of memory if free


        //initializing the process
        List<Process> processes = new ArrayList<>();
        processes.add(new Process("Process A", 8));
        processes.add(new Process("Process B", 10));
        processes.add(new Process("Process C", 25));

        //Allocating memory using *first fit*
         for (Process process : processes){
            boolean allocated = false;
            for(int i = 0; i< memory.size(); i++){
                MemoryBlock block = memory.get(i);
                if(block.isFree && block.size >= process.size){

                    //allocate memory
                    System.out.println(process.name + "(" + process.size + "KB ) allocated to block of size" + block.size + "KB, ");
                    block.isFree = false; //MArk Block as used

                    //spliting the block in case of memory is remaining
                    int remaining = block.size - process.size;
                    if(remaining > 0){
                        memory.add(i + 1, new MemoryBlock(remaining, true)); // added remaining memory as new block

                    }
                    allocated = true;
                    break;
                }
            }

            if(!allocated){
                System.out.println(process.name + "( "+ process.size + "KB) could not be allocated");

            }
         }

         //displaying the final memory

         System.out.println("\n Final memory state: ");
         for(int i=0 ; i< memory.size(); i++){
            MemoryBlock block = memory.get(i);
            System.out.println("Block" + i + ":" + block.size + " KB " + (block.isFree ? "Free" : "Used"));
         }
    }
    
}



class MemoryBlock{
    int size;
    boolean isFree;

    public MemoryBlock(int size, boolean isFree){
        this.size = size;
        this.isFree = isFree;

    }
}

class Process {
    String name;
    int size;

    public Process(String name, int size){
        //constructor for process
        this.name = name;
        this.size = size;
    }
}