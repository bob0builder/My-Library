import java.util.Scanner;

class Process{
    int pid;
    int arrivalTime;
    int burstTime;
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    
    public Process(int pid, int arrivalTime, int burstTime){
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}




public class First_come_first_serve{
    
    private static void sortByArrivalTime(Process[] processes){
    for(int i =0; i<processes.length - 1; i++){
        for(int j = 0; j<processes.length - i - 1;j++){
            if(processes[j].arrivalTime > processes[j + 1].arrivalTime){
                Process temp = processes[j];
                processes[j] = processes[j+1];
                processes[j+1] = temp;
            }
        }
    }
}

private static void calculateTime(Process[] processes){
    int currentTime = 0;
    
    for(Process process: processes){
        if(currentTime < process.arrivalTime){
            currentTime = process.arrivalTime;
        }
        
        process.completionTime = currentTime + process.burstTime;
        
        process.turnAroundTime = process.completionTime - process.arrivalTime;
        
        process.waitingTime = process.turnAroundTime - process.burstTime;
        
        currentTime = process.completionTime;
    }
}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter number of processes");
        int n = sc.nextInt();
        
        Process[] processes = new Process[n];
        
        for(int i = 0 ; i < n ;i ++){
            System.out.print("Enter arrivalTime and burstTime: " + (i+1) + " : ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            processes[i] = new Process(i + 1, arrivalTime, burstTime);
        }
        
        sortByArrivalTime(processes);
        
        calculateTime(processes);
        
        System.out.println("\n Process \t ArrivalTime \tBurst \tCompletion \tTurnAround \tWaiting: ");
            for(Process process: processes){
                System.out.printf("%d\t %d\t %d\t %d\t %d\t %d\t", process.pid, process.arrivalTime, process.burstTime, process.completionTime, process.turnAroundTime, process.waitingTime);
            }
        
        sc.close();
        
    }
}