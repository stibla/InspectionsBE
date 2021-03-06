package com.stibla.InspectionsBE.files.upload.db.model;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;
  private String name;
  private String type;
  private long n_inspection_id;

  @Lob
  private byte[] data;

  //@Column(columnDefinition = "TEXT")
  //private String pdfContent;

  public FileDB() {
  }

  public FileDB(String name, String type, byte[] data, long n_inspection_id) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.n_inspection_id = n_inspection_id;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  /*public String getPdfContent() {
    return pdfContent;
  }

  public void setPdfContent(String pdfContent){
    this.pdfContent = pdfContent;
  }*/

  public long getN_inspection_id() {
    return n_inspection_id;
  }

  public void setN_inspection_id(long n_inspection_id){
    this.n_inspection_id = n_inspection_id;
  }

}
