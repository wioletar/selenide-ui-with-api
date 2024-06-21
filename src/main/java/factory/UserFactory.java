package factory;

import model.User;

public class UserFactory {

    public User userWithAllData = User.builder()
            .name("Jesse")
            .email("jesse_gislason28@hotmail.com")
            .firstName("Jesse")
            .lastName("Gislason")
            .password("1234")
            .city("Austin")
            .address("1020 Sauer Courts")
            .address2("Apt. 801")
            .state("Teksas")
            .company("Bee")
            .mobileNumber("+1 560-722-6060")
            .zipcode("30774-9880")
            .build();
}
