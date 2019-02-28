package com.mitrais.jpq1.demospringbootcore.controller;

import com.mitrais.jpq1.demospringbootcore.Service.TraineeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trainer")
public class TraineeWebController {
    private TraineeService traineeService;

    public TraineeWebController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping
    public String getAllStudent(Model model){
        model.addAttribute("items",traineeService.findAllStudents());
        return "trainee";
    }
}
