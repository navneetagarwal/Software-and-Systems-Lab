import java.util.*;

class Book {

    public static int a = 0;

    private static final Object writeLock = new Object();

    private static final Object readWriteLock = new Object();

    private int numberReaders = 0;

    private int numberWriters = 0;

    private int numberWriteRequests = 0;

    public void write() throws InterruptedException {

        numberWriteRequests = 1;

        synchronized (readWriteLock) {
            while (numberReaders > 0) {
                readWriteLock.wait();
            }
        }

        synchronized (writeLock) {

            numberWriteRequests = 0;

            numberWriters = 1;

            System.out.println("Writer started writing.");
            Thread.sleep(10000);
            a++;
            System.out.println("Writer finished writing.");

            numberWriters = 0;

            synchronized (readWriteLock) {
                readWriteLock.notifyAll();
            }
        }
    }

    public void read(int c) throws InterruptedException {

        int k;
        k = c;

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(3001);
        
        synchronized (readWriteLock) {

            while (numberWriters > 0 || numberWriteRequests > 0) {
                readWriteLock.wait();
            }
        }

        numberReaders++;
        try {
            Thread.sleep(randomInt);
        }
        catch(InterruptedException e) {}

        System.out.println("Reader " + k + " started reading version " + a);
        Thread.sleep(5000);
        System.out.println("Reader " + k + " finished reading version " + a);

        numberReaders--;

        synchronized (readWriteLock) {
            readWriteLock.notifyAll();
        }
    }
}

class Reader implements Runnable {

    private final Book buffer;

    private int priority;

    public int k;

    public Reader(int priority, Book buffer) {
        this.priority = 0;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (Writer.checkW) {
            try {
                Thread.sleep(priority);
                buffer.read(k);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Writer implements Runnable {

    private final Book buffer;

    private int priority;

    public static boolean checkW = true;

    public Writer(int priority, Book buffer) {
        this.priority = priority;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int b = 1;b<=5;b++) {
            try {
                Thread.sleep(priority);
                buffer.write();
            } catch (InterruptedException e) {
            }
        }
        checkW = false;
    }
}

public class ReadersWriters {

    public static void main(String[] args) {

        Book sharedBuffer = new Book();

        Reader[] ob = new Reader[20];  
        for (int i=0; i<=19; i++) {
            ob[i] = new Reader(1,sharedBuffer);
            ob[i].k = i+1;
            new Thread(ob[i]).start();   
        }
        new Thread(new Writer(2000, sharedBuffer)).start();

    }
}