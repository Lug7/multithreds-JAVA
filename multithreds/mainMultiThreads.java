package multithreds; 

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class mainMultiThreads {
    
    public static void main(String[]args)
        throws InterruptedException{
            //todo Auto-generated method stub
            ExecutorService threadRun = 
                    Executors.newCachedThreadPool(); 
            buffer sharedlocation = new unsysnchronizedBuffer();

            System.out.printf("Thread running\t\tValue\t"
                     +"Sum write\tSum read\n");
            System.out.println("-----------------------------------------");
            threadRun.execute(new writeBuffer(sharedlocation));
            threadRun.execute(new readBuffer(sharedlocation));
            threadRun.shutdown();
            threadRun.awaitTermination(1, TimeUnit.MINUTES);

        }
}
