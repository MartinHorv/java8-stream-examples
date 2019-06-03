package at.breakfast.streamexamples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsTest {

    @Test
    public void allMatch(){
       boolean onlyInternalOrders =  Stream.of("InternalOrder","InternalOrder","InternalOrder","InternalOrder","CustomerOrder")
                .allMatch(s -> s.equalsIgnoreCase("InternalOrder"));
        System.out.println(onlyInternalOrders);
    }

    @Test
    public void anyMatch(){
        boolean hasCustomerOrder =  Stream.of("InternalOrder","InternalOrder","InternalOrder","InternalOrder","CustomerOrder")
                .anyMatch(s -> s.equalsIgnoreCase("CustomerOrder"));
        System.out.println(hasCustomerOrder);
    }

    @Test
    public void noneMatch(){
        boolean hasNoCustomerOrder =  Stream.of("InternalOrder","InternalOrder","InternalOrder","InternalOrder","CustomerOrder")
                .noneMatch(s -> s.equalsIgnoreCase("CustomerOrder"));
        System.out.println(hasNoCustomerOrder);
    }

    @Test
    public void collectJoin(){
        List<String> emails = Arrays.asList("horvath.martin@ksv.at","ksvTestmails@ksv.at","ito-it.services@ksv.at");
        String emailsJoined = emails.stream().filter(s -> s.contains("@ksv.at")).collect(Collectors.joining(", "));
        System.out.println(emailsJoined);
    }

    @Test
    public void collectGroupBy(){
        List<String> emails = Arrays.asList("horvath.martin@ksv.at","ksvTestmails@ksv.at","ito-it.services@ksv.at","martin.horvath@ebcont.com");
        Map<Boolean,List<String>> groupedMails = emails.stream().collect(Collectors.groupingBy(p -> p.endsWith("@ksv.at")));
        System.out.println(groupedMails);
    }
}
