package com.homePropertiesControl.HPC.restApi.Repository;

import com.homePropertiesControl.HPC.restApi.auth.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<ApplicationUser, String> {
}
