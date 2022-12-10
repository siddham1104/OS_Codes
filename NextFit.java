package OS;
import java.util.*;

public class NextFit {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter number of blocks: ");
		int bno=in.nextInt();
		int blockSize[]=new int[bno];
		for (int i=0; i<bno; i++) {
			System.out.print("Enter size of block "+(i+1)+": ");
			blockSize[i]=in.nextInt();
		}
		System.out.println("Enter number of processes: ");
		int pno=in.nextInt();
		int processSize[]=new int[pno];
		int allocation[]=new int[pno];
		for (int i=0; i<pno; i++) {
			System.out.print("Enter size of process "+(i+1)+": ");
			processSize[i]=in.nextInt();
			allocation[i]=-1;
		}

		int k=0;
		for (int i=0; i<pno; i++) {
			int j=k;
			do {
				if (blockSize[j]>=processSize[i]) {
					allocation[i]=j;
					blockSize[j]-=processSize[i];
					k=j;
					break;
				}
				j++;
				if (j==bno) j=0;
			} while (j!=k);
		}

		System.out.println("Process No.\tProcess Size\tBlock No");
		for (int i=0; i<pno; i++) {
			System.out.print(" "+(i+1)+"\t\t"+processSize[i]+"\t\t");
			if (allocation[i]!=-1) {
				System.out.print((allocation[i]+1));
			}
			else {
				System.out.print("Not allocated");
			}
			System.out.println("");
		}
		in.close();
	}
}