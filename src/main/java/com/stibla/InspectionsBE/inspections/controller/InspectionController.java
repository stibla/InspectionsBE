package com.stibla.InspectionsBE.inspections.controller;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stibla.InspectionsBE.files.upload.db.model.FileDB;
import com.stibla.InspectionsBE.files.upload.db.service.FileStorageService;
import com.stibla.InspectionsBE.inspections.model.InspectionDB;
import com.stibla.InspectionsBE.inspections.repository.InspectionRepository;
import com.stibla.InspectionsBE.pdf.PdfGetText;
import com.stibla.InspectionsBE.regexcalculation.model.RegExCalculationDB;
import com.stibla.InspectionsBE.regexcalculation.repository.RegExCalculationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.beanutils.PropertyUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
/*import java.lang.System;

private static final Logger logger = LoggerFactory.getLogger(FileController.class);
logger.info("this is a info message " + id + PdfGetText.getText(fileDB.getData()));
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.stibla.InspectionsBE.files.upload.db.message.ResponseMessage;
import com.stibla.InspectionsBE.files.upload.db.service.FileStorageService;
import com.stibla.InspectionsBE.files.upload.db.message.ResponseFile;
import com.stibla.InspectionsBE.files.upload.db.model.FileDB;
import com.stibla.InspectionsBE.pdf.PdfGetText;*/

@RestController
@CrossOrigin("http://localhost:4200")
public class InspectionController {
  //private static final Logger logger = LoggerFactory.getLogger(InspectionController.class);

  @Autowired
  private InspectionRepository repository;

  @Autowired
  private FileStorageService fileStorageService;

  @Autowired
  private RegExCalculationRepository regExRepository;

  @GetMapping("/inspections")
  List<InspectionDB> all() {
    return repository.findAll();
  }

  @GetMapping("/inspections/{id}")
  Optional<InspectionDB> inspectionDetail(@PathVariable Long id) {
    return repository.findById(id);
  }

  @PostMapping("/inspections") // public ResponseEntity<String>
  InspectionDB newInspection(@RequestBody InspectionDB newInspection) {
    return repository.save(newInspection);
  }

  @PutMapping("/inspections") // public ResponseEntity<String>
  InspectionDB updateInspection(@RequestBody InspectionDB updateInspection) {
    return repository.save(updateInspection);
  }

  @PutMapping("/inspections/{idInspection}/getpdftext/{idFile}")
  InspectionDB getpdftext(@PathVariable("idInspection") long idInspection, @PathVariable("idFile") String idFile) {

    String pdfContent = "";

    try {
      FileDB fileDB = fileStorageService.getFile(idFile);
      pdfContent = PdfGetText.getText(fileDB.getData());
    } catch (Exception e) {
      System.out.println(e);
    }
    
    Optional<InspectionDB> inspectionBDopt = repository.findById(idInspection);
    InspectionDB inspectionDB = inspectionBDopt.get();
    inspectionDB.setsPdfContent(pdfContent);
    
    List<String> tempListColumn = regExRepository.findAllregexcalculation();
    
    for (String tempColumn : tempListColumn) {
      List<RegExCalculationDB> tempListRegEx = regExRepository.findRegexcalculationByColumn(tempColumn);
      for (RegExCalculationDB tempRegExCalculationDB : tempListRegEx) {
        
        try {
          if (tempRegExCalculationDB.getType().equalsIgnoreCase("String")) {     
            //logger.info("this is a info message " + tempColumn + tempRegExCalculationDB.getType() + tempRegExCalculationDB.getColumn() + tempRegExCalculationDB.getRegex() /*+ pdfContent*/);
            PropertyUtils.setSimpleProperty(inspectionDB, tempColumn, null); //nulujem ak by nieco bolo v databaze       
            
            Matcher matcher = Pattern.compile(tempRegExCalculationDB.getRegex()).matcher(pdfContent);
            
            if (matcher.find()) {         
              //logger.info("this is a info message " + matcher.group(1));     
              PropertyUtils.setSimpleProperty(inspectionDB, tempColumn, matcher.group(1));
              break;
            }
          }

          if (tempRegExCalculationDB.getType().equalsIgnoreCase("Number")) {
            PropertyUtils.setSimpleProperty(inspectionDB, tempColumn, null); //nulujem ak by nieco bolo v databaze
            Matcher matcher = Pattern.compile(tempRegExCalculationDB.getRegex()).matcher(pdfContent);
            
            if (matcher.find()) {
              try {
                PropertyUtils.setSimpleProperty(inspectionDB, tempColumn, Double.parseDouble(matcher.group(1)));
                break;
              } catch (NumberFormatException nfe) {
                System.out.println(nfe);
              }
            }
          }
        } catch (Exception e) {
          
          System.out.println(e);
        }
        //break;
      }
    }
    return repository.save(inspectionDB);
  }

}
