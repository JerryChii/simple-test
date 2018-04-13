package com.example.tutorial.addressbook;

public class CreateTest {
    public static void main(String[] args) {
        AddressBookProtos.Person john =
                AddressBookProtos.Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                AddressBookProtos.Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(AddressBookProtos.Person.PhoneType.HOME))
                        .build();

        System.out.println(john.isInitialized());
        System.out.println(john.toString());
    }

}
