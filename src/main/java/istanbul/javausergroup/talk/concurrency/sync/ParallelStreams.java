package istanbul.javausergroup.talk.concurrency.sync;

import istanbul.javausergroup.talk.concurrency.Constants;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gökalp Gürbüzer (gokalp.gurbuzer@yandex.com)
 */
public class ParallelStreams {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList(Constants.lines);

        PrintStream out = System.out;

        lines.parallelStream().forEach(out::println);

        System.out.println("---");

        lines.forEach(out::println);
    }
}
