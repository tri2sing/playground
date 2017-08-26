package random;

import lombok.*;

/**
 * Created by samadhik on 10/28/16.
 * Modified by samadhik on 11/01/16.
 */
@Builder(builderClassName = "Builder", toBuilder = true)
@Getter
@Value
public class UserLombok {
    // Immutable class, all final attributes
    private final String firstName; // Required
    private final String lastName;  // Required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    public static void main(String[] args) {
        UserLombok user1 = UserLombok.builder()
                .firstName("Spider")
                .lastName("Man")
                .age(42)
                .phone("1234567890")
                .address("1234 Awesome Rd")
                .build();
        System.out.println("user1 = " + user1);
        UserLombok user2 = UserLombok.builder()
                .firstName("Super")
                .lastName("Woman")
                .build();
        System.out.println("user 2 = " + user2);
        UserLombok user3 = user2.toBuilder()
                .phone("9182736455")
                .address("4567 Thrilling Ln.")
                .build();
        System.out.println("user3 = " + user3);
    }
}
