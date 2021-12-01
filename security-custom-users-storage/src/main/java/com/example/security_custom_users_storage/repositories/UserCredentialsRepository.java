package com.example.security_custom_users_storage.repositories;

import com.example.security_custom_users_storage.entities.UserCredentials;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long > {
    @EntityGraph(value = "user-entity-graph")
    public UserCredentials findByUsername(String name);
}
