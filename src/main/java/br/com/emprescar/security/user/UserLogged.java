package br.com.emprescar.security.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserLogged implements UserDetails {

    private br.com.emprescar.model.User user;

    private User springUserDetails;


    public UserLogged(br.com.emprescar.model.User user) {
        this.user = user;
        SimpleGrantedAuthority name = new SimpleGrantedAuthority("name:"+user.getCustomer().getName());
        SimpleGrantedAuthority lastName = new SimpleGrantedAuthority("lastName:"+user.getCustomer().getLastName());
        SimpleGrantedAuthority customerId = new SimpleGrantedAuthority("customerId:"+user.getCustomer().getId());
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("role:"+user.getRole().getName());
        this.springUserDetails = new User(user.getEmail(), user.getPassword(), List.of(name, lastName, customerId, role));
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return springUserDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return springUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return springUserDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return springUserDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return springUserDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return springUserDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return springUserDetails.isEnabled();
    }
}
