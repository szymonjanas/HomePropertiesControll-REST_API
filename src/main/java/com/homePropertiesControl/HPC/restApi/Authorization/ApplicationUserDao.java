package com.homePropertiesControl.HPC.restApi.Authorization;

import com.homePropertiesControl.HPC.restApi.Models.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
