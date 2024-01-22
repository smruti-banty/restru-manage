package com.lafista.backend.waiter.repository;

import com.lafista.backend.waiter.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaiterRepository extends JpaRepository<Waiter, String> {

}
