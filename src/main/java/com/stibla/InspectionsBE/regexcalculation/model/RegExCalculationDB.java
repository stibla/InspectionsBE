package com.stibla.InspectionsBE.regexcalculation.model;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "regexcalculation")
public class RegExCalculationDB {

    @Override
    public String toString() {
        return "{" +
            " regExcCalculationId='" + getRegExCalculationId() + "'" +
            ", column='" + getColumn() + "'" +
            ", priority='" + getPriority() + "'" +
            ", regex='" + getRegex() + "'" +
            ", type='" + getType() + "'" +
            ", mandatory='" + isMandatory() + "'" +
            "}";
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="n_regexcalculation_id")
    private Long regExCalculationId;

    @Column(name="s_COLUMN")
    private String column;

    @Column(name="n_PRIORITY")
    private Long priority;

    @Column(name="s_REGEX")
    private String regex;

    @Column(name="s_TYPE")
    private String type;

    @Column(name="b_MANDATORY")
    private Boolean mandatory;
  
    public RegExCalculationDB() {
    }

    public RegExCalculationDB(Long regExCalculationId) {
        this.regExCalculationId = regExCalculationId;
    }

    public RegExCalculationDB(Long regExCalculationId, String column, Long priority, String regex, String type, Boolean mandatory) {
        this.regExCalculationId = regExCalculationId;
        this.column = column;
        this.priority = priority;
        this.regex = regex;
        this.type = type;
        this.mandatory = mandatory;
    }

    public Long getRegExCalculationId() {
        return this.regExCalculationId;
    }

    public void setRegExCalculationId(Long regExCalculationId) {
        this.regExCalculationId = regExCalculationId;
    }

    public String getColumn() {
        return this.column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Long getPriority() {
        return this.priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public String getRegex() {
        return this.regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isMandatory() {
        return this.mandatory;
    }

    public Boolean getMandatory() {
        return this.mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }   
 
}