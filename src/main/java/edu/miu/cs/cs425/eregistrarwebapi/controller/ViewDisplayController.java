package edu.miu.cs.cs425.eregistrarwebapi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewDisplayController {

    @GetMapping(value = {"/", "home", "welcome"})
    public String home() {
        return "home";
    }
    @GetMapping("/index")
    public String studentsIndex(){
        return "student/index";
    }
    @GetMapping("/add")
    public String studentAdd(){
        return "student/add";
    }
    @GetMapping("/edit")
    public String studentEdit(@RequestParam("id")Long id){
        return "student/edit";
    }
    @GetMapping("/delete")
    public String studentDelete(@RequestParam("id")Long id){
        return "student/delete";
    }
}
