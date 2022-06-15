package multithreds;

import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class sysnchronizedBuffer {

    private Lock acessLock = new ReentrantLock();
    private Condition canWrite = acessLock.newCondition();
    private Condition canRead = acessLock.newCondition();
    private int buffer = -1;
    private boolean occupied = false ;
    public void set(int value) {
        acessLock.lock();
        try {
            while(occupied) {
                System.out.println ("tentando escrever!");
                System.out.println ("tentando escrever!");
                canWrite.await();
            }
            buffer = value;
            occupied = true;
            displayState("Escrevito:" + buffer);
            canRead.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            acessLock.unlock();
        }
}
    public int get () {
        int readValue = 0;
        acessLock.lock();
        try{
            while(occupied) {
                System.out.println("Tentando Leitura") ;
                DisplayStatus("Aguardando Leitura");
                canRead.await()
            }
            occupied = false;
            readValue = buffer;
            canWrite.signal();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            acessLock
        }
    }
}
