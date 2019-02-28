package com.mitrais.jpq1.demospringbootcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/index")
public class HelloWorld {

    //Request Parameter ->>>>
    @GetMapping
    public String index(Model model, @RequestParam(required = false) String name){
        model.addAttribute("name", (name!=null)?name:"No Name");
        return "index";
    }

    @GetMapping("hello/{name}")
    public String detail(Model model, @PathVariable String name){
        model.addAttribute("name", (name!=null)?name:"No Name");
        return "index";
    }

    @PostMapping
    public String index(Model model, @RequestBody Payload param){
        model.addAttribute("name", param.getName());
        return "index";
    }

    @PostMapping("hellno")
    public String indexHellno(Model model, @RequestBody Payload param){
        model.addAttribute("name", param.getName()+" hehehe");
        return "index";
    }

    class Payload{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}