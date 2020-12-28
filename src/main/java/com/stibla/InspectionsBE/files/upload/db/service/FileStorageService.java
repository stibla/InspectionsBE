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

@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file, Long n_inspection_id) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes(), n_inspection_id);

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }

  public Stream<FileDB> getFilesByInspectionId(long n_inspection_id) {
    FileDB file = new FileDB();
    file.setN_inspection_id(n_inspection_id);
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
