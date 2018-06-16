package com.example.sample.repository;

import com.example.sample.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
}
