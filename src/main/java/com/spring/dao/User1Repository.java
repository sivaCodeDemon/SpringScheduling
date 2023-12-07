package com.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Users;

@Repository
public interface User1Repository  extends JpaRepository<Users, Integer>{

}
