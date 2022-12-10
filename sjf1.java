package OS;
import java.util.Scanner;
public class sjf1 {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the number of processes");
        int n=sc.nextInt();
        int pid[]=new int[n];
        int at[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int to[]=new int[n];
        int wt[]=new int[n];
        //int bt[]=new int[n];
        int f[]=new int[n];
        int st=0;
        int tot=0;
        int c=n;
        
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the arrival time for process"+(i+1));
            at[i]=sc.nextInt();
            System.out.println("Enter the burst time for process"+(i+1));
            bt[i]=sc.nextInt();

            f[i]=0;
            
        }
        int min=99999;
        while(true)
        {
            c=n;min=99999;
            if(tot==n)
            break;
            
            for(int i=0;i<n;i++)
            {
                if(at[i]<=st && f[i]==0 && bt[i]<min)
                {
                    c=i;
                    min=bt[i];
                }
                
            }
            if(c==n)
            st++;
            else
            {
                ct[c]=st+bt[c];
                st=st+bt[c];
                to[c]=ct[c]-at[c];
                wt[c]=to[c]-bt[c];
                f[c]=1;
                pid[tot]=c+1;
                tot++;
                

            }

        }

        System.out.println("pid  Arrival  Burst  Completion  Turn  waiting");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+to[i]+"\t"+wt[i]);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(pid[i] + " ");
        }
        sc.close();
    }
    
}
