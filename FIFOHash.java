package OS; 
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class FIFOHash
{
    public static int fifo(int[] input,int n,int frame)
    {
        int pagefaults=0;
        HashSet<Integer> hash=new HashSet<>(frame);
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(hash.size()<frame)
            {
                if(!hash.contains(input[i]))
                {
                    hash.add(input[i]);
                    que.add(input[i]);
                    pagefaults++;
                }

            }
            else
            {
                if(!hash.contains(input[i]))
                {
                    int value=(int)que.peek();
                    que.poll();
                    que.add(input[i]);
                    hash.remove(value);
                    hash.add(input[i]);
                    pagefaults++;
                }
            }
            System.out.print(input[i]+"\t");
            System.out.print(que+"\n");
        }
        return pagefaults;
    }
    public static void main(String[] args) 
    {
        int input[]={7, 0, 1, 2, 0 , 3, 0, 4, 2, 3, 0, 3, 2, 1};
        int frame=3;
        int n=input.length;
        int page=fifo(input,n,frame);
        System.out.println("Page faults :"+page);


        
    }
}