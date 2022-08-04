package com.selenium.nosalty.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum User {
    USER("Dr.", "Ridout", "Suzanna", "onagiantsshoulder@gmail.com", "1234Tinydoggo", "1992", "5000", "female"),
    USER1("Ifj.", "Kennedy", "Don", "onagiantsshoulder@gmail.com", "5678Legally", "1982", "6000", "other"),
    USER2("Id.", "Beckford", "Robert", "onagiantsshoulder@gmail.com", "9101Accessing", "1972", "3000", "male");

    private final String prefix;
    private final String lastName;
    private final String firstName;
    private final String emailAddress;
    private final String password;
    private final String birthdayYear;
    private final String zipcode;
    private final String gender;
}
