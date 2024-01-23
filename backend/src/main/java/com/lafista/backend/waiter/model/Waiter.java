package com.lafista.backend.waiter.model;

import com.lafista.backend.table.model.RestaurantTable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Waiter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String waiterId;

    private String waiterName;

    // @Column(unique = true)
    // private String employeeCode;

    private int waiterAge;

    private String waiterEmail;

    private String waiterNumber;

    @OneToOne
    @JoinColumn(name = "assigned_table_id")
    private RestaurantTable assignedTable;
}
