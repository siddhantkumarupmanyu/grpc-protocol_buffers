package com.example.test.vo

import kotlinx.serialization.Serializable

@Serializable
data class AddressBook(
    val people: List<Person>
)