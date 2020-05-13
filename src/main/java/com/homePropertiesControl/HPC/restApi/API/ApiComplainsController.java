package com.homePropertiesControl.HPC.restApi.API;

import com.homePropertiesControl.HPC.restApi.Repository.ComplainsRepository;
import com.homePropertiesControl.HPC.restApi.Models.Complains;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/complains")
public class ApiComplainsController {

    private final ComplainsRepository complainsRepository;

    public ApiComplainsController(ComplainsRepository complainsRepository) {
        this.complainsRepository = complainsRepository;
    }

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
