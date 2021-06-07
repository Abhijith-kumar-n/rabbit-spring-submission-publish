package com.example.rabbitspringsubmissionpublish;


import com.example.rabbitspringsubmissionpublish.configuration.rabbitconfiguration;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @GetMapping("/")
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
