package com.api.controller;

import com.api.entity.Employee;
import com.api.helper.Helper;
import com.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService EmployeeService;

    @PostMapping("/Employee/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        if (Helper.checkExcelFormat(file)) {
            //true

            this.EmployeeService.save(file);

            return ResponseEntity.ok(Map.of("message", "File is uploaded and data is saved to newdb"));


        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file ");
    }


    @GetMapping("/Employee")
    public List<Employee> getAllEmployee() {
        return this.EmployeeService.getAllEmployees();
    }

}
