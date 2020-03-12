package com.homePropertiesControl.HPC.restApi.Repository;

import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SensorsRepository extends CrudRepository<Sensor, String> {
}
