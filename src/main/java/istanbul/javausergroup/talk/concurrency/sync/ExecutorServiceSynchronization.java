package istanbul.javausergroup.talk.concurrency.sync;

import istanbul.javausergroup.talk.concurrency.Constants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class ExecutorServiceSynchronization {

    private static ExecutorService executorService = Executors.newFixedThreadPool(6, new ThreadFactory() {

        private int totalThreads = 0;

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "Thread #" + totalThreads++);
        }
    });

    private static AtomicInteger messageCount = new AtomicInteger();

    public static void main(String[] args) {

        for (String line : Constants.lines) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + line);
                messageCount.incrementAndGet();
            });
        }

        System.out.println("Messages dispatched: " + messageCount.get());
    }
}
