// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/addressbook_file.proto

package com.example;

public interface AddressBookOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.AddressBook)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .com.example.Person person = 1;</code>
   */
  java.util.List<com.example.Person> 
      getPersonList();
  /**
   * <code>repeated .com.example.Person person = 1;</code>
   */
  com.example.Person getPerson(int index);
  /**
   * <code>repeated .com.example.Person person = 1;</code>
   */
  int getPersonCount();
  /**
   * <code>repeated .com.example.Person person = 1;</code>
   */
  java.util.List<? extends com.example.PersonOrBuilder> 
      getPersonOrBuilderList();
  /**
   * <code>repeated .com.example.Person person = 1;</code>
   */
  com.example.PersonOrBuilder getPersonOrBuilder(
      int index);
}
