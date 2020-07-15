package com.tenere_bufo.itis.services;

import com.tenere_bufo.itis.model.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RolesService {
    Role save(Role role);
    Optional<Role> findByName(String name);
}
