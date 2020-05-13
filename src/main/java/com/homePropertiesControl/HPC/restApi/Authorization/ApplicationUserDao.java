package com.homePropertiesControl.HPC.restApi.Authorization;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);

}
