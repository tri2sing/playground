package examples;

import org.junit.Test;

import random.StaticMemberNewInstance;

public class StaticMemberNewInstanceTest {

    @Test
    public void check() throws Exception {
        new StaticMemberNewInstance();
        StaticMemberNewInstance.insert(1, 1);
        new StaticMemberNewInstance();
        StaticMemberNewInstance.insert(2, 2);
    }

}
