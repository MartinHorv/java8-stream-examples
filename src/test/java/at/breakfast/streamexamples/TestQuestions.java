package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.stream.Stream;

public class TestQuestions {


    @Test
    public void questionOne(){
        Stream<String> stream = Stream.iterate("", s -> s+ "1");
        System.out.println(stream.limit(2).map(x -> x+ "2"));
    }

    @Test
    public void questionTwo(){
        Stream<String> stream = Stream.iterate("-",s -> s + s);
        boolean b1 = stream.noneMatch(s -> s.length() >3);
        boolean b2 = stream.anyMatch(s -> s.length()  > 3);
    }
}
