/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
@file:OptIn(ExperimentalSerializationApi::class)

package com.example.test

import com.example.test.vo.AddressBook
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.protobuf.ProtoBuf
import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.inputStream
import kotlin.io.path.outputStream
import kotlin.system.exitProcess

// https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/formats.md#protobuf-experimental

fun main(args: Array<String>) {
    write(args.toList())
    read(args.toList())
}

fun read(args: List<String>) {
    if (args.size != 1) {
        // this is wrong. but whatever just a tutorial
        println("usage: list_person ADDRESS_BOOK_FILE")
        exitProcess(-1)
    }
    Path(args.single()).inputStream().use {
        readAddressBook(ProtoBuf.decodeFromByteArray(it.readBytes()))
    }
}

private fun write(args: List<String>) {
    if (args.size != 1) {
        println("usage: add_person ADDRESS_BOOK_FILE")
        exitProcess(-1)
    }
    val path = Path(args.single())
    val initialAddressBook = if (!path.exists()) {
        println("file not found. creating new file.")
        AddressBook(emptyList())
    } else {
        path.inputStream().use {
            ProtoBuf.decodeFromByteArray(it.readBytes())
        }
    }

    path.outputStream().use {
        val addressBook = AddressBook(initialAddressBook.people + promptPerson())
        it.write(ProtoBuf.encodeToByteArray(addressBook))
    }
}
