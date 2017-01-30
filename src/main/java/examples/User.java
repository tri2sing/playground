package examples;

/**
 * Created by samadhik on 11/1/16.
 */

/**
 * Builder classes are similar to constructors. They allow you to reduce the
 * number of constructor arguments while still allowing you to assign initial
 * values to an instance.
 * Builder pattern aims to separate the construction of a complex object from
 * its representation so that the same construction process can create
 * different representations.
 */
public class User {
    // Immutable class, all final attributes
    private final String firstName; // Required
    private final String lastName;  // Required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public static UserBuilder builder() {
        return new User.UserBuilder();

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder() {
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }

    public static void main(String[] args) {

        //User.UserBuilder ub1 = new User.UserBuilder();
        //User.UserBuilder ub2 = User.builder();
        User user1 =  User.builder()
                .firstName("Spider")
                .lastName("Man")
                .age(42)
                .phone("1234567890")
                .address("1234 Awesome Rd.")
                .build();

        User user2 = User.builder()
                .firstName("Super")
                .lastName("Women")
                .phone("9034567812")
                .address("7890 Wonder Dr.")
                .build();

        User user3 = User.builder()
                .firstName("Black")
                .lastName("Widow")
                .age(29)
                .address("4567 Thrilling Ln.")
                .build();

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);
        System.out.println("user3 = " + user3);
    }
}
