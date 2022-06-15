package multithreds; 

public interface buffer{
    public void putbutter(int value)
            throws InterruptedException;
    public int getBuffer() throws InterruptedException;
    public void putBuffer(int count);
}