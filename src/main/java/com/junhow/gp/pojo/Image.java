package com.junhow.gp.pojo;

import java.util.Date;
import javax.persistence.*;

public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imgid;

    private String src;

    private String alt;

    private Integer flowerid;

    private String defaultimg;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * @return id
     */
    public Integer getImgid() {
        return imgid;
    }

    /**
     * @param id
     */
    public void setImgid(Integer id) {
        this.imgid = imgid;
    }

    /**
     * @return src
     */
    public String getSrc() {
        return src;
    }

    /**
     * @param src
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     * @param alt
     */
    public void setAlt(String alt) {
        this.alt = alt;
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
     * @return defaultimg
     */
    public String getDefaultimg() {
        return defaultimg;
    }

    /**
     * @param defaultimg
     */
    public void setDefaultimg(String defaultimg) {
        this.defaultimg = defaultimg;
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