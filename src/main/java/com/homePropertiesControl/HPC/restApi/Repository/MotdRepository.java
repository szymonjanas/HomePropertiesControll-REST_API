package com.homePropertiesControl.HPC.restApi.Repository;

import com.homePropertiesControl.HPC.restApi.Models.Motd;
import org.springframework.data.repository.CrudRepository;

public interface MotdRepository extends CrudRepository<Motd, Integer> {
}
