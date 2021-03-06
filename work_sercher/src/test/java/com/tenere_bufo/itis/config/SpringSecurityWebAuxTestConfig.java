package com.tenere_bufo.itis.config;

import com.tenere_bufo.itis.model.Role;
import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import com.tenere_bufo.itis.security.details.UserDetailsImpl;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashSet;
import java.util.Set;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User user = new User("user@company.com", "password");
        user.setStatus(State.ACTIVE);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.builder().name("ROLE_USER").build());
        user.setRoles(roles);

        User employer = new User("employer@company.com", "password");
        Set<Role> roles1 = new HashSet<>();
        employer.setStatus(State.ACTIVE);
        roles1.add(Role.builder().name("ROLE_EMPLOYER").build());
        employer.setRoles(roles1);

        User admin = new User("admin@company.com", "password");
        Set<Role> roles2 = new HashSet<>();
        admin.setStatus(State.ACTIVE);
        roles2.add(Role.builder().name("ROLE_ADMIN").build());
        admin.setRoles(roles2);

        return new InMemoryUserDetailsManager(new UserDetailsImpl(user),
                new UserDetailsImpl(employer), new UserDetailsImpl(admin));
    }
}
