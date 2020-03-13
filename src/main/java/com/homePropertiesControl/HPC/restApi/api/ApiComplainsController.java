package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Repository.ComplainsRepository;
import com.homePropertiesControl.HPC.restApi.model.Complains;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/complains")
public class ApiComplainsController {

    @Autowired
    private ComplainsRepository complainsRepository;

    @PutMapping
    public String putComplainToDatabase(@RequestBody String complain){
        JSONObject jsonObject = new JSONObject(complain);
        JSONObject response = new JSONObject();
        String id = UUID.randomUUID().toString();
        complainsRepository.save(new Complains( id,
                                                jsonObject.getString("type"),
                                                jsonObject.getString("message") ));
        response.put("message", "Message recived correctly!\nThank you for your time!");
        return response.toString();
    }

}
