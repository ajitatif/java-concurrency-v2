package istanbul.javausergroup.talk.concurrency.compounds;

import istanbul.javausergroup.talk.concurrency.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class SharedCompounds {

    public static void main(String[] args) {

        // MessageListDispatcher dispatcher = new MessageListDispatcher();
        ConcurrentMessageListDispatcher dispatcher = new ConcurrentMessageListDispatcher();
        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            messages.addAll(Arrays.asList(Constants.lines));
        }

        dispatcher.dispatch(messages);
        dispatcher.dispatch(messages);
    }
}
