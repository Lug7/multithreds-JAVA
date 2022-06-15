package multithreds; 

public class unsysnchronizedBuffer  implements buffer {
    private int buffer = -1;

    public void putBuffer(int value)
            throws InterruptedException{
        System.out.printf("Escrevendo valor:" , value);
        buffer = value;
    }
    public int getBuffer() throws InterruptedException{
        System.out.printf("Leitura do valor:", buffer);
        return buffer;
    }
    
}
    