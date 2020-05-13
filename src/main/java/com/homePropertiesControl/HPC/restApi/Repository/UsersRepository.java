package com.homePropertiesControl.HPC.restApi.Repository;

import com.homePropertiesControl.HPC.restApi.Models.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<ApplicationUser, String> {
}
