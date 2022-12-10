package OS;

public class BestFit1 {
    public static void best(int[] blockSize,int m,int[] processSize,int n)
    {
        int allocation[]=new int[n];
        for(int i=0;i<n;i++)
        {
            allocation[i]=-1;

        }
         //bestindex;
        for(int i=0;i<n;i++)
        {
            int bestindex=-1;
            for(int j=0;j<m;j++)
            {
                if(blockSize[j]>=processSize[i])
                {
                    if(bestindex==-1)
                    bestindex=j;
                    else if(blockSize[bestindex]>blockSize[j])
                    bestindex=j;
                }

            }
            if(bestindex!=-1)
            {
                allocation[i]=bestindex;
                blockSize[bestindex]-=processSize[i];
            }
        }
        System.out.println("ProcessNo \t ProcessSize \t BlockNo");
        for(int i=0;i<n;i++)
        {
            System.out.print((i+1)+"\t\t"+processSize[i]+"\t\t");
            if(allocation[i]!=-1)
            System.out.print((allocation[i]+1));
            else
            System.out.print("Npt Alloctaed");
            System.out.println();

        }

    }
    public static void main(String[] args)
    {
        int blockSize[]={100,500,200,300,600};
        int m=blockSize.length;
        int processSize[]={212,417,112,426};
        int n=processSize.length;
        best(blockSize, m, processSize, n);
    }    
}
