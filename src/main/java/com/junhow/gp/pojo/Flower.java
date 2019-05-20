package com.junhow.gp.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String phylumname;

    private String classname;

    private String ordername;

    private String familyname;

    private String genusname;

    private String speciesname;

    private String subspeciesname;

    private String name;

    private String latinname;

    private String description;

    private Integer grade;

    private String valid;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_create")
    private Date gmtCreate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return phylumname
     */
    public String getPhylumname() {
        return phylumname;
    }

    /**
     * @param phylumname
     */
    public void setPhylumname(String phylumname) {
        this.phylumname = phylumname;
    }

    /**
     * @return classname
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname
     */
    public void setClassname(String classname) {
        this.classname = classname;
    }

    /**
     * @return ordername
     */
    public String getOrdername() {
        return ordername;
    }

    /**
     * @param ordername
     */
    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    /**
     * @return familyname
     */
    public String getFamilyname() {
        return familyname;
    }

    /**
     * @param familyname
     */
    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    /**
     * @return genusname
     */
    public String getGenusname() {
        return genusname;
    }

    /**
     * @param genusname
     */
    public void setGenusname(String genusname) {
        this.genusname = genusname;
    }

    /**
     * @return speciesname
     */
    public String getSpeciesname() {
        return speciesname;
    }

    /**
     * @param speciesname
     */
    public void setSpeciesname(String speciesname) {
        this.speciesname = speciesname;
    }

    /**
     * @return subspeciesname
     */
    public String getSubspeciesname() {
        return subspeciesname;
    }

    /**
     * @param subspeciesname
     */
    public void setSubspeciesname(String subspeciesname) {
        this.subspeciesname = subspeciesname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return latinname
     */
    public String getLatinname() {
        return latinname;
    }

    /**
     * @param latinname
     */
    public void setLatinname(String latinname) {
        this.latinname = latinname;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return grade
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * @param grade
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * @return valid
     */
    public String getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(String valid) {
        this.valid = valid;
    }

    /**
     * @return gmt_create
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}