package com.lafista.backend.table.model;

import com.lafista.backend.waiter.model.Waiter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String tableId;

    private String tableName;

    @OneToOne(mappedBy = "assignedTable")
    private Waiter assignedWaiter;
}