package com.junhow.gp.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author linjunhao
 * @description
 * @createDate 2019/2/22 13:36
 */
public class FlowerImageDto {
    private Integer id;
    @Getter
    @Setter
    private String phylumname;

    @Getter
    @Setter
    private String classname;

    @Getter
    @Setter
    private String ordername;

    @Getter
    @Setter
    private String familyname;

    @Getter
    @Setter
    private String genusname;

    @Getter
    @Setter
    private String speciesname;

    @Getter
    @Setter
    private String subspeciesname;

    private String name;

    @Getter
    @Setter
    private String latinname;

    private String description;

    @Getter
    @Setter
    private Integer imgid;

    private String src;

    private String alt;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
