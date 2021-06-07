package com.example.rabbitspringsubmissionpublish;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    /*@GetMapping("/")
    public String GetSubmissionform(){
        return "Submission";
    }*/
    @GetMapping("/")
    public String showForm(Model model) {
        Employee emp = new Employee();
        //List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");

        model.addAttribute("emp", emp);
        //model.addAttribute("professionList", professionList);

        return "Submission";
    }
    @PostMapping("Add")
    public String SubmitForm(@ModelAttribute("emp") Employee emp){
        System.out.println(emp);
        return "Addedform";
    }
}
