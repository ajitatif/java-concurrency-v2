package istanbul.javausergroup.talk.concurrency.sync;

import istanbul.javausergroup.talk.concurrency.Constants;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class ThreadSynchronization {

    private static AtomicInteger messageCount = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(ThreadSynchronization::dispatchMessages);
        thread.start();

        thread.join();
        System.out.println("Messages ended, total messages: " + messageCount.get());
    }

    private static void dispatchMessages() {
        for (String line : Constants.lines) {
            System.out.println(line);
            messageCount.incrementAndGet();
        }
    }
}
