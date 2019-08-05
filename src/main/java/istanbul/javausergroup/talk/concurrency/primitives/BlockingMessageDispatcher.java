package istanbul.javausergroup.talk.concurrency.primitives;

import istanbul.javausergroup.talk.concurrency.Dispatcher;

import java.text.MessageFormat;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class BlockingMessageDispatcher implements Dispatcher<String> {

    private volatile int totalDispatched = 0;
    private final Object lock = new Object();

    @Override
    public void dispatch(String subject) {
        int id = totalDispatched;
        new Thread(() -> System.out.println(MessageFormat.format("BMD: {0}: {1}", id, subject))).start();
        synchronized (lock) {
            totalDispatched++;
        }

    }

    @Override
    public int getTotalDispatched() {
        return totalDispatched;
    }
}
