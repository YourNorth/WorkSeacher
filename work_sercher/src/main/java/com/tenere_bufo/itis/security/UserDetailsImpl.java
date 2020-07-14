package com.tenere_bufo.itis.security;

import com.tenere_bufo.itis.model.State;
import com.tenere_bufo.itis.model.User;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Slf4j
@NoArgsConstructor
@Builder
@Data
@ToString
public class UserDetailsImpl implements UserDetails {
    private User user;

    public UserDetailsImpl(User user){
        this.user = user;
    };

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) user.getRoles();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        log.info("isAccountNonExpired() returns " + !user.getStatus().equals(State.NOT_ACTIVE));
        return !user.getStatus().equals(State.NOT_ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {

        log.info("isAccountNonLocked() returns " + !user.getStatus().equals(State.BANNED));
        return !user.getStatus().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        log.info("isCredentialsNonExpired() returns " + !user.getStatus().equals(State.DELETED));
        return !user.getStatus().equals(State.DELETED);
    }

    @Override
    public boolean isEnabled() {
        log.info("isEnabled() returns " + user.getStatus().equals(State.ACTIVE));
        return user.getStatus().equals(State.ACTIVE);
    }
}
