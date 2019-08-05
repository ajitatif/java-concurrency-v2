package istanbul.javausergroup.talk.concurrency;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public interface Dispatcher<T> {

    void dispatch(T subject);
    int getTotalDispatched();
}
