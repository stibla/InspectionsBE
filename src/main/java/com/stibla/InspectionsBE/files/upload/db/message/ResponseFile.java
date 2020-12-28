package com.stibla.InspectionsBE.files.upload.db.message;

public class ResponseFile {
  private String id;
  private String name;
  private String url;
  private String type;
  private long size;
  private long n_inspection_id;

  public ResponseFile(String id, String name, String url, String type, long size, long n_inspection_id) {
    this.id = id;
    this.name = name;
    this.url = url;
    this.type = type;
    this.size = size;
    this.n_inspection_id = n_inspection_id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public long getN_inspection_id() {
    return n_inspection_id;
  }

  public void setN_inspection_id(long n_inspection_id) {
    this.n_inspection_id = n_inspection_id;
  }

}
