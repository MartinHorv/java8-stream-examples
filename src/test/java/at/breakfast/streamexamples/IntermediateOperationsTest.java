package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationsTest {

    @Test
    public void filter(){
        List<String> names = Arrays.asList("Peter","Manfred","Michael","Luis");
      long count =  names.stream().filter(p -> p.startsWith("M")).peek(System.out::println).count();

    }

    @Test
    public void map (){
        List<String> names = Arrays.asList("Peter","Manfred","Michael","Luis");
        List<String> upperCaseNames = names.stream().map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());
    }

    @Test
    public void distinct (){
        List<String> numbers = Arrays.asList("26151","900001","7000321","900001","7000321","0");
        List<String> upperCaseNames = numbers.stream().distinct().peek(System.out::println).collect(Collectors.toList());
    }

    @Test
    public void sorted(){
        Stream.of(9,8,7,6,5,4,3,2,1,0).sorted().forEach(System.out::println);
    }

    @Test
    public void limit(){
        Stream.generate(UUID::randomUUID).limit(5).forEach(System.out::println);
    }
}
