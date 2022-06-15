package multithreds; 

import java.security.SecureRandom;

public class writeBuffer implements Runnable {
    private static final SecureRandom
    generator = new SecureRandom();
    private final buffer sharedlocation;
    public writeBuffer(buffer sharedlocation) {
        this.sharedlocation = sharedlocation;
    }
    public void run() {
        int sum = 0;
        for (int count = 1; count <=10; count ++) {
            try{
                Thread.sleep(generator.nextInt(3000));
                sharedlocation.putBuffer(count);
                sum+= count;
                System.out.printf("\t%2d\n", sum);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Escrita do buffer realizada!\n");
    }
}
