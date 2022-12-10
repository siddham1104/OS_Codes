
package OS;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
public class lru
{
     static int lr(int[]input,int n,int frame)
    {
        HashMap<Integer,Integer> indexes =new HashMap<>();
        HashSet<Integer> s=new HashSet<>(frame);
        int pagefaults =0;
        for(int i=0;i<n;i++)
        {
            if(s.size()<frame)
            {
                if(!s.contains(input[i]))
                {
                    s.add(input[i]);
                    pagefaults++;

                }
                indexes.put(input[i],i);
            }
            else
            {
                if(!s.contains(input[i]))
                {
                    int lrr=Integer.MAX_VALUE;
                    int val=Integer.MIN_VALUE;
                    Iterator<Integer> it=s.iterator();
                    while(it.hasNext())
                    {
                        int temp=it.next();
                        if(indexes.get(temp)<lrr)
                        {
                            lrr=indexes.get(temp);
                            val=temp;
                        }

                    }
                    s.remove(val);
                    indexes.remove(val);
                    s.add(input[i]);
                    pagefaults++;

                 }
                 indexes.put(input[i],i);
             }   

         }
         return pagefaults;

    
    }
    public static void main(String[] args) {
        int input[]={7,0,1,2,0,3,0,4,2,3,0,3,2,1};
        int n=input.length;
        int frame=3;
        int page=lr(input,n,frame);
        System.out.println("Number ofpage fault is: "+page);
        System.out.println("No. of hits are: "+(n-page));

    }
}
