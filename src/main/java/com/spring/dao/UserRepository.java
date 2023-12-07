package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Model;

public interface UserRepository extends JpaRepository<Model, Integer> {

}
