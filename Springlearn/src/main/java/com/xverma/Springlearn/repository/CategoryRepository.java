package com.xverma.Springlearn.repository;

import com.xverma.Springlearn.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
