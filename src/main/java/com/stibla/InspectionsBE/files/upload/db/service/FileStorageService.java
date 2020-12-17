package com.stibla.InspectionsBE.files.upload.db.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.stibla.InspectionsBE.files.upload.db.model.FileDB;
import com.stibla.InspectionsBE.files.upload.db.repository.FileDBRepository;

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
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
