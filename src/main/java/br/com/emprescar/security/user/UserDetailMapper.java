package br.com.emprescar.security.user;

import br.com.emprescar.model.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
public class UserDetailMapper implements UserDetailsMapper {

    @Override
    public UserDetails map(Object shouldBeASystemUser) {
        return new UserLogged((User)
                shouldBeASystemUser);
    }
}
