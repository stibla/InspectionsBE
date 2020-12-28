package com.stibla.InspectionsBE.inspections.model;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "inspections")
public class InspectionDB {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     //@Column(name="N_INSPECTION_ID")
     private Long n_inspection_id;

     private String s_inspection_number;

     private String s_file_id;     

     @Column(columnDefinition = "TEXT")
     private String s_pdfContent;

     public InspectionDB() {
    }
  
    public InspectionDB(String s_inspection_number) {
      this.s_inspection_number = s_inspection_number;
    }
  
    public Long getN_inspection_id() {
      return n_inspection_id;
    }
  
    public String getS_inspection_number() {
      return s_inspection_number;
    }
  
    public void setS_inspection_number(String s_inspection_number) {
      this.s_inspection_number = s_inspection_number;
    }

    public String getS_file_id() {
      return s_file_id;
    }
  
    public void setS_file_id(String s_file_id){
      this.s_file_id = s_file_id;
    }

     public String getS_pdfContent() {
       return s_pdfContent;
     }
   
     public void setS_pdfContent(String s_pdfContent){
       this.s_pdfContent = s_pdfContent;
     }
}
