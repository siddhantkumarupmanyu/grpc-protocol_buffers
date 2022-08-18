package com.example.test.vo

import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val name: String,
    val id: Int,
    val email: String,
    val phones: List<PhoneNumber>
) {

    @Serializable
    enum class PhoneType {
        MOBILE,
        HOME,
        WORK
    }

    @Serializable
    data class PhoneNumber(
        val number: String,
        val type: PhoneType
    )

}
