package org.example.surprise_spring_boot_test.repository;

import org.example.surprise_spring_boot_test.entity.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {

}