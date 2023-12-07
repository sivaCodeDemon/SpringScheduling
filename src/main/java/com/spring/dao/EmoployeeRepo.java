package com.spring.dao;

import com.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmoployeeRepo extends JpaRepository<Employee,Integer> {
}
