package examples;

import java.util.Locale;
import java.util.stream.Stream;

public class Faker {
    private static final net.datafaker.Faker faker = new net.datafaker.Faker();

    public static String firstName() {
        return "Test_" + faker.name().firstName();
    }

    public static String lastName() {
        return  faker.name().lastName();
    }

    public static String userEmail() {
        return faker.internet().emailAddress();
    }

    public static String text() {
        return faker.lorem().sentence();
    }

    public static String phoneNumber() {
        return "8" + faker.phoneNumber().subscriberNumber(9);
    }

    public static String userAddress() {
        return faker.address().fullAddress();
    }

    public static String userGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String userHobbie() {
        return faker.options().option("Sports", "Music", "Reading");
    }

    public static String userSubject() {
        return faker.options().option("English", "Chemistry", "Computer science", "Commerce",
                "Economics", "Social studies", "Arts", "History", "Maths",
                "Biology", "Physics", "Accounting", "Civics", "Hindi");
    }

    public static String dayOfBirth() {
        return String.valueOf(faker.number().numberBetween(1, 29));
    }

    public static String monthOfBirth() {
         String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
         return faker.options().option(months);
    }

    public static String yearOfBirth() {
        return String.valueOf(faker.number().numberBetween(1980, 2000));
    }

    public static String userState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String userCity() {
        return faker.options().option("Delfi", "Gurgaon", "Noida", "Agra", "Lucknow", "Merrut", "Karnal", "Papinat", "Jaipur", "Jaiselmer");
    }

}
