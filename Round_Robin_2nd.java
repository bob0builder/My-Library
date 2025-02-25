import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 class Processes {
     int id, burstTime, remainingTime, completionTime, waitingTime, turnAroundTime;
     String name ;

     public Processes(String name, int burstTime) {

         this.name = name;
         this.burstTime = burstTime;
         this.remainingTime = burstTime;

     }

 }

 public class Round_Robin_2nd{
     public static void main(String[] args){
         Queue<Processes> queue = new LinkedList<>();

         int  timeQuantum = 3;
          queue.add(new Processes("P1",3));
          queue.add(new Processes("P2", 4));
         queue.add(new Processes("P3", 5));
         System.out.println("Process execution in Robin Robin");
         while(!queue.isEmpty()){
            Processes currentProcess = queue.poll();

             int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);
             System.out.println("Executing :"+ currentProcess.name+"for"+executionTime+"units/secs");

             currentProcess.remainingTime -=executionTime;

             if(currentProcess.remainingTime>0) {
                 queue.add(currentProcess);
             }else{
                 System.out.println(currentProcess.name+"has completed execution");

             }
         }
         System.out.println("all process are completed ");



     }
 }