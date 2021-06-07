package com.example.rabbitspringsubmissionpublish;


import com.example.rabbitspringsubmissionpublish.Repository.UserRepository;
import com.example.rabbitspringsubmissionpublish.configuration.rabbitconfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    public RabbitTemplate rabbitTemplate;
    @Autowired
    public UserRepository userRepository;
    @GetMapping("/")
    public String login(){
        return "loginform";
    }
    @PostMapping("/login_validate")
    public String validate_login(@RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 ModelMap map){

        List<User> user=userRepository.findByUsername(username);
        if (user.size()==0){
            return "loginfailed";
        }
        else {
            if (user.get(0).getPassword().equals(password)) {
                System.out.println("Logged In as User "+username);
                return "Submission";
            } else {
                return "loginfailed";
            }
        }
    }

    @GetMapping("/submit")
    public String GetSubmissionform(){
        return "Submission";
    }
    @PostMapping("Add")
    public String SubmitForm(@RequestParam("id") int id,
                             @RequestParam("EmpName") String EmpName,
                             @RequestParam("EmpDept") String EmpDept,
                             @RequestParam("EmpBGrp") String EmpBGrp,
                             ModelMap map){
        map.put("id",id);
        map.put("EmpName",EmpName);
        map.put("EmpDept",EmpDept);
        map.put("EmpBGrp",EmpBGrp);
        Employee emp=new Employee();
        emp.setId(id);
        emp.setEmpName(EmpName);
        emp.setEmpDept(EmpDept);
        emp.setEmpBGrp(EmpBGrp);
        System.out.println(emp);
        rabbitTemplate.convertAndSend(rabbitconfiguration.EXCHANGE,rabbitconfiguration.ROUTINGKEY,emp);
        return "Addedform";
    }
}
