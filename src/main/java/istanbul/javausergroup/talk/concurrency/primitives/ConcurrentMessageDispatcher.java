package istanbul.javausergroup.talk.concurrency.primitives;

import istanbul.javausergroup.talk.concurrency.Dispatcher;

import java.text.MessageFormat;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class ConcurrentMessageDispatcher implements Dispatcher<String> {

    private volatile int totalDispatched;

    @Override
    public void dispatch(String subject) {
        int id = totalDispatched;
        new Thread(() -> System.out.println(MessageFormat.format("CMD: {0}: {1}", id, subject))).start();
        incrementTotalDispatched();
    }

    @Override
    public int getTotalDispatched() {
        return totalDispatched;
    }

    private synchronized void incrementTotalDispatched() {
        totalDispatched++;
    }
}
