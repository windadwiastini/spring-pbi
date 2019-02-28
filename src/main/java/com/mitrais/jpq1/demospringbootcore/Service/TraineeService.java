package com.mitrais.jpq1.demospringbootcore.Service;

import com.mitrais.jpq1.demospringbootcore.model.Trainee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TraineeService {

    private List<Trainee> trainees = new ArrayList<>(
            Arrays.asList(
                    new Trainee(1, "Denny", 21),
                    new Trainee(2, "Winda", 23),
                    new Trainee(3, "Robert", 23),
                    new Trainee(4, "Reni", 24),
                    new Trainee(5, "Rafif", 23),
                    new Trainee(6, "Dimas", 22),
                    new Trainee(7, "Lukas", 27)
            )
    );

    public List<Trainee> findAllStudents() {
        return trainees;
    }

    public Optional<Trainee> findById(int id) {
        return trainees.stream().filter(trainee -> trainee.getId() == id).findFirst();
    }

    public void create(Trainee trainee) {
        this.trainees.add(trainee);
    }

    public void update(int id, Trainee trainee){
        Trainee tr1=trainees.stream().filter(std->std.getId().equals(id)).findFirst().orElse(null);
        if(tr1!=null) Collections.replaceAll(trainees,tr1,trainee);
    }

    public void patch(int id, Trainee trainee){
        trainees.stream().filter(std->std.getId().equals(id)).forEach(std->{
            if(trainee.getId()!=null)std.setId(trainee.getId());
            if(trainee.getAge()!=null)std.setAge(trainee.getAge());
            if(trainee.getName()!=null)std.setName(trainee.getName());
        });
    }

    public void delete(int id){
        trainees.removeIf(trainee -> trainee.getId().equals(id));
    }

}
