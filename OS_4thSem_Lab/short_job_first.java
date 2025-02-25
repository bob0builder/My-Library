package OS_4thSem_Lab;
import java.util.*;

public class short_job_first{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        int[][] array = new int[50][4];
        int total = 0;
        float averageWT, averageTAT;
        System.out.println("Enter number of processes");
        n = sc.nextInt();


        System.out.println("Enter burst Time");
        for(int i = 0; i<n; i++){
            System.out.println("P" + i+1 + ":");
            array[i][1] = sc.nextInt();
            array[i][0] = i+1;
        }

        for(int i= 0; i<n; i++){
            int index =i;
            for(int j = i+1; j<n; j++){
                if(array[j][1] < array[index][1]){
                    index =j;
                }

            }

            int temp =array[i] [i];
            array[i][1] =array[index][1];
            array[index][1] = temp;
            temp = array[i][0];
            array[i][0] = array[index][0];
            array[index][0] = temp;
        
        }

        array[0][2] = 0;
         for(int i =1; i<n; i++){
            array[i][2] = 0;
            for(int j = 0; j<i; j++){
                array[i][2] += array[j][1];
            }
            total += array[i][2];
         }
         averageWT = (float)total/n;
         total =0;

         System.out.println("P \t BT \t WT \t TAT");
         for(int i=0; i<n; i++){
            array[i][3] = array[i][1] + array[i][2];
            total += array[i][3];
            System.out.println("P" + array[i][0] + "\t" + array[i][1] + "\t" + array[i][2] + "\t" + array[i][3]);
         }

         averageTAT = (float)total/n;
         System.out.println("Average waiting time: " + averageWT);
         System.out.println("Average TurnAround time: " + averageTAT);
         
         sc.close();
    }
}