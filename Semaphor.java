package OS;
import java.util.concurrent.Semaphore;


public class Semaphor 
{
    static Semaphore semaphore=new Semaphore(4);
    static class ATMthread extends Thread
    {
        String  name="";
        ATMthread(String name)
        {
            this.name=name;

        }
        public void run()
        {
            try
            {
                semaphore.acquire();
                System.out.println(name+":Entered into atm");
                System.out.println(name+":Has done the withdrawal");
                Thread.sleep(1000);
                System.out.println(name+":Has left the ATM");
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
        ATMthread t1=new ATMthread("A");
        t1.start();
        ATMthread t2=new ATMthread("B");
        t2.start();
        ATMthread t3=new ATMthread("C");
        t3.start();
        ATMthread t4=new ATMthread("D");
        t4.start();
        ATMthread t5=new ATMthread("E");
        t5.start();
        ATMthread t6=new ATMthread("F");
        t6.start();
    }
}
