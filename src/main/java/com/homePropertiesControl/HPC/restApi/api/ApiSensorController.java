package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Repository.SensorsRepository;
import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/sensor")
public class ApiSensorController {

    @Autowired
    private SensorsRepository sensorsRepository;

    @GetMapping("/state")
    @PreAuthorize("hasAnyRole('ROLE_SENSOR')")
    public boolean getState(Principal principal)  throws Exception {
        String id = principal.getName();
        if (sensorsRepository.findById(id).isPresent()){
            return sensorsRepository.findById(id).get().getState();
        } else {
            throw new Exception("Sensor not found with id: " + id);
        }
    }

    @GetMapping("/level")
    @PreAuthorize("hasAnyRole('ROLE_SENSOR')")
    public int getLevel(Principal principal) throws Exception {
        String id =principal.getName();
        if (sensorsRepository.findById(id).isPresent()){
            return sensorsRepository.findById(id).get().getLevel();
        } else {
            throw new Exception("Sensor not found with id:  " + id);
        }
    }

    @PutMapping(path = "/log/{log}")
    @PreAuthorize("hasAnyRole('ROLE_SENSOR')")
    public void changeSensor(@PathVariable("log") String log, Principal principal) {
        UUID id = UUID.fromString(principal.getName());
        // TO DO: Logs which are save in separate database with sensor id as id, and date/time.
    }
}
