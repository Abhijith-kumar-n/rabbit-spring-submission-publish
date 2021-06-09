package com.example.rabbitspringsubmissionpublish;


import com.example.rabbitspringsubmissionpublish.Repository.UserRepository;
import com.example.rabbitspringsubmissionpublish.configuration.rabbitconfiguration;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.slf4j.Logger;

@Controller
public class EmployeeController {

    private final Logger logger= LoggerFactory.getLogger(EmployeeController.class);
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
        logger.debug("<< Received Login details : "+username);
        List<User> user=userRepository.findByUsername(username);
        if (user.size()==0){
            logger.debug(">> No User Available with username : "+username);
            return "loginfailed";
        }
        else {
            if (user.get(0).getPassword().equals(password)) {
                logger.debug(">> Logged IN Successfully........");
                System.out.println("Logged In as User "+username);
                return "Submission";
            } else {
                logger.debug(">> Wrong Password");
                return "loginfailed";
            }
        }
    }

    @GetMapping("/register_page")
    public String register_a(){
        return "register";
    }

    @PostMapping("/register")
    public String Addtomydb(@RequestParam("username") String username,@RequestParam("password") String password,ModelMap map){

        User user=new User();
        Random rnd=new Random();
        List<User> allusers=userRepository.findAll();
        int sizeofusers=allusers.size();
        user.setId(sizeofusers+1);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        logger.debug(">> Registered with username : "+username);
        return "loginform";
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

        Model model= new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Object getAttribute(String attributeName) {
                return null;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
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
        model.addAttribute("header","Add");
        model.addAttribute("main",emp);
        System.out.println(model);
        logger.debug(">> Adding Employee with id : "+id);
        rabbitTemplate.convertAndSend(rabbitconfiguration.EXCHANGE,rabbitconfiguration.ROUTINGKEY,emp);
        logger.debug("<< Sending Employee to Rabbit MQ");
        return "Addedform";
    }
}
