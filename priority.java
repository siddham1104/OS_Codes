package OS;
import java.util.Scanner;
class priority 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes ");
        int n=sc.nextInt();
        int bt[]=new int[n];
        int p[]=new int[n];
        int pid[]=new int[n];
        int wait=0;
        int total=0;
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the burst time for process  "+(i+1));
            bt[i]=sc.nextInt();
            System.out.println("Enter the priority for process  "+(i+1));
            p[i]=sc.nextInt();
            pid[i]=i+1;

        }
        int temp;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(p[i]>p[j])
                {
                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;

                    temp=bt[i];
                    bt[i]=bt[j];
                    bt[j]=temp;

                    temp=pid[i];
                    pid[i]=pid[j];
                    pid[j]=temp;
                }
            }
        }
        System.out.println("Process  BurstTime  WaitTime");
        for(int i=0;i<n;i++)
        {
            System.out.println("P"+pid[i]+"\t\t"+bt[i]+"\t\t"+wait);
            wait=wait+bt[i];
            total=total+wait;
        }
        sc.close();

    }
}