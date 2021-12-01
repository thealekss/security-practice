package com.example.security_custom_users_storage.repositories;

import com.example.security_custom_users_storage.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
