package com.example.test

import com.example.test.proto.AddressBook
import com.example.test.proto.Person

// iterates through all people in the AddressBook and prints info about them
fun readAddressBook(addressBook: AddressBook) {
    for (person in addressBook.peopleList) {
        println("person id: ${person.id}")
        println("name: ${person.name}")
        if (person.hasEmail()) {
            println("email: ${person.email}")
        }
        for (phoneNumber in person.phonesList) {
            val modifier = when (phoneNumber.type) {
                Person.PhoneType.MOBILE -> "Mobile"
                Person.PhoneType.HOME -> "Home"
                Person.PhoneType.WORK -> "Work"
                else -> "unknown"
            }
            println("$modifier phone: ${phoneNumber.number}")
        }
    }
}