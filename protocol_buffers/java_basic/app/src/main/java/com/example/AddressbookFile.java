// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: main/proto/addressbook_file.proto

package com.example;

public final class AddressbookFile {
  private AddressbookFile() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Person_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Person_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_Person_PhoneNumber_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_Person_PhoneNumber_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_AddressBook_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_AddressBook_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!main/proto/addressbook_file.proto\022\013com" +
      ".example\"\242\002\n\006Person\022\021\n\004name\030\001 \001(\tH\000\210\001\001\022\017" +
      "\n\002id\030\002 \001(\005H\001\210\001\001\022\022\n\005email\030\003 \001(\tH\002\210\001\001\022/\n\006p" +
      "hones\030\004 \003(\0132\037.com.example.Person.PhoneNu" +
      "mber\032h\n\013PhoneNumber\022\023\n\006number\030\001 \001(\tH\000\210\001\001" +
      "\0220\n\004type\030\002 \001(\0162\035.com.example.Person.Phon" +
      "eTypeH\001\210\001\001B\t\n\007_numberB\007\n\005_type\"+\n\tPhoneT" +
      "ype\022\n\n\006MOBILE\020\000\022\010\n\004HOME\020\001\022\010\n\004WORK\020\002B\007\n\005_" +
      "nameB\005\n\003_idB\010\n\006_email\"2\n\013AddressBook\022#\n\006" +
      "person\030\001 \003(\0132\023.com.example.PersonB\002P\001b\006p" +
      "roto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_example_Person_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_Person_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Person_descriptor,
        new java.lang.String[] { "Name", "Id", "Email", "Phones", "Name", "Id", "Email", });
    internal_static_com_example_Person_PhoneNumber_descriptor =
      internal_static_com_example_Person_descriptor.getNestedTypes().get(0);
    internal_static_com_example_Person_PhoneNumber_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_Person_PhoneNumber_descriptor,
        new java.lang.String[] { "Number", "Type", "Number", "Type", });
    internal_static_com_example_AddressBook_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_AddressBook_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_AddressBook_descriptor,
        new java.lang.String[] { "Person", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
