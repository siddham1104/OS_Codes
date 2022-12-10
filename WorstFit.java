package OS;

public class WorstFit {
    public static void Worst(int[] blocksize, int m, int[] processsize, int n)
    {
        int allocation[]=new int[n];
        for(int i=0;i<n;i++)
        {
            allocation[i]=-1;
        }
        int wrstindex;
        for(int i=0;i<n;i++)
        {
            wrstindex=-1;
            for(int j=0;j<m;j++)
            {
                if(blocksize[j]>=processsize[i])
                {
                    if(wrstindex==-1)
                    wrstindex=j;
                    else if(blocksize[wrstindex]<blocksize[j])
                    wrstindex=j;
                }
            } 
            if(wrstindex!=-1)
            {
                allocation[i]=wrstindex;
                blocksize[wrstindex]-=processsize[i];
            }
        }

        System.out.println("ProcessNo \t ProcessSize \t BlockNo");
        for(int i=0;i<n;i++)
        {
            System.out.print(" " +(i+1) + "\t\t"+ processsize[i]+"\t\t" );
            if(allocation[i]!=-1)
            System.out.print((allocation[i]+1)+"\t\t");
            else
            System.out.print("Not Allocated");
            System.out.println();
        }


    }
    public static void main(String[] args)
{
    int blocksize[]={100,500,200,300,600};
    int m=blocksize.length;
    int processsize[]={212,417,112,426};
    int n=processsize.length;
    Worst(blocksize,m,processsize,n);

}

    
}
