package com.example.demo.dao;

import com.example.demo.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
