package OS;
import java.util.concurrent.Semaphore;

public class Mutex 
{
    static Semaphore semaphore=new Semaphore(1);
    static class banker extends Thread
    {
        String name="";
        banker(String name)
        {
            this.name=name;
        }
        public void run()
        {
            try
            {
                semaphore.acquire();
                System.out.println(name+": entered into locker room");
                System.out.println(name+": has accessed the locker");
                Thread.sleep(1000);
                System.out.println(name+": has left he locker room");
                semaphore.release();

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        banker t1=new banker("A");
        t1.start();
        banker t2=new banker("B");
        t2.start();
        banker t3=new banker("C");
        t3.start();
    }

}
