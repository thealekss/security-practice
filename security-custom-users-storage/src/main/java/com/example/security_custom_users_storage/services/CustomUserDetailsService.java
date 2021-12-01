package com.example.security_custom_users_storage.services;

import com.example.security_custom_users_storage.entities.Role;
import com.example.security_custom_users_storage.entities.UserCredentials;
import com.example.security_custom_users_storage.repositories.RoleRepository;
import com.example.security_custom_users_storage.repositories.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserCredentialsRepository userRepo;

    private RoleRepository roleRepository;

    @Autowired
    public void setUserRepo(UserCredentialsRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private UserCredentials findByUsername(String username) {
        return userRepo.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials userCredentials = findByUsername(username);
        if (userCredentials == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new User(
                userCredentials.getUsername(),
                userCredentials.getPassword(),
                mapRoleToAuthority(userCredentials.getRoles())
        );


    }

    private Collection<? extends GrantedAuthority> mapRoleToAuthority(Collection<Role> roles) {
        return roles.stream().map(s -> new SimpleGrantedAuthority(s.getName())).collect(Collectors.toSet());
    }
}
