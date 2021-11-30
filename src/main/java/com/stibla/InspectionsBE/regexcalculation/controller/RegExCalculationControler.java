package com.stibla.InspectionsBE.regexcalculation.controller;

import java.util.List;

import com.stibla.InspectionsBE.regexcalculation.model.RegExCalculationDB;
import com.stibla.InspectionsBE.regexcalculation.repository.RegExCalculationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class RegExCalculationControler {

  @Autowired
  private RegExCalculationRepository repository;

  @GetMapping("/regexcalculation")
  List<RegExCalculationDB> all() {
       return repository.findAll(Sort.by("column", "priority"));
  }

  @PostMapping("/regexcalculation") //public ResponseEntity<String>
  RegExCalculationDB newInspection(@RequestBody RegExCalculationDB newRegExCalc) {
    return repository.save(newRegExCalc);
  }

  @PutMapping("/regexcalculation") //public ResponseEntity<String>
  RegExCalculationDB updateInspection(@RequestBody RegExCalculationDB updateRegExCalc) {
    return repository.save(updateRegExCalc);
  }

  @DeleteMapping("/regexcalculation/{id}")
  public void deleteFile(@PathVariable("id") long id) {
    try {
        repository.deleteById(id);
      //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      //return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
    
}
