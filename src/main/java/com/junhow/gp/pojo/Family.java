package com.junhow.gp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer orderid;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    private String title;

    private String parentid;

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
     * @return orderid
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * @param orderid
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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
     * @return parentid
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * @param parentid
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
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