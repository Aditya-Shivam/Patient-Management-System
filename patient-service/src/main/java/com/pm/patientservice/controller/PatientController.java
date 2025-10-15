package com.pm.patientservice.controller;

import com.pm.patientservice.Service.PatientService;
import com.pm.patientservice.dto.PatientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("")
    ResponseEntity<List<PatientResponseDTO>> getAllPatients(){
        return new ResponseEntity<>(patientService.getAllPatients(), HttpStatus.OK);
    }
}
