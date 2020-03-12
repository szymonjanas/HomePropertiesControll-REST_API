package com.homePropertiesControl.HPC.restApi.auth;

import com.homePropertiesControl.HPC.restApi.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository("mysql-db")
public class DatabaseApplicationUserDaoService implements ApplicationUserDao {

    private UsersRepository usersRepository;

    @Autowired
    public DatabaseApplicationUserDaoService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.of(usersRepository.findById(username).get());
    }
}
