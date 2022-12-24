package com.fintech.SpringCo.data.repositories;

import com.fintech.SpringCo.data.models.Deluxe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeluxeRepository  extends JpaRepository<Deluxe, String> {
}