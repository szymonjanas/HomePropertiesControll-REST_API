package com.homePropertiesControl.HPC.restApi.Authorization;

import com.homePropertiesControl.HPC.restApi.Models.ApplicationUser;
import com.homePropertiesControl.HPC.restApi.Repository.UsersRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository("mysql-db")
public class DatabaseApplicationUserDaoService implements ApplicationUserDao {

    private final UsersRepository usersRepository;

    public DatabaseApplicationUserDaoService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return Optional.of(usersRepository.findById(username).get());
    }
}
