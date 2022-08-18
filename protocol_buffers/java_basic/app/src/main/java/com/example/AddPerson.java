package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class AddPerson {

    public static Person promptForAddress(BufferedReader stdin, PrintStream stdout) throws IOException {
        Person.Builder person = Person.newBuilder();

        stdout.print("enter person id: ");
        person.setId(Integer.parseInt(stdin.readLine()));

        stdout.print("enter name: ");
        person.setName(stdin.readLine());

        stdout.print("enter email address(blank for none): ");
        String email = stdin.readLine();
        if (email.length() > 0) {
            person.setEmail(email);
        }

        while (true) {
            stdout.print("enter a phone number (or leave blank to finish): ");
            String number = stdin.readLine();
            if (number.length() == 0) {
                break;
            }

            Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder()
                    .setNumber(number);

            stdout.print("is this a mobile, home, or work phone? ");
            String type = stdin.readLine();
            switch (type) {
                case "mobile" -> phoneNumber.setType(Person.PhoneType.MOBILE);
                case "home" -> phoneNumber.setType(Person.PhoneType.HOME);
                case "work" -> phoneNumber.setType(Person.PhoneType.WORK);
                default -> stdout.println("Unknown phone type. Using default.");
            }

            person.addPhones(phoneNumber);
        }

        return person.build();
    }

}
