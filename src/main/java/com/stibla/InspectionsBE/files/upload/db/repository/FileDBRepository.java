package com.stibla.InspectionsBE.files.upload.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stibla.InspectionsBE.files.upload.db.model.FileDB;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
    //@Modifying
    //@Query("update FileDB u set u.pdfContent = :pdfText where u.id = :id")
    //void updatePdfText(@Param(value = "id") String id, @Param(value = "pdfText") String pdfText);
}
