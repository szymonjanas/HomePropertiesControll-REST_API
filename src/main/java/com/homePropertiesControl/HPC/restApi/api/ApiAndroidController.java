package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Services.AndroidService;
import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.json.JSONObject;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/android")
public class ApiAndroidController {

    private final AndroidService androidService;

    public ApiAndroidController(AndroidService androidService) {
        this.androidService = androidService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public @ResponseBody
    Iterable<Sensor> getAllSensors() {
        return androidService.getAllSensors();
    }

    @GetMapping("/login")
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public String isUserAuthorized() {
        return androidService.isUserAuthorized();
    }

    @PutMapping(path = "/{command}")
    @PreAuthorize("hasAnyRole('ROLE_ANDROID')")
    public String changeSensor(@PathVariable("command") String command, @RequestBody String sensorStr){
        return androidService.changeSensor(command, sensorStr);
    }

}
