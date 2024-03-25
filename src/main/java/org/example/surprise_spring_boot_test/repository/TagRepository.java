package org.example.surprise_spring_boot_test.repository;

import org.example.surprise_spring_boot_test.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}