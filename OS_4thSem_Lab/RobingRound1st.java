package OS_4thSem_Lab;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {
    int id, burstTime, remainingTime, completionTime, waitingTime, turnAroundTime;

    public Process(int id, int burstTime) { // Constructor
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
    }
}

public class RobingRound1st {
    public static void main(String[] args) { // Fixed method name
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of Processes: ");
        int n = sc.nextInt();

        System.out.println("Enter time Quantum: "); // Time allocated for each process
        int timeQuantum = sc.nextInt();

        Queue<Process> queue = new LinkedList<>();
        Process[] processes = new Process[n]; // Array defined for process

        // Taking input burst time
        for (int i = 0; i < n; i++) {
            System.out.println("Enter burst time for process " + (i + 1) + ": ");
            int burstTime = sc.nextInt();
            processes[i] = new Process(i + 1, burstTime);
            queue.add(processes[i]);
        }

        int currentTime = 0;

        // Round Robin Process Execution
        while (!queue.isEmpty()) {
            Process currentProcess = queue.poll();

            if (currentProcess.remainingTime > timeQuantum) {
                currentTime += timeQuantum;
                currentProcess.remainingTime -= timeQuantum;
                queue.add(currentProcess);
            } else {
                currentTime += currentProcess.remainingTime;
                currentProcess.remainingTime = 0;
                currentProcess.completionTime = currentTime;
                currentProcess.turnAroundTime = currentProcess.completionTime;
                currentProcess.waitingTime = currentProcess.turnAroundTime - currentProcess.burstTime;
            }
        }

        // Displaying Output
        System.out.println("\nProcess \t Burst Time \t Completion Time \t Waiting Time \t TurnAround Time");
        for (Process p : processes) {
            System.out.println("P" + p.id + "\t\t" + p.burstTime + "\t\t" + p.completionTime + "\t\t\t" + p.waitingTime + "\t\t" + p.turnAroundTime);
        }

        sc.close();
    }
}
