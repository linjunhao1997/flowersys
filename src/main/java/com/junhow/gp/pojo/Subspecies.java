package com.junhow.gp.pojo;

import java.util.Date;
import javax.persistence.*;

public class Subspecies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer speciesid;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    private String title;

    @Column(name = "parent_id")
    private String parentId;

    private String latiname;

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
     * @return speciesid
     */
    public Integer getSpeciesid() {
        return speciesid;
    }

    /**
     * @param speciesid
     */
    public void setSpeciesid(Integer speciesid) {
        this.speciesid = speciesid;
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

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return parent_id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * @return latiname
     */
    public String getLatiname() {
        return latiname;
    }

    /**
     * @param latiname
     */
    public void setLatiname(String latiname) {
        this.latiname = latiname;
    }
}