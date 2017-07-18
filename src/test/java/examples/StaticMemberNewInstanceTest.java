package examples;

import org.junit.Test;

public class StaticMemberNewInstanceTest {

    @Test
    public void check() throws Exception {
        new StaticMemberNewInstance();
        StaticMemberNewInstance.insert(1, 1);
        System.out.println(StaticMemberNewInstance.retrieve(1));
        new StaticMemberNewInstance();
        StaticMemberNewInstance.insert(2, 2);
        System.out.println(StaticMemberNewInstance.retrieve(1));
        System.out.println(StaticMemberNewInstance.retrieve(2));
    }

}
