package com.stibla.InspectionsBE.files.upload.db.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.stibla.InspectionsBE.files.upload.db.model.FileDB;
import com.stibla.InspectionsBE.files.upload.db.repository.FileDBRepository;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@Service
public class FileStorageService {

  //private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file, Long inspectionId) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), inspectionId);
    //logger.info("this is a info message inspectionId je " + inspectionId);
    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }

  public Stream<FileDB> getFilesByInspectionId(long inspectionId) {
    FileDB file = new FileDB();
    file.setN_inspection_id(inspectionId);
    Example<FileDB> fileExample = Example.of(file);
    return fileDBRepository.findAll(fileExample).stream();
  }

  public void deleteById(String id) {
    fileDBRepository.deleteById(id);
  }

  //public void updatePdfText(String id, String pdfText) {
    //fileDBRepository.updatePdfText(id, pdfText);
  //}

  public void Save(FileDB FileDB) {
    fileDBRepository.save(FileDB);
  }
}
