import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // Number of processes
        int[][] array; // Array to store process details
        int total = 0; // Total waiting time or turnaround time
        float averageWT, averageTAT; // Averages

        System.out.println("Enter the number of processes:");
        n = sc.nextInt(); // Read the number of processes
        array = new int[n][4]; // Dynamically allocate array based on the number of processes

        // Input burst times
        System.out.println("Enter Burst Times:");
        for (int i = 0; i < n; i++) {
            System.out.print("P" + (i + 1) + ": ");
            array[i][1] = sc.nextInt(); // Burst time
            array[i][0] = i + 1; // Process ID
        }

        // Sort processes by burst time (Selection Sort)
        for (int i = 0; i < n; i++) {
            int index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j][1] < array[index][1]) {
                    index = j; // Find the process with the smallest burst time
                }
            }

            // Swap burst times
            int temp = array[i][1];
            array[i][1] = array[index][1];
            array[index][1] = temp;

            // Swap process IDs
            temp = array[i][0];
            array[i][0] = array[index][0];
            array[index][0] = temp;
        }

        // Calculate waiting times
        array[0][2] = 0; // First process has no waiting time
        for (int i = 1; i < n; i++) {
            array[i][2] = 0; // Initialize waiting time
            for (int j = 0; j < i; j++) {
                array[i][2] += array[j][1]; // Accumulate waiting times
            }
            total += array[i][2]; // Add to total waiting time
        }
        averageWT = (float) total / n; // Average waiting time

        total = 0; // Reset total for Turnaround Time

        // Print results and calculate turnaround times
        System.out.println("P \t BT \t WT \t TAT");
        for (int i = 0; i < n; i++) {
            array[i][3] = array[i][1] + array[i][2]; // Turnaround Time = Burst Time + Waiting Time
            total += array[i][3]; // Add to total turnaround time
            System.out.println("P" + array[i][0] + "\t" + array[i][1] + "\t" + array[i][2] + "\t" + array[i][3]);
        }
        averageTAT = (float) total / n; // Average turnaround time

        // Print averages
        System.out.println("Average Waiting Time: " + averageWT);
        System.out.println("Average Turnaround Time: " + averageTAT);
    }
}
 {
    
}
