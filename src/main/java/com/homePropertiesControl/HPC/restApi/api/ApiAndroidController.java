package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Repository.SensorsRepository;
import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/android")
public class ApiAndroidController {

    @Autowired
    private SensorsRepository sensorsRepository;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public @ResponseBody
    Iterable<Sensor> getAllSensors() {
        return sensorsRepository.findAll();
    }

    @GetMapping("/login")
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public String isUserAuthorized() {
        return "TRUE";
    }

    @PutMapping(path = "/{command}/**")
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public String changeSensor(@PathVariable("command") String command, @RequestBody final Sensor sensor) {
        if (sensorsRepository.findById(sensor.getId()).isPresent()){
            Sensor tsensor = sensorsRepository.findById(sensor.getId()).get();
            switch (command) {
                case "level":
                    tsensor.setLevel(sensor.getLevel());
                    break;
                case "name":
                    tsensor.setName(sensor.getName());
                    break;
                case "type":
                    tsensor.setType(sensor.getType());
                    break;
                case "location":
                    tsensor.setLocation(sensor.getLocation());
                    break;
                default:
                    return "FALSE";
            }
            sensorsRepository.save(tsensor);
            return "TRUE";
        }
        return "FALSE";
    }
}