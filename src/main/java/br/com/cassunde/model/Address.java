package br.com.cassunde.model;

import jakarta.validation.constraints.NotNull;

public class Address {

    @NotNull(message = "Name cannot be null")    String name;
    String number;

    public Address(String name, String number){
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
