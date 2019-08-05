package istanbul.javausergroup.talk.concurrency.primitives;

import istanbul.javausergroup.talk.concurrency.Constants;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class SharedPrimitives {

    public static void main(String[] args) throws InterruptedException {

        MessageDispatcher messageDispatcher = new MessageDispatcher();
        for (String line : Constants.lines) {
            messageDispatcher.dispatch(line);
        }

        ConcurrentMessageDispatcher concurrentMessageDispatcher = new ConcurrentMessageDispatcher();
        for (String line : Constants.lines) {
            concurrentMessageDispatcher.dispatch(line);
        }

        BlockingMessageDispatcher blockingMessageDispatcher = new BlockingMessageDispatcher();
        for (String line : Constants.lines) {
            blockingMessageDispatcher.dispatch(line);
        }
    }
}
