package com.example.kotlin_basic

import com.example.kotlin_basic.proto.Person
import com.example.kotlin_basic.proto.PersonKt.phoneNumber
import com.example.kotlin_basic.proto.person

// this function fills in a person message based on user input

fun promptPerson(): Person = person {
    print("enter person id: ")
    id = readLine()!!.toInt()

    print("enter name: ")
    name = readLine()!!

    print("enter an email address (blank for none): ")
    val email = readLine()
    if (email != null) {
        if (email.isNotEmpty()) {
            this.email = email
        }
    }

    while (true) {
        print("enter a phone number (or leave blank to finish): ")
        val number = readLine()
        if (number.isNullOrEmpty()) {
            break;
        }

        print("is this a mobile, home or work phone? ")
        val type = when (readLine()) {
            "mobile" -> Person.PhoneType.MOBILE
            "home" -> Person.PhoneType.HOME
            "work" -> Person.PhoneType.WORK
            else -> {
                println("unknown type, using home")
                Person.PhoneType.HOME
            }
        }
        phones += phoneNumber {
            this.number = number
            this.type = type
        }
    }
}