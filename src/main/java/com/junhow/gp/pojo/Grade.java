package com.junhow.gp.pojo;

import java.util.Date;
import javax.persistence.*;

public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ip;

    private Integer grade;

    private Integer flowerid;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    private String latinname;

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
     * @return ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip
     */
    public void setIp(String ip) {
        this.ip = ip;
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
     * @return flowerid
     */
    public Integer getFlowerid() {
        return flowerid;
    }

    /**
     * @param flowerid
     */
    public void setFlowerid(Integer flowerid) {
        this.flowerid = flowerid;
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
}