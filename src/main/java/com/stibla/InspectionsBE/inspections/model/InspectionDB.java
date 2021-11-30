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
     private Long nInspectionId;

     private String sInspectionNumber;

     private String sFileId;     

     @Column(columnDefinition = "TEXT")
     private String sPdfContent;

     private String sManufacturerName;

     private String sManufacturerCode;

     private String sModelCode;

     private String sSubModelCode;

     private Double nAxPaintCoef;

     private Double nDiscount;

     private Double nRatePaint1;

     private Double nRate1;

     private Double nRate2;

     private Double nRate3;

     private Double nDiscountNh;

     private Double nDiscountSpares;

  public String getsManufacturerName() {
    return this.sManufacturerName;
  }

  public void setsManufacturerName(String sManufacturerName) {
    this.sManufacturerName = sManufacturerName;
  }

  public String getsManufacturerCode() {
    return this.sManufacturerCode;
  }

  public void setsManufacturerCode(String sManufacturerCode) {
    this.sManufacturerCode = sManufacturerCode;
  }

  public String getsModelCode() {
    return this.sModelCode;
  }

  public void setsModelCode(String sModelCode) {
    this.sModelCode = sModelCode;
  }

  public Double getnDiscount() {
    return this.nDiscount;
  }

  public void setnDiscount(Double nDiscount) {
    this.nDiscount = nDiscount;
  }

  public Double getnRatePaint1() {
    return this.nRatePaint1;
  }

  public void setnRatePaint1(Double nRatePaint1) {
    this.nRatePaint1 = nRatePaint1;
  }

  public Double getnRate1() {
    return this.nRate1;
  }

  public void setnRate1(Double nRate1) {
    this.nRate1 = nRate1;
  }

  public Double getnRate2() {
    return this.nRate2;
  }

  public void setnRate2(Double nRate2) {
    this.nRate2 = nRate2;
  }

  public Double getnRate3() {
    return this.nRate3;
  }

  public void setnRate3(Double nRate3) {
    this.nRate3 = nRate3;
  }

  public Double getnDiscountNh() {
    return this.nDiscountNh;
  }

  public void setnDiscountNh(Double nDiscountNh) {
    this.nDiscountNh = nDiscountNh;
  }

  public Double getnDiscountSpares() {
    return this.nDiscountSpares;
  }

  public void setnDiscountSpares(Double nDiscountSpares) {
    this.nDiscountSpares = nDiscountSpares;
  }


  public Double getnAxPaintCoef() {
    return this.nAxPaintCoef;
  }

  public void setnAxPaintCoef(Double nAxPaintCoef) {
    this.nAxPaintCoef = nAxPaintCoef;
  }

  public String getsSubModelCode() {
    return this.sSubModelCode;
  }

  public void setsSubModelCode(String sSubModelCode) {
    this.sSubModelCode = sSubModelCode;
  }

  public Long getnInspectionId() {
    return this.nInspectionId;
  }

  public void setnInspectionId(Long nInspectionId) {
    this.nInspectionId = nInspectionId;
  }

  public String getsInspectionNumber() {
    return this.sInspectionNumber;
  }


  public InspectionDB() {
    }
  
    public InspectionDB(String sInspectionNumber) {
      this.sInspectionNumber = sInspectionNumber;
    }

    public void SetsInspectionNumber(String sInspectionNumber) {
      this.sInspectionNumber = sInspectionNumber;
    }

    
    public String getsFileId() {
      return sFileId;
    }
  
    public void setsFileId(String sFileId){
      this.sFileId = sFileId;
    }

     public String getsPdfContent() {
       return sPdfContent;
     }
   
     public void setsPdfContent(String sPdfContent){
       this.sPdfContent = sPdfContent;
     }

}
