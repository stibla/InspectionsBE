package com.stibla.InspectionsBE.inspections.controller;

import com.stibla.InspectionsBE.inspections.model.InspectionDB;
import java.util.List;
import java.util.Optional;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//private static final Logger logger = LoggerFactory.getLogger(FileController.class);
//logger.info("this is a info message " + id + PdfGetText.getText(fileDB.getData()));

/*import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;*/

import com.stibla.InspectionsBE.inspections.repository.InspectionRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.stibla.InspectionsBE.files.upload.db.message.ResponseMessage;*/
/*import com.stibla.InspectionsBE.files.upload.db.service.FileStorageService;
import com.stibla.InspectionsBE.files.upload.db.message.ResponseFile;

import com.stibla.InspectionsBE.files.upload.db.model.FileDB;
import com.stibla.InspectionsBE.pdf.PdfGetText;*/

@RestController
@CrossOrigin("http://localhost:4200")
public class InspectionController {

  @Autowired
  private InspectionRepository repository;

  // private FileStorageService storageService;

  @GetMapping("/inspections")
  List<InspectionDB> all() {
    return repository.findAll();
  }

  @GetMapping("/inspections/{id}")
  Optional<InspectionDB> inspectionDetail(@PathVariable Long id) {
    return repository.findById(id) ;
  }

  @PostMapping("/inspections") //public ResponseEntity<String>
  InspectionDB newInspection(@RequestBody InspectionDB newInspection) {
    return repository.save(newInspection);
  }

  @PutMapping("/inspections") //public ResponseEntity<String>
  InspectionDB updateInspection(@RequestBody InspectionDB newInspection) {
    return repository.save(newInspection);
  }

  
  /*
   * @PostMapping("/upload") public ResponseEntity<ResponseMessage>
   * uploadFile(@RequestParam("file") MultipartFile file) { String message = "";
   * try { storageService.store(file);
   * 
   * message = "Uploaded the file successfully: " + file.getOriginalFilename();
   * return ResponseEntity.status(HttpStatus.OK).body(new
   * ResponseMessage(message)); } catch (Exception e) { message =
   * "Could not upload the file: " + file.getOriginalFilename() + "!"; return
   * ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new
   * ResponseMessage(message)); } }
   */
   /* @GetMapping("/inspections")
  public ResponseEntity<String> getListInspection() {
  
     * List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
     * String fileDownloadUri =
     * ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/").path(
     * dbFile.getId()) .toUriString();
     * 
     * return new ResponseFile(dbFile.getId(), dbFile.getName(), fileDownloadUri,
     * dbFile.getType(), dbFile.getData().length); }).collect(Collectors.toList());
     * 
     * return ResponseEntity.status(HttpStatus.OK).body(files);
     
    String message = "";
    message = "Update the file successfully" + message;
    repository.save(new InspectionDB(message));

    return ResponseEntity.status(HttpStatus.OK).body(message);
  }*/

  /*
   * @GetMapping("/files/{id}") public ResponseEntity<byte[]>
   * getFile(@PathVariable String id) { FileDB fileDB =
   * storageService.getFile(id); // logger.info("this is a info message " + id +
   * PdfGetText.getText(new File( //
   * ("C:\\Users\\Administrator\\Downloads\\application.pdf"))) ); return
   * ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
   * "attachment; filename=\"" + fileDB.getName() + "\"") .body(fileDB.getData());
   * }
   * 
   * @DeleteMapping("/files/{id}") public ResponseEntity<HttpStatus>
   * deleteFile(@PathVariable("id") String id) { try {
   * storageService.deleteById(id); return new
   * ResponseEntity<>(HttpStatus.NO_CONTENT); } catch (Exception e) { return new
   * ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); } }
   * 
   * @PutMapping("/files/{id}") public ResponseEntity<ResponseMessage>
   * updateFile(@PathVariable("id") String id) {
   * 
   * String message = ""; try { FileDB fileDB = storageService.getFile(id);
   * message = PdfGetText.getText(fileDB.getData());
   * fileDB.setPdfContent(message); storageService.Save(fileDB);
   * //storageService.updatePdfText(id, message); //String str =
   * "Nom for 3 Oscar, dom for 234235 Oscars"; Pattern pattern =
   * Pattern.compile("CENA/TR (.*?)  EUR/HOD"); Matcher matcher =
   * pattern.matcher(message); while (matcher.find()) {
   * System.out.println(matcher.group(1)); }
   * 
   * message = "Update the file successfully" + message; return
   * ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message)); }
   * catch (Exception e) { message = "Could not update the file" + message; return
   * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new
   * ResponseMessage(message)); }
   * 
   * }
   */

}