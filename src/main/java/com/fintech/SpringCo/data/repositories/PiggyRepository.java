package com.fintech.SpringCo.data.repositories;

import com.fintech.SpringCo.data.models.Piggy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PiggyRepository  extends JpaRepository<Piggy, String> {
}