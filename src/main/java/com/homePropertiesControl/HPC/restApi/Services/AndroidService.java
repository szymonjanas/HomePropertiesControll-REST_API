package com.homePropertiesControl.HPC.restApi.Services;

import com.homePropertiesControl.HPC.restApi.Repository.SensorsRepository;
import com.homePropertiesControl.HPC.restApi.Models.Sensor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class AndroidService {

    private final SensorsRepository sensorsRepository;

    public AndroidService(SensorsRepository sensorsRepository) {
        this.sensorsRepository = sensorsRepository;
    }

    public Iterable<Sensor> getAllSensors() {
        return sensorsRepository.findAll();
    }

    public String isUserAuthorized() {
        return "TRUE";
    }

    public String changeSensor(String command, String sensorStr) {
        JSONObject jsonObject = new JSONObject(sensorStr);
        Sensor sensor = new Sensor(jsonObject);

        JSONObject response = new JSONObject();
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
                case "state":
                    tsensor.setState(sensor.getState());
                    break;
                default:
                    response.put("message", "Command not found!");
                    return response.toString();
            }
            sensorsRepository.save(tsensor);
            response.put("message", "ok");
            return response.toString();
        }
        response.put("message", "Sensor with given id not found!");
        return response.toString();
    }

}
