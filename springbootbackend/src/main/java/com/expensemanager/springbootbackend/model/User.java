package com.expensemanager.springbootbackend.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String emailId;
}
