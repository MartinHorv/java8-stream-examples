package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreams {

    @Test
    public void parallelStream(){
        List<String> names = Arrays.asList("Peter","Manfred","Michael","Luis");
        long count =  names.parallelStream().filter(p -> p.startsWith("M")).peek(System.out::println).count();
    }

    @Test
    public void parallelStreamExample2(){
        boolean hasCustomerOrder =  Stream.of("InternalOrder","InternalOrder","InternalOrder","InternalOrder","CustomerOrder")
                .parallel().anyMatch(s -> s.equalsIgnoreCase("CustomerOrder"));
        System.out.println(hasCustomerOrder);
    }

    @Test
    public void parallelToSequential(){
        List<String> names = Arrays.asList("Peter","Manfred","Michael","Luis");
        long count =  names.parallelStream().sequential().filter(p -> p.startsWith("M")).peek(System.out::println).count();
    }

}
