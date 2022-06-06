package org.example.repository;

import org.example.app.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending,Long> {
}
