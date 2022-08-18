package com.example.test

import com.example.test.vo.Person

// this function fills in a person message based on user input
fun promptPerson(): Person {
    print("enter person id: ")
    val id = readLine()!!.toInt()

    print("enter name: ")
    val name = readLine()!!

    print("enter an email address (blank for none): ")
    var email = readLine()!!
    email = if (email.isNotEmpty()) email else ""

    val phones = mutableListOf<Person.PhoneNumber>()

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
        phones.add(
            Person.PhoneNumber(number, type)
        )
    }

    return Person(name, id, email, phones)
}