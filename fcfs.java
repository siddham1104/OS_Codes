package OS;
import java.util.Scanner;
 
public class fcfs {

	public static void main(String[] args) {
		System.out.println("Enter the number of process: - ");
		Scanner in = new Scanner(System.in);
		int no = in.nextInt();
		
		int pid[]=new int[no];
		int bt[]= new int[no];
		int ar[]= new int[no];
		int ct[]= new int[no];
		int ta[]= new int[no];
		int wt[]= new int[no];
		
		for(int i=0;i<no;i++) {
			System.out.println("Enter process" + (i+1)+" arrival time: ");
			ar[i]=in.nextInt();
			System.out.println("Enter process" + (i+1)+" burst time: ");
			bt[i]=in.nextInt();
			pid[i]=i+1;
		}
		int temp;
//		Rearranging the processes according to their arrival time
//		i.e Sorting
		for(int i=0;i<no-1;i++) {
			for(int j=i+1;j<no;j++) {
				if(ar[i]>ar[j]) {
					temp=ar[j];
					ar[j]=ar[i];
					ar[i]=temp;
					
					temp=pid[i];
					pid[i]=pid[j];
					pid[j]=temp;
					
					temp=bt[j];
					bt[j]=bt[i];
					bt[i]=temp;
					
				}
			}
		}
		System.out.println();
		for(int i=0;i<no;i++)
		{
			if(i==0)
			ct[0]=ar[0]+bt[0];
			else if(ar[i]>ct[i-1])
			ct[i]=ar[i]+bt[i];
			else
			ct[i]=ct[i-1]+bt[i];

			
			ta[i]=ct[i]-ar[i];
			wt[i]=ta[i]-bt[i];


		}
		
		
		System.out.println("Process\t\tAT\t\tBT\t\tCT\t\tTAT\t\tWT");
		for(int i=0;i<no;i++) {
			System.out.println(pid[i]+"\t\t"+ar[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]+"\t\t");
		}
		System.out.println("Gantt Chart: - ");
		for(int i=0;i<no;i++) {
			System.out.print("P"+pid[i]+" ");
		}
		
		
		in.close();
		
	}

}