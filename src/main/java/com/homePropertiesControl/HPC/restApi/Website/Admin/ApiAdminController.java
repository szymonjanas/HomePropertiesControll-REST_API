package com.homePropertiesControl.HPC.restApi.Website.Admin;

import com.homePropertiesControl.HPC.restApi.Services.AdminService;
import com.homePropertiesControl.HPC.restApi.Models.ApplicationUser;
import com.homePropertiesControl.HPC.restApi.Models.Motd;
import com.homePropertiesControl.HPC.restApi.Models.Sensor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class ApiAdminController {

    private final AdminService adminService;

    public ApiAdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getAllSensors(Model model) {
        adminService.addAllSensorsToModel(model);
        return new ModelAndView("admin");
    }

    @PostMapping("/sensor/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addSensorForm(@ModelAttribute("sensor") Sensor sensor) {
        adminService.postSensor(sensor);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/sensor/addwid")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addSensorFormWithId(@ModelAttribute("sensorid") Sensor sensor) {
        adminService.postSensor(sensor);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping(value = "/sensor/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView deleteSensor(@RequestParam String id, Model model){
        adminService.deleteSensor(id);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping(value = "/sensor/changeState")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView changeStateSensor(@RequestParam String id, Model model){
        adminService.changeSensorState(id);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/user/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addUser(@ModelAttribute("user") ApplicationUser user) {
        adminService.addUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/user/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView deleteUser(@RequestParam String username, Model model){
        adminService.deleteUser(username);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/motd/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView addMotd(@ModelAttribute("motd") Motd motd) {
        adminService.addMotd(motd);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/motd/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView deleteMotd(@RequestParam Integer id, Model model){
        adminService.deleteMotd(id);
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping("/complain/delete")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView deleteComplain(@RequestParam String id, Model model){
        adminService.deleteComplain(id);
        return new ModelAndView("redirect:/admin");
    }
}
