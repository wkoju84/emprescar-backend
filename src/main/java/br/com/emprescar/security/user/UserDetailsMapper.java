package br.com.emprescar.security.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsMapper {

    UserDetails map(Object shouldBeASystemUser);
}

