package OS; 
import java.util.LinkedList;
public class opt
{
    static LinkedList<Integer> frame=new LinkedList<>();
    static int refarr[]={7, 0 , 1 , 2 , 0 , 3 , 0 , 4 , 2 , 3 , 0 , 3 , 2 , 1 , 2 , 0 , 1 , 7 , 0 , 1};
    static int pagefault=0;
    static int pagehit=0;
    static int maxframe=4;


    public static void Optimal(int ref,int index)
    {
        int maxdist=Integer.MIN_VALUE;
        int farelement=index;
        for(int i=0;i<frame.size();i++)
        {
            int currentdistance=0;
            int currentelement=refarr[i];
            int pointer=index;

            while(pointer<refarr.length)
            {
                if(refarr[pointer]==currentelement)
                break;
                currentdistance++;
                pointer++;

            }
            if(currentdistance>maxdist)
            {
                maxdist=currentdistance;
                farelement=i;

            }
        }
        frame.set(farelement,ref);

    }

    public static void getframe(int ref,int index)
    {
        if(frame.contains(ref))
        {
            pagehit++;
            return;
        }
        
        else{
            if(frame.size()<4)
            {
                frame.add(ref);
                pagefault++;
                return;
            }
            else
            {
                Optimal(ref, index);
                pagefault++;
                return;
            }
        }
       
    }
    public static void main(String[] args) {
        for(int i=0;i<refarr.length;i++)
        {
            getframe(refarr[i], i);


        }
        System.out.println("PageFault:"+pagefault);
        System.out.println("PageHit:"+pagehit);

    }
}
