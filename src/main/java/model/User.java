package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    String name;
    String email;
    String password;
    String firstName;
    String lastName;
    String company;
    String address;
    String address2;
    String state;
    String city;
    String zipcode;
    String mobileNumber;
}
