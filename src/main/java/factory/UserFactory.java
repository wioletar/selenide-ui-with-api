package factory;

import com.github.javafaker.Faker;
import model.User;

public class UserFactory {

    Faker faker = new Faker();
    public User userWithAllCorrectData = User.builder()
            .name(faker.name().firstName())
            .email(faker.internet().emailAddress())
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .password(faker.internet().password())
            .city(faker.address().city())
            .address(faker.address().streetAddress())
            .address2(faker.address().secondaryAddress())
            .state(faker.address().state())
            .company(faker.company().name())
            .mobileNumber(faker.phoneNumber().phoneNumber())
            .zipcode(faker.address().zipCode())
            .build();
}
