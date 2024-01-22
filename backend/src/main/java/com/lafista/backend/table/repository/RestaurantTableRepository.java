package com.lafista.backend.table.repository;

import com.lafista.backend.table.model.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, String> {

}
