package istanbul.javausergroup.talk.concurrency.primitives;

import istanbul.javausergroup.talk.concurrency.Dispatcher;

import java.text.MessageFormat;
import java.util.Random;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class MessageDispatcher implements Dispatcher<String> {

    private int totalDispatched = 0;
    private static Random random = new Random();

    public void dispatch(String message) {
        new Thread(() -> {
            int id = totalDispatched;
            System.out.println(MessageFormat.format("MD: {0}: {1}", id, message));
            totalDispatched++;
        }).start();
    }

    @Override
    public int getTotalDispatched() {
        return totalDispatched;
    }
}
