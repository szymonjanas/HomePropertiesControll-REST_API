package com.homePropertiesControl.HPC.restApi.Authorization;

import com.homePropertiesControl.HPC.restApi.Models.ApplicationUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUserService(@Qualifier("mysql-db") ApplicationUserDao applicationUserDao, PasswordEncoder passwordEncoder) {
        this.applicationUserDao = applicationUserDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (applicationUserDao.selectApplicationUserByUsername(username).isPresent()){
            ApplicationUser user = applicationUserDao.selectApplicationUserByUsername(username).get();
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return user;
        } else {
            throw new UsernameNotFoundException(String.format("Username %s not found", username));
        }
    }
}
