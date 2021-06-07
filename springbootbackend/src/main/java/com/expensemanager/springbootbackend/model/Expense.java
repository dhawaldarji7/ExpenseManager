package com.expensemanager.springbootbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "expenses")
public class Expense {

    @Id
    private Long id;

    private Instant date;

    private String desc;

    private String location;

    @ManyToOne
    private expenseCategory category;

    @JsonIgnore
    @ManyToOne
    private User user;
}
