package com.homePropertiesControl.HPC.restApi.api;

import com.homePropertiesControl.HPC.restApi.Repository.SensorsRepository;
import com.homePropertiesControl.HPC.restApi.Repository.UsersRepository;
import com.homePropertiesControl.HPC.restApi.auth.ApplicationUser;
import com.homePropertiesControl.HPC.restApi.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ApiAdminController {

        @Autowired
        private SensorsRepository sensorsRepository;

        @Autowired
        private UsersRepository usersRepository;

        @GetMapping
        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        public ModelAndView getAllSensors(Model model) {
            Iterable<Sensor> sensorsList = sensorsRepository.findAll();
            Iterable<ApplicationUser> usersList = usersRepository.findAll();
            model.addAttribute("sensors", sensorsList);
            model.addAttribute("sensor", new Sensor());
            model.addAttribute("user", new ApplicationUser());
            model.addAttribute("users", usersList);
            return new ModelAndView("admin");
        }

        @PostMapping("/sensor/add")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        public ModelAndView addSensorForm(@ModelAttribute("sensor") Sensor sensor) {
            sensorsRepository.save(new Sensor(sensor.getName(), sensor.getType(), sensor.getLocation()));
            return new ModelAndView("redirect:/admin");
        }

        @PostMapping(value = "/sensor/delete")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        public ModelAndView deleteSensor(@RequestParam String id, Model model){
            if (sensorsRepository.findById(id).isPresent()){
                sensorsRepository.deleteById(id);
            }
            return new ModelAndView("redirect:/admin");
        }

        @PostMapping("/user/add")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        public ModelAndView addUser(@ModelAttribute("user") ApplicationUser user) {
            ApplicationUser applicationUser = new ApplicationUser(user.getUsername(), user.getPassword(), user.getRole());
            usersRepository.save(applicationUser);
            return new ModelAndView("redirect:/admin");
        }

        @PostMapping("/user/delete")
        @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
        public ModelAndView deleteUser(@RequestParam String username, Model model){
            if (usersRepository.findById(username).isPresent()){
                usersRepository.deleteById(username);
            }
            return new ModelAndView("redirect:/admin");
        }
}
