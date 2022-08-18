package com.example;

public class ListPeople {
    // iterates through all the people in the AddressBook and prints info about them

    public static void print(AddressBook addressBook) {
        for (Person person : addressBook.getPersonList()) {
            System.out.println("Person id: " + person.getId());
            System.out.println("Name: " + person.getName());
            if (person.hasEmail()) {
                System.out.println("email address: " + person.getEmail());
            }

            for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
                switch (phoneNumber.getType()) {
                    case MOBILE -> System.out.print("Mobile phone #:");
                    case HOME -> System.out.print("Home phone #:");
                    case WORK -> System.out.print("Work phone #:");
                }
                System.out.println(phoneNumber.getNumber());
            }
        }
    }
}
