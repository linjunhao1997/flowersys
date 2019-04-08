package com.junhow.gp.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.*;

public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bug;

    private String proposal;

    private String priority;

    private String username;

    private String contactnumber;

    private String email;

    @Getter
    @Setter
    private String resolved;

    @Column(name = "gmt_create")
    private Date gmtCreate;

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
     * @return bug
     */
    public String getBug() {
        return bug;
    }

    /**
     * @param bug
     */
    public void setBug(String bug) {
        this.bug = bug;
    }

    /**
     * @return proposal
     */
    public String getProposal() {
        return proposal;
    }

    /**
     * @param proposal
     */
    public void setProposal(String proposal) {
        this.proposal = proposal;
    }

    /**
     * @return priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return contactnumber
     */
    public String getContactnumber() {
        return contactnumber;
    }

    /**
     * @param contactnumber
     */
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
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