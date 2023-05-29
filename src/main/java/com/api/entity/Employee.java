package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Employee {

    @Id
    private Float EmployeeID;
    private String FullName;
    private String JobTitle;
    private String Department;
    private String BusinessUnit;
    private String Gender;
    private String Ethnicity;
    private Integer Age;
    private Date HiringDate;
    private Double AnnualSalary;
    private Double Bonus;
    private String Country;
    private String City;
    private Date ExitDate;


    public Employee(Float employeeID, String fullName, String jobTitle, String department, String businessUnit, String gender, String ethnicity, Integer age, Date hiringDate, Double annualSalary, Double bonus, String country, String city, Date exitDate) {
        EmployeeID = employeeID;
        FullName = fullName;
        JobTitle = jobTitle;
        Department = department;
        BusinessUnit = businessUnit;
        Gender = gender;
        Ethnicity = ethnicity;
        Age = age;
        HiringDate = hiringDate;
        AnnualSalary = annualSalary;
        Bonus = bonus;
        Country = country;
        City = city;
        ExitDate = exitDate;
    }
    public Employee() {
    }

    public Float getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(Float employeeID) {
        EmployeeID = employeeID;
    }



    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getBusinessUnit() {
        return BusinessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        BusinessUnit = businessUnit;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEthnicity() {
        return Ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        Ethnicity = ethnicity;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public Date getHiringDate() {
        return HiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        HiringDate = hiringDate;
    }

    public Double getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        AnnualSalary = annualSalary;
    }

    public Double getBonus() {
        return Bonus;
    }

    public void setBonus(Double bonus) {
        Bonus = bonus;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public Date getExitDate() {
        return ExitDate;
    }

    public void setExitDate(Date exitDate) {
        ExitDate = exitDate;
    }

}
