package com.homePropertiesControl.HPC.restApi.Repository;

import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorsRepository extends CrudRepository<Sensor, String> {
}
