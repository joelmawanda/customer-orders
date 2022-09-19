package com.orderapi.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @NotBlank(message = "Firstname  cannot be blank")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Lastname  cannot be blank")
    @Column(nullable = false)
    private String lastName;

    @NotBlank(message = "Gender  cannot be blank")
    @Column(nullable = false)
    private String gender;

    @NotBlank(message = "Date of birth  cannot be blank")
    @Column(nullable = false)
    private String dateOfBirth;

    @NotBlank(message = "Phone number  cannot be blank")
    @Column(nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Email  cannot be blank")
    @Column(nullable = false)
    private String email;

//    @JsonManagedReference(value = "customer-orders")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
    private Set<Orders> orders = new HashSet<>();
}
