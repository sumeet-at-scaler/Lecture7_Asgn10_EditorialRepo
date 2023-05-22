import java.util.concurrent.atomic.AtomicInteger;

public class PracticeWithAtomicDataTypes {
    private AtomicInteger count;

    public PracticeWithAtomicDataTypes(){
        count = new AtomicInteger();
    }

    public int incAndGet(){
        return count.incrementAndGet();
    }

    public int getAndInc(){
        return count.getAndIncrement();
    }

    public int get(){
        return count.get();
    }
}