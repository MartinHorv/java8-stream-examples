package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class PrimitiveStreams {

    @Test
    public void intStream(){
        int max = IntStream.rangeClosed(1,10).max().getAsInt();
        int min = IntStream.range(1,10).min().getAsInt();
        double avg = IntStream.rangeClosed(1,10).average().getAsDouble();
        System.out.println("Max: "+max +" Min: "+min+ " Avg: "+avg);
    }

    @Test
    public void mapToLong (){
        List<String> numbers = Arrays.asList("26151","900001","7000321","900001","7000321","0");
        long sum = numbers.stream().mapToLong(Long::valueOf).sum();
        System.out.println(sum);
    }

    @Test
    public void doubleStream(){
        List<Double> doubleList = DoubleStream.of(20.5, 35.9, 55.8, 68.7, 80.5).boxed().collect(Collectors.toList());

    }

}
