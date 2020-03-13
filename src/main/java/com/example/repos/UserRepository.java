package com.example.repos;

import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
   Optional<User> findByLogin(String login);
}
