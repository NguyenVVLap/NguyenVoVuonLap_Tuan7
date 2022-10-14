package com.example.micriservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
