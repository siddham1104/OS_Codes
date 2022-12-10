package OS;

public class FirstFit1 {
    public static void first(int[] blocksize,int m,int[] processize,int n)
    {
        int associated[]=new int[n];
        for(int i=0;i<n;i++)
        {
            associated[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(blocksize[j]>=processize[i])
                {
                    associated[i]=j;
                    blocksize[j]-=processize[i];
                    break;
                }
            }
        }
        System.out.println("Process \t ProcessSize \t BlockNo");
        for(int i=0;i<n;i++)
        {
            System.out.print((i+1)+"\t\t"+processize[i]+"\t\t");
            if(associated[i]!=-1)
            System.out.print((associated[i]+1));
            else
            System.out.print("Not Allocated");
            System.out.println();
        } 
    }
    public static void main(String[] args) {
        int blocksize[]={100,500,200,300,600};
        int m=blocksize.length;
        int processize[]={212,417,112,426};
        int n=processize.length;
        first(blocksize, m, processize, n);
        
    }
    
}
