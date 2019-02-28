package com.mitrais.jpq1.demospringbootcore.controller;

import com.mitrais.jpq1.demospringbootcore.Service.TraineeService;
import com.mitrais.jpq1.demospringbootcore.model.Trainee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
public class TraineeController {
    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    /**
     * @return all student in database
     */
    @GetMapping
    public List<Trainee> findAllStudents(){
        return traineeService.findAllStudents();
    }

    /**
     * @param id
     * @return Get user by ID
     */
    @GetMapping("{id}")
    public Trainee findById(@PathVariable Integer id){
        Optional<Trainee> student= traineeService.findById(id);
        return student.orElse(new Trainee());
    }

    @PostMapping
    public String create(@RequestBody Trainee trainee){
        traineeService.create(trainee);
        return "User created!";
    }

    @PutMapping("{id}")
    public String put(@PathVariable Integer id, @RequestBody Trainee trainee){
        traineeService.update(id,trainee);
        return "User Updated!";
    }

    @PatchMapping("{id}")
    public String patch(@PathVariable Integer id,@RequestBody Trainee trainee){
        traineeService.patch(id,trainee);
        return "User Patched!";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){
        traineeService.delete(id);
        return "User deleted!";
    }
}
