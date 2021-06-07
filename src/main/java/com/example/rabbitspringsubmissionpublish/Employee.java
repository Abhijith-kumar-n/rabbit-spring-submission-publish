package com.example.rabbitspringsubmissionpublish;

public class Employee {
    private int id;
    private String EmpName;
    private String EmpDept;
    private String EmpBGrp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getEmpDept() {
        return EmpDept;
    }

    public void setEmpDept(String empDept) {
        EmpDept = empDept;
    }

    public String getEmpBGrp() {
        return EmpBGrp;
    }

    public void setEmpBGrp(String empBGrp) {
        EmpBGrp = empBGrp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", EmpName='" + EmpName + '\'' +
                ", EmpDept='" + EmpDept + '\'' +
                ", EmpBGrp='" + EmpBGrp + '\'' +
                '}';
    }
}
