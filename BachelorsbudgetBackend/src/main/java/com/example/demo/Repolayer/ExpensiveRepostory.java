package com.example.demo.Repolayer;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.ExpensiveEntity;


@Repository
public interface ExpensiveRepostory extends JpaRepository <ExpensiveEntity, Integer> {
    // Custom query methods can be defined here if needed
    Optional<ExpensiveEntity> findById(int id);
}
