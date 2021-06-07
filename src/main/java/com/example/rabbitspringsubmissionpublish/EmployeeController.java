package com.example.rabbitspringsubmissionpublish;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
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

        Employee emp=new Employee();
        emp.setId(id);
        emp.setEmpName(EmpName);
        emp.setEmpDept(EmpDept);
        emp.setEmpBGrp(EmpBGrp);
        System.out.println(emp);
        return "Addedform";
    }
}
