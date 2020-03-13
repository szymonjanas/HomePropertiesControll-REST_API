package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Repository.MotdRepository;
import com.homePropertiesControl.HPC.restApi.model.Motd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/api/motd")
public class ApiMotdController {

    @Autowired
    private MotdRepository motdRepository;

    @GetMapping
    public String getMotd(){
        ArrayList<Integer> listOfIds = new ArrayList<>();
        Iterable<Motd> iterList = motdRepository.findAll();
        for (Motd motd:iterList){
            listOfIds.add(motd.getId());
        }
        int random = new Random().nextInt((int) listOfIds.size() - 1);
        int value = listOfIds.get(random);
         if(motdRepository.findById(value).isPresent()){
             return motdRepository.findById(value).get().getMessage();
         }
         return "Server error!";
    }
}
