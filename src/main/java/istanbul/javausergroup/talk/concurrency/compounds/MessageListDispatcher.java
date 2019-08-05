package istanbul.javausergroup.talk.concurrency.compounds;

import istanbul.javausergroup.talk.concurrency.Dispatcher;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class MessageListDispatcher implements Dispatcher<List<String>> {

    private Queue<String> queue = new LinkedList<>();
    private AtomicInteger totalDispatched = new AtomicInteger();

    @Override
    public void dispatch(List<String> subject) {
        queue.addAll(subject);
        dispatchAll();
    }

    private void dispatchAll() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            new Thread(() -> {
                if (!queue.isEmpty()) {
                    String poll = queue.poll();
                    System.out.println(MessageFormat.format("MLD: {0}: {1}", totalDispatched.getAndIncrement(), poll));
                }
            }).start();
        }
    }

    @Override
    public int getTotalDispatched() {
        return totalDispatched.get();
    }
}
