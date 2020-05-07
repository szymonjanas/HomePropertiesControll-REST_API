package com.homePropertiesControl.HPC.restApi.Services;

import com.homePropertiesControl.HPC.restApi.Repository.ComplainsRepository;
import com.homePropertiesControl.HPC.restApi.Repository.MotdRepository;
import com.homePropertiesControl.HPC.restApi.Repository.SensorsRepository;
import com.homePropertiesControl.HPC.restApi.Repository.UsersRepository;
import com.homePropertiesControl.HPC.restApi.auth.ApplicationUser;
import com.homePropertiesControl.HPC.restApi.model.Complains;
import com.homePropertiesControl.HPC.restApi.model.Motd;
import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.ui.Model;

public class AdminService {

    private final SensorsRepository sensorsRepository;
    private final UsersRepository usersRepository;
    private final ComplainsRepository complainsRepository;
    private final MotdRepository motdRepository;

    public AdminService(SensorsRepository sensorsRepository,
                        UsersRepository usersRepository,
                        ComplainsRepository complainsRepository,
                        MotdRepository motdRepository) {
        this.sensorsRepository = sensorsRepository;
        this.usersRepository = usersRepository;
        this.complainsRepository = complainsRepository;
        this.motdRepository = motdRepository;
    }

    public void addAllSensorsToModel(Model model){
        model.addAttribute("sensor", new Sensor());
        model.addAttribute("sensorid", new Sensor());
        model.addAttribute("user", new ApplicationUser());
        model.addAttribute("motd", new Motd());

        model.addAttribute("users", usersRepository.findAll());
        model.addAttribute("motds", motdRepository.findAll());
        model.addAttribute("sensors", sensorsRepository.findAll());
        model.addAttribute("complains", complainsRepository.findAll(););
    }

    public void postSensor(Sensor sensor){
        sensorsRepository.save(new Sensor(sensor));
    }

    public void deleteSensor(String ID){
        if (sensorsRepository.findById(ID).isPresent()){
            sensorsRepository.deleteById(ID);
        }
    }

    public void changeSensorState(String ID){
        if (sensorsRepository.findById(ID).isPresent()){
            Sensor sensor = sensorsRepository.findById(ID).get();
            sensor.setState(!sensor.getState());
            sensorsRepository.save(sensor);
        }
    }

    public void addUser(ApplicationUser user){
        usersRepository.save(new ApplicationUser(user));
    }

    public void deleteUser(String username){
        if (usersRepository.findById(username).isPresent()){
            usersRepository.deleteById(username);
        }
    }

    public void addMotd(Motd motd){
        motdRepository.save(new Motd(motd.getMessage()));
    }

    public void deleteMotd(int ID){
        if (motdRepository.findById(ID).isPresent()){
            motdRepository.deleteById(ID);
        }
    }

    public void deleteComplain(String ID){
        if (complainsRepository.findById(ID).isPresent()){
            complainsRepository.deleteById(ID);
        }
    }


}



