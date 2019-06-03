package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTest {

    @Test
    public void basicStream(){
        Collection<String> ksvNumbers = Arrays.asList("26151","14567","7389130","915077472","934638609");
        ksvNumbers.stream().filter(n -> Integer.valueOf(n) >= 900_000_000)
                .forEach(n -> System.out.println(n));
    }

    @Test
    public void sortedStream(){
        Collection<String> ksvNumbers = Arrays.asList("26151","14567","7389130","915077472","934638609");
        List<String> newList = ksvNumbers.stream().sorted()
                .collect(Collectors.toList());
        System.out.println(newList);
    }

    @Test
    public void createAnEmptyStream(){
        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
    }

    @Test
    public void createStreamWithStreamOf(){
        Stream<String> streamOfArray = Stream.of("ABC1","CDE","DSF");
        String[] stringArr = new String[] {"ABC1","CDE","DSF"};
        Stream<String> stream = Arrays.stream(stringArr);

    }

    @Test
    public void createStreamGenerate(){
        Stream<UUID> uuidStream = Stream.generate(UUID::randomUUID);
        uuidStream.limit(1).forEach(System.out::println);
    }

    @Test
    public void createStreamIterate(){
        Stream<Integer> intStream = Stream.iterate(2,(Integer n) -> n + 2 );
        intStream.limit(3).forEach(System.out::println);
    }



}