package org.example.surprise_spring_boot_test.repository;

import org.example.surprise_spring_boot_test.entity.ExhibitionTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionTagRepository extends JpaRepository<ExhibitionTag, Long> {

}